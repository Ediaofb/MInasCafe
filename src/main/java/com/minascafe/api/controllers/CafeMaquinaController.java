package com.minascafe.api.controllers;

import com.minascafe.api.entities.CafeMaquina;
import com.minascafe.api.record.DadosAtualizacaoCafeMaquina;
import com.minascafe.api.record.DadosCadastroCafeMaquina;
import com.minascafe.api.record.DadosListagemCafeMaquina;
import com.minascafe.api.repositories.CafeMaquinaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cafemaquina")
public class CafeMaquinaController {

    @Autowired
    private CafeMaquinaRepository cafe_maquina; //Injetando o Repository como sendo um atributo

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCafeMaquina cm){
      cafe_maquina.save(new CafeMaquina(cm));

      System.out.println("Lote de café em côco salvo no banco com sucesso!");
    }

    @GetMapping //listagem de Café Máquina ativo
    public Page<DadosListagemCafeMaquina> Listar(Pageable paginacao){//Devolve uma lista de Café Maquina e informações sobre a paginação. É apenas leitura, não precisa da anotação @Transactional
      return cafe_maquina.findAllByAtivoTrue(paginacao).map(DadosListagemCafeMaquina::new); //map = converte entidade cafe_maquina para o objeto DTO
    }


    @GetMapping("/baixado") //listagem de Café Máquina deletado (inativo)
    public Page<DadosListagemCafeMaquina> Cancelado(Pageable paginacao){
        return cafe_maquina.findAllByAtivoFalse(paginacao).map(DadosListagemCafeMaquina::new);
    }

    /*@GetMapping("/{lote}")
    public ResponseEntity<CafeMaquina> localizar(@PathVariable int lote) { //No PathVariable o parâmetro é passado diretamente no corpo da requisição e esse valor faz parte do corpo da requisição
        CafeMaquina cam = cafe_maquina.findByLote(lote);
        return ResponseEntity.ok().body(cam);
    }*/

    @GetMapping("/lote") //listagem de lotes de Café Máquina ativos
    public ResponseEntity<List<CafeMaquina>> localizar(@PathVariable int lote){
        List<CafeMaquina> cam = cafe_maquina.findByLoteAndAtivoTrue(lote);
        return ResponseEntity.ok().body(cam);
    }

    //@GetMapping("/lote")

    @PutMapping //Realiza atualizações (Update) no cadastro
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCafeMaquina cm) {
        var maquina = cafe_maquina.getReferenceById(cm.lote());
        maquina.atualizarInformacoes(cm);
    }

    @DeleteMapping("{lote}")
    @Transactional
    public void inativar(@PathVariable int lote)
    {
        var maq = cafe_maquina.getReferenceById(lote);
        maq.inativo();
    }
}