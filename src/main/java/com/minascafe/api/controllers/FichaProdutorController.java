package com.minascafe.api.controllers;

import com.minascafe.api.entities.FichaProdutor;
import com.minascafe.api.record.DadosFichaProdutor;
import com.minascafe.api.repositories.FichaProdutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Endpoint (página web) de Controller
@RequestMapping(value = "produtor") //Define a url da classe
public class FichaProdutorController {
    @Autowired
    private FichaProdutorRepository prod; //Injetando o Repository como sendo um atributo

//    @Autowired
//    FichaProdutorService ficha;

    @RequestMapping(value = "/nome/{nome}") //Retorna uma ficha de produtor em BUSCA POR NOME
      public ResponseEntity<FichaProdutor> buscar(@PathVariable String nome){ //PathVariable obtém o conteúdo que vem após a última barra e trata a requisição
      FichaProdutor obj = prod.findByNome(nome);
      return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/id/{id}") //Retorna uma ficha de produtor em BUSCA POR UM ID
    public ResponseEntity<FichaProdutor> retornar(@PathVariable int id){ //PathVariable obtém o conteúdo que vem após a última barra e trata a requisição
    FichaProdutor fic = prod.findById(id);
    return ResponseEntity.ok().body(fic);
    }

    @PostMapping
    @Transactional //Unidade de trabalho isolada que leva o banco de dados de um estado consistente a outro estado consistente
    public void cadastrar(@RequestBody @Valid DadosFichaProdutor fp){
      prod.save(new FichaProdutor(fp));
    }
}