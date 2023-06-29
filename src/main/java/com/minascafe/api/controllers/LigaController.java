package com.minascafe.api.controllers;

import com.minascafe.api.entities.Liga;
import com.minascafe.api.record.DadosCadastroLiga;
import com.minascafe.api.repositories.LigaRepository;
import com.minascafe.api.services.LigaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/liga")
public class LigaController {

    @Autowired
    private LigaRepository ligar; //Injetando o Repository como sendo um atributo

    @PostMapping //Grava um registro de Café em Côco
    @Transactional //Unidade de trabalho isolada que leva o banco de dados de um estado consistente a outro estado consistente
    public void cadastrarLiga(@Valid @RequestBody DadosCadastroLiga dcl){
        ligar.save(new Liga(dcl));
        System.out.println("Liga salva no banco de dados com sucesso!");
    }
}
