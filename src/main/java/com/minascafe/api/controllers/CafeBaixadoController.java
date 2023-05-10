package com.minascafe.api.controllers;

import com.minascafe.api.record.DadosCadastroCafeBaixado;
import com.minascafe.api.record.DadosListagemCafeBaixado;
import com.minascafe.api.repositories.CafeBaixadoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

 //Injetando o Repository como sendo um atributo

@RestController//Endpoint (página web) de Controller
@RequestMapping("cafebaixado")//Define a url da classe
public class CafeBaixadoController {

    @Autowired
    private CafeBaixadoRepository cafe_baixado; //Injetando o Repository como sendo um atributo

    @GetMapping
    public Page<DadosListagemCafeBaixado>Listar(Pageable paginacao){//Devolve uma lista de Café Baixado e informações sobre a paginação. É apenas leitura, não precisa da anotação @Transactional
      return cafe_baixado.findAll(paginacao).map(DadosListagemCafeBaixado::new);//map = Mapeamento. Converte uma lista de CafeCoco para uma lista de DadosListagemCafeCoco. stream() = controle de fluxo de dados. Abstração para expressar operações eficientes do estilo SQL em relação a uma coleção de dados
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCafeBaixado cb){

    }
}