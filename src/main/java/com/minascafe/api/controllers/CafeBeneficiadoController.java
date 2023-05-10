package com.minascafe.api.controllers;

import com.minascafe.api.entities.CafeBeneficiado;
import com.minascafe.api.record.DadosAtualizacaoCafeBeneficiado;
import com.minascafe.api.record.DadosCadastroCafeBeneficiado;
import com.minascafe.api.record.DadosListagemCafeBeneficiado;
import com.minascafe.api.repositories.CafeBeneficiadoRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController//Endpoint (página web) de Controller
@RequestMapping("cafebeneficiado") //Define a url da classe
public class CafeBeneficiadoController {

    public static final Logger log = LoggerFactory.getLogger(CafeBeneficiadoController.class);

    @Autowired
    private CafeBeneficiadoRepository cafe_beneficiado; //Injetando o Repository como sendo um atributo

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCafeBeneficiado cb){
       cafe_beneficiado.save(new CafeBeneficiado(cb));

       System.out.println("Lote de café beneficiado salvo no banco com sucesso!");
    }

    @GetMapping
    public Page<DadosListagemCafeBeneficiado>Listar(Pageable paginacao){
      return cafe_beneficiado.findAll(paginacao).map(DadosListagemCafeBeneficiado::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCafeBeneficiado db){
        var beneficiado = cafe_beneficiado.getReferenceById(db.lote());
        beneficiado.atualizarInformacoes(db);
    }
}