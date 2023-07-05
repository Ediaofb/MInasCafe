package com.minascafe.api.controllers;

import com.minascafe.api.entities.CafeBeneficiado;
import com.minascafe.api.entities.Liga;
import com.minascafe.api.record.DadosAtualizacaoLiga;
import com.minascafe.api.record.DadosCadastroLiga;
import com.minascafe.api.record.DadosListagemLiga;
import com.minascafe.api.repositories.CafeBeneficiadoRepository;
import com.minascafe.api.repositories.CafeMaquinaRepository;
import com.minascafe.api.repositories.LigaRepository;
import com.minascafe.api.services.LigaService;
import jakarta.validation.Valid;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/liga")
public class LigaController {

    @Autowired
    private LigaRepository ligar; //Injetando o Repository como sendo um atributo
    @Autowired
    private CafeBeneficiadoRepository cbr;
    @Autowired
    private CafeMaquinaRepository cmr;
    @Autowired
    private LigaService lgs;

    /*@PostMapping //Grava um registro de Café em Côco
    @Transactional //Unidade de trabalho isolada que leva o banco de dados de um estado consistente a outro estado consistente
    public void cadastrarLiga(@Valid @RequestBody DadosCadastroLiga dcl){
        ligar.save(new Liga(dcl));
        System.out.println("Liga salva no banco de dados com sucesso!");
    }*/

    @PostMapping //Cadastra uma liga e
    public ResponseEntity<Liga> criarLiga(@RequestBody DadosCadastroLiga dadosCadastroLiga){
        Liga liga = new Liga(dadosCadastroLiga); // Cria a instância de Liga com os dados recebidos

        for(String lote : liga.getLotes()){
           if (lote.startsWith("M-")){ //Se for Café Máquina
               lgs.removerLotesCafeMaquina(Collections.singletonList(lote));
           } else if (lote.startsWith("E-")) { //Se for Café Beneficiado
               lgs.removerLotesCafeBeneficiado(Collections.singletonList(lote));
           }
        }
        liga = lgs.persistir(liga);

        return ResponseEntity.ok(liga);
    }
    /*@PostMapping("/lotes")
    public ResponseEntity<?> receberLotes(@RequestBody List<String> lotes){ //recebendo os lotes no corpo da requisição
      try{
          Liga liga = ligar.findById(1);
          String a;
          int in;

          for (String lote : lotes){ //para cada lote presente na lista lotes, faça
           if(lote.startsWith("E")){ //se a primeira posição da string lote for "E"
              a = lote.substring(1); //a = lote sem o "E"
               if(a.startsWith("-")){ //Se "a" inicia com "-"
                   a = a.substring(1); //remove o "-"
               }
           }else if (lote.startsWith("M")){ //se o lote inicia com "M"
             a = lote.substring(1);
              if(a.startsWith("-")){
                  a = a.substring(1);
              }
           } else{
              continue;
           }
            CafeBeneficiado cafeBeneficiado = cbr.findByLote(a);
          }
         }catch(Exception E){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao receber lotes!");
      }
        return ResponseEntity.ok().build();
    }*/

    @GetMapping //Lista todos as Ligas existentes
    public List<Liga> listar(){
        return ligar.findAll();
    }

    @GetMapping("/{lote}") //listagem de liga por lotes
    public ResponseEntity<Liga> buscar(@PathVariable String lote){
       Liga l = ligar.findByLotes(lote);
       return ResponseEntity.ok().body(l); //Retorno no corpo da requisição
    }

    @GetMapping("/data") //Lista Ligas por data
    public ResponseEntity<Liga> PesquisarPorData(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data){
       Liga l = ligar.findBydata(data);
       return ResponseEntity.ok().body(l);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoLiga dal){
        var lig = ligar.getReferenceById(dal.id());
        lig.atualizarLiga(dal);
    }
}