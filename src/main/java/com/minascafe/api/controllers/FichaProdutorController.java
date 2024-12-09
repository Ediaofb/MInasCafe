package com.minascafe.api.controllers;

import com.minascafe.api.dtos.FichaProdutorDto;
import com.minascafe.api.entities.FichaProdutor;
import com.minascafe.api.record.DadosAtualizacaoFichaProdutor;
import com.minascafe.api.record.DadosCadastroFichaProdutor;
import com.minascafe.api.record.DadosListagemFichaProdutor;
import com.minascafe.api.repositories.FichaProdutorRepository;
import com.minascafe.api.services.FichaProdutorService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController // Endpoint (página web) de Controller
// @CrossOrigin /* (origins = "http://localhost:3000") */
@RequestMapping(value = "produtor") // Define a url da classe
public class FichaProdutorController {
    @Autowired
    private FichaProdutorRepository prod; // Injetando o Repository como sendo um atributo

    @Autowired
    FichaProdutorService ficha;

    @CrossOrigin
    @PostMapping // Grava um registro no banco
    @Transactional // Unidade de trabalho isolada que leva o banco de dados de um estado
                   // consistente a outro estado consistente
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroFichaProdutor fp) {
        prod.save(new FichaProdutor(fp));
        System.out.print("Cadastro de produtor salvo no banco com sucesso!");

        return ResponseEntity.ok("Ficha de Produtor cadastrada com sucesso!");
    }

    @CrossOrigin
    @GetMapping
    public Page<DadosListagemFichaProdutor> listar(Pageable paginacao) {// Devolve uma lista de Produtores e informações
                                                                        // sobre a paginação. É apenas leitura, não
                                                                        // precisa da anotação @Transactional
        return prod.findAll(paginacao).map(DadosListagemFichaProdutor::new);// map = Mapeamento. Converte uma lista de
                                                                            // FichaProdutor para uma lista de
                                                                            // DadosListagemFichaProdutor. stream() =
                                                                            // controle de fluxo de dados. Abstração
                                                                            // para expressar operações eficientes do
                                                                            // estilo SQL em relação a uma coleção de
                                                                            // dados
    }

    @CrossOrigin
    @GetMapping("/filter") // Realiza busca de ficha produtor filtrando por qualquer quantidade de letras
    public ResponseEntity <List<FichaProdutor>> findFichaByNome(@RequestParam String nome) { //Retorna uma lista por permitir consultar por nomes parciais
        System.out.println("name = " + nome);
        List <FichaProdutor> objs = prod.findByNomeContains(nome);
        return ResponseEntity.ok().body(objs);
    }

    @CrossOrigin
    @RequestMapping(value = "/nome/{nome}") // Retorna uma ficha de produtor em BUSCA POR NOME
    public ResponseEntity<FichaProdutor> buscar(@PathVariable String nome) { // PathVariable obtém o conteúdo que vem
                                                                             // após a última barra e trata a requisição
        FichaProdutor obj = prod.findByNome(nome);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin
    @RequestMapping(value = "/id/{id}") // Retorna uma ficha de produtor em BUSCA POR UM ID
    public ResponseEntity<FichaProdutor> retornar(@PathVariable int id) { // PathVariable obtém o conteúdo que vem após
                                                                          // a última barra e trata a requisição
        FichaProdutor fic = prod.findById(id);
        return ResponseEntity.ok().body(fic);
    }

    @CrossOrigin
    @PutMapping // Realiza atualizações (Update) no cadastro
    @Transactional // Para fazer escrita no banco de dados de forma efetiva
    public void atualizar(@RequestBody @Valid DadosAtualizacaoFichaProdutor fb) {
        var produtor = prod.findByNome(fb.nome());
        produtor.atualizarInformacoes(fb);
    }

    @DeleteMapping("{nome}")
    @Transactional
    public ResponseEntity<String> deletarPorNome(@PathVariable String nome) {
        prod.deleteByNome(nome);
        return ResponseEntity.ok("Produtor deletado com sucesso!");
    }
}