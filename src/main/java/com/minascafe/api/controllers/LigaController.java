package com.minascafe.api.controllers;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.minascafe.api.entities.Liga;
import com.minascafe.api.record.DadosAtualizacaoLiga;
import com.minascafe.api.record.DadosCadastroLiga;
import com.minascafe.api.repositories.CafeBeneficiadoRepository;
import com.minascafe.api.repositories.CafeMaquinaRepository;
import com.minascafe.api.repositories.LigaRepository;
import com.minascafe.api.services.LigaService;
import jakarta.persistence.Persistence;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/liga")
public class LigaController {

    @Autowired
    private LigaRepository ligar; //Injetando o Repository como sendo um atributo
    @Autowired
    private LigaService lgs;
    @Autowired
    private CafeBeneficiadoRepository cbr;
    @Autowired
    private CafeMaquinaRepository cmr;

    /*@PostMapping //Grava um registro de Café em Côco
    @Transactional //Unidade de trabalho isolada que leva o banco de dados de um estado consistente a outro estado consistente
    public void cadastrarLiga(@Valid @RequestBody DadosCadastroLiga dcl){
        ligar.save(new Liga(dcl));
        System.out.println("Liga salva no banco de dados com sucesso!");
    }*/

    @PostMapping //Cadastra uma liga e
    public ResponseEntity<Liga> criarLiga(@RequestBody DadosCadastroLiga dadosCadastroLiga){//Retorna uma liga, adquirindo nom corpo da requisição dados de uma liga
        Liga liga = new Liga(dadosCadastroLiga); // Cria a instância de Liga com os dados recebidos

        for(String lote : liga.getLotes()) { //Para cada lote em lotes...
            lgs.marcarLotesComoInativos(lote);//Marca os lotes utilizados como inativos
        }
        liga = lgs.persistir(liga); //Persistence a liga no banco de dados

        return ResponseEntity.ok(liga); //Retorna a liga no corpo da resposta
    }

    @GetMapping //Lista todas as Ligas existentes
    public List<Liga> listar(){
        return ligar.findAll();
    }

    @GetMapping("/{lote}")
    public ResponseEntity<?> listarPorLote(@PathVariable String lote){
        Liga liga = ligar.findByLotes(lote);
        if (liga != null) {
            return ResponseEntity.ok(liga);
        } else {
            String mensagem = "Liga não encontrada para este lote";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    /*@GetMapping("/{lote}")//listagem de lotes de Liga por lote
    public Liga listarPorLote(@PathVariable String lote){
        return ligar.findByLotes(lote);
    }*/

    @GetMapping("/data/{data}")
    public List<Liga> buscarPorData(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data){
        List<Liga> ligas = ligar.findBydata(data);
        return ligar.findBydata(data);
    }

    /*@GetMapping("/data") //Lista Ligas por data
    public ResponseEntity<Liga> PesquisarPorData(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data){
       Liga l = ligar.findBydata(data);
       if(l != null) {
           return ResponseEntity.ok().body(l);
       } else {
           return ResponseEntity.notFound().build();
       }
    }*/

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoLiga dal){
        var lig = ligar.getReferenceById(dal.id());
        lig.atualizarLiga(dal);
    }
}