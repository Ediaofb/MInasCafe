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
import java.util.stream.Collectors;

@RestController
@CrossOrigin /* (origins = "http://localhost:3000") */
@RequestMapping("cafemaquina")
public class CafeMaquinaController {

    @Autowired
    private CafeMaquinaRepository cafemaquinaRepository; // Injetando o Repository como sendo um atributo

    @CrossOrigin
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCafeMaquina cm) {
        cafemaquinaRepository.save(new CafeMaquina(cm));

        System.out.println("Lote de café máquina salvo no banco com sucesso!");
    }

    @CrossOrigin
    @GetMapping // listagem de Café Máquina
    public ResponseEntity<List<CafeMaquina>> recuperar() {
        List<CafeMaquina> maq = cafemaquinaRepository.findAll();
        return ResponseEntity.ok().body(maq);
    }

    /*
     * @GetMapping //listagem de Café Máquina
     * public List<DadosListagemCafeMaquina> Listar() {
     * return
     * cafemaquinaRepository.findAll().stream().map(DadosListagemCafeMaquina::new).
     * collect(Collectors.toList());
     * }
     */

    /*
     * @GetMapping //listagem de Café Máquina ativo
     * public Page<DadosListagemCafeMaquina> Listar(Pageable paginacao){//Devolve
     * uma lista de Café Maquina e informações sobre a paginação. É apenas leitura,
     * não precisa da anotação @Transactional
     * return cafemaquinaRepository.findAllByAtivoTrue(paginacao).map(
     * DadosListagemCafeMaquina::new); //map = converte entidade
     * cafemaquinaRepository para o objeto DTO
     * }
     */

    @CrossOrigin
    @GetMapping("/baixado") // listagem de Café Máquina deletado (inativo)
    public Page<DadosListagemCafeMaquina> Cancelado(Pageable paginacao) {
        return cafemaquinaRepository.findAllByAtivoFalse(paginacao).map(DadosListagemCafeMaquina::new);
    }

    @CrossOrigin
    @GetMapping("/produtor/{produtor}")
    public ResponseEntity<List<CafeMaquina>> buscaCafeMaquina(@PathVariable String produtor) {
        List<CafeMaquina> maq = cafemaquinaRepository.findByProdutor(produtor);
        return ResponseEntity.ok().body(maq);
    }

    @CrossOrigin
    @GetMapping("{lote}") // listagem de lotes de Café Máquina "ativos"
    public ResponseEntity<List<CafeMaquina>> localizar(@PathVariable int lote) {
        List<CafeMaquina> cam = cafemaquinaRepository.findByLoteAndAtivoTrue(lote);
        return ResponseEntity.ok().body(cam);
    }

    @CrossOrigin
    @PutMapping // Realiza atualizações (Update) no cadastro
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCafeMaquina cm) {
        var maquina = cafemaquinaRepository.getReferenceById(cm.lote());
        maquina.atualizarInformacoes(cm);
    }

    @CrossOrigin
    @DeleteMapping("{lote}")
    @Transactional
    public void inativar(@PathVariable int lote) {
        var maq = cafemaquinaRepository.getReferenceById(lote);
        maq.inativar();
    }
}