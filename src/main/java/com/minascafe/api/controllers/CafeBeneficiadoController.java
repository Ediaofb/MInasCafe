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
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController//Endpoint (página web) de Controller
@RequestMapping("cafebeneficiado") //Define a url da classe
public class CafeBeneficiadoController {

    public static final Logger log = LoggerFactory.getLogger(CafeBeneficiadoController.class);

    @Autowired
    private CafeBeneficiadoRepository cafeBeneficiadoRepository; //Injetando o Repository como sendo um atributo

    @Autowired
    private CafeBeneficiado cafeBeneficiado;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCafeBeneficiado cb){
       cafeBeneficiadoRepository.save(new CafeBeneficiado(cb));

       System.out.println("Lote de café beneficiado salvo no banco com sucesso!");
    }

    @GetMapping //Listagem de Café Beneficiado ativo
    public Page<DadosListagemCafeBeneficiado>Listar(Pageable paginacao){
      return cafeBeneficiadoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemCafeBeneficiado::new);
    }

    @GetMapping("/baixado") //listagem de Café Beneficiado deletado (inativo)
    public Page<DadosListagemCafeBeneficiado> Baixa(Pageable paginacao){
        return cafeBeneficiadoRepository.findAllByAtivoFalse(paginacao).map(DadosListagemCafeBeneficiado::new);
    }

    @GetMapping("/{lote}") //listagem de lotes de Café Beneficiado "ativos"
    public ResponseEntity <List<CafeBeneficiado>> encontrar(@PathVariable int lote){//No PathVariable o parâmetro é passado diretamente no corpo da requisição e esse valor faz parte do corpo da requisição
       List<CafeBeneficiado> ben = cafeBeneficiadoRepository.findByLoteAndAtivoTrue(lote);
       return ResponseEntity.ok().body(ben);
    }

    @GetMapping("/produtor/{produtor}")
    public ResponseEntity <List<CafeBeneficiado>> busca_produtor(@PathVariable String produtor){
        List<CafeBeneficiado> caf  = cafeBeneficiadoRepository.findByProdutor(produtor);
        return ResponseEntity.ok().body(caf);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCafeBeneficiado db){
        var beneficiado = cafeBeneficiadoRepository.getReferenceById(db.lote());
        beneficiado.atualizarInformacoes(db);
    }
}