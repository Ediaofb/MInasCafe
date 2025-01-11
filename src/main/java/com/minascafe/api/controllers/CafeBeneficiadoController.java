package com.minascafe.api.controllers;

import com.minascafe.api.dtos.CafeBeneficiadoDto;
import com.minascafe.api.dtos.FichaProdutorDto;
import com.minascafe.api.entities.CafeBeneficiado;
import com.minascafe.api.entities.FichaProdutor;
import com.minascafe.api.record.DadosAtualizacaoCafeBeneficiado;
import com.minascafe.api.record.DadosCadastroCafeBeneficiado;
import com.minascafe.api.record.DadosListagemCafeBeneficiado;
import com.minascafe.api.record.TotalAtivosResponse;
import com.minascafe.api.repositories.CafeBeneficiadoRepository;
import jakarta.validation.Valid;
import org.hibernate.mapping.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@RestController // Endpoint (página web) de Controller
@RequestMapping("cafebeneficiado") // Define a url da classe
// @CrossOrigin(origins = "*", methods = { RequestMethod.GET,
// RequestMethod.POST, RequestMethod.PUT })
public class CafeBeneficiadoController {

    public static final Logger log = LoggerFactory.getLogger(CafeBeneficiadoController.class);

    @Autowired
    private CafeBeneficiadoRepository cafeBeneficiadoRepository; // Injetando o Repository como sendo um atributo

    
    @CrossOrigin
    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastroCafeBeneficiado cb) {
        cafeBeneficiadoRepository.save(new CafeBeneficiado(cb));

        System.out.println("Lote de café beneficiado salvo no banco com sucesso!");

        String responseMessage = "Lote de Café Beneficiado cadastrado com sucesso!";
        return ResponseEntity.ok(responseMessage);
    }

    @GetMapping // Listagem de Café Beneficiado
    @CrossOrigin
    public ResponseEntity<List<CafeBeneficiado>> listar() {
        List<CafeBeneficiado> caf = cafeBeneficiadoRepository.findAll();
        return ResponseEntity.ok().body(caf);
    }

    /*
     * @GetMapping //Listagem de Café Beneficiado ativo paginado
     * public Page<DadosListagemCafeBeneficiado>Listar(Pageable paginacao){ 
     * return cafeBeneficiadoRepository.findAllByAtivoTrue(paginacao).map(  
     * DadosListagemCafeBeneficiado::new);
     * }    
     */
    
     
    @CrossOrigin
    @GetMapping("/totais-ativos")
    public ResponseEntity<TotalAtivosResponse> calcularTotais() {
     //Busca todos os lotes com ativo = true 
     List<CafeBeneficiado> lotesAtivos = cafeBeneficiadoRepository.findAllByAtivoTrue(Pageable.unpaged()).getContent();

     //Soma os quilos como double
     double totalQuilos = lotesAtivos.stream().mapToDouble(CafeBeneficiado::getQuilos).sum();
     int totalSacasExistentes = lotesAtivos.stream().mapToInt(CafeBeneficiado::getSacas).sum();

     //Calcula as sacas adicionais e os quilos restantes
     int sacasAdicionais = (int) (totalQuilos / 60); //Convertendo para int apenas a parte inteira
     float quilosRestantes = (float) (totalQuilos % 60); // Restante em float para maior precisão 
     int sacasTotais = totalSacasExistentes + sacasAdicionais;

     // Cria a resposta
     TotalAtivosResponse resposta = new TotalAtivosResponse(sacasTotais, quilosRestantes);
     return ResponseEntity.ok(resposta);
    }
    
    @GetMapping("/baixado") // listagem de Café Beneficiado deletado (inativo)
    @CrossOrigin
    public Page<DadosListagemCafeBeneficiado> Baixa(Pageable paginacao) {
        return cafeBeneficiadoRepository.findAllByAtivoFalse(paginacao).map(DadosListagemCafeBeneficiado::new);
    }

    @CrossOrigin
    @GetMapping("{lote}") // listagem de lotes de Café Beneficiado "ativos"
    public ResponseEntity<List<CafeBeneficiado>> encontrar(@PathVariable int lote) {// No PathVariable o parâmetro é
                                                                                    // passado diretamente no corpo da
                                                                                    // requisição e esse valor faz parte
                                                                                    // do corpo da requisição
        List<CafeBeneficiado> ben = cafeBeneficiadoRepository.findByLoteAndAtivoTrue(lote);
        return ResponseEntity.ok().body(ben);
    }

    @GetMapping("/produtor/{produtor}")
    @CrossOrigin
    public ResponseEntity<List<CafeBeneficiado>> busca_produtor(@PathVariable String produtor) {
        List<CafeBeneficiado> caf = cafeBeneficiadoRepository.findByProdutor(produtor);
        return ResponseEntity.ok().body(caf);
    }

    @CrossOrigin
    @GetMapping("/filter") // Realiza busca de ficha produtor filtrando por qualquer quantidade de letras
    public ResponseEntity <List<CafeBeneficiado>> findBeneficiadoByNome(@RequestParam String produtor) { //Retorna uma lista por permitir consultar por nomes parciais
        System.out.println("produtor = " + produtor);
        List <CafeBeneficiado> objs = cafeBeneficiadoRepository.findByProdutorContains(produtor);
        return ResponseEntity.ok().body(objs);
    }

    @CrossOrigin
    @GetMapping("/filter/meieiro") //endpoint para buscar por meieiro
    public ResponseEntity <List<CafeBeneficiado>> findbeneficiadobymeieiro(@RequestParam String meieiro) {
       System.out.println("meieiro = " +meieiro);
       List <CafeBeneficiado> ca = cafeBeneficiadoRepository.findByMeieiroContains(meieiro);
       return ResponseEntity.ok().body(ca);
    }   
    
    @CrossOrigin
    @PutMapping // Realiza atualizações (Update) no cadastro
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCafeBeneficiado db) {
        System.out.println("Atualizando lote: "+db.lote() + ", ativo: " + db.ativo());
        var beneficiado = cafeBeneficiadoRepository.getReferenceById(db.lote());
        beneficiado.atualizarInformacoes(db);
        cafeBeneficiadoRepository.flush(); // Garante que a transação seja persistida
    }
}