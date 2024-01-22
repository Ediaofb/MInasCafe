package com.minascafe.api.controllers;

import com.minascafe.api.entities.AmostraSemEstoque;
import com.minascafe.api.record.DadosCadastroAmostraSemEstoque;
import com.minascafe.api.repositories.AmostraRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("amostra")
// @CrossOrigin(origins = "http://localhost:3000")
public class AmostraController {

    public static final Logger log = LoggerFactory.getLogger(AmostraController.class);

    @Autowired
    private AmostraRepository amostraRepository; // Injetando o Repository como sendo um atributo

    @PostMapping
    @Transactional
    public void registrar(@RequestBody @Valid DadosCadastroAmostraSemEstoque am) {
        amostraRepository.save(new AmostraSemEstoque(am));// Salva um novo objeto entidade JPA do tipo AmostraSemEstoque
                                                          // passando os
        // parâmetros que vêm do Json da requisição no construtor da Entidade
        // AmostraSemEstoque

        System.out.print("Amostra sem estoque salva no banco com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<AmostraSemEstoque>> recuperar() {
        List<AmostraSemEstoque> amo = amostraRepository.findAll();
        return ResponseEntity.ok().body(amo);
    }

    @GetMapping("/produtor/{produtor}")
    public ResponseEntity<List<AmostraSemEstoque>> busca_amostra(@PathVariable String produtor) {
        List<AmostraSemEstoque> am = amostraRepository.findByProdutor(produtor);
        return ResponseEntity.ok().body(am);
    }

    @GetMapping("/data/{data}")
    public List<AmostraSemEstoque> buscarPorData(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        List<AmostraSemEstoque> amos = amostraRepository.findByData(data);
        return ResponseEntity.ok().body(amos).getBody();
    }
}