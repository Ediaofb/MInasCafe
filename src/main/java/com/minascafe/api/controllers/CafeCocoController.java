package com.minascafe.api.controllers;

import com.minascafe.api.entities.CafeCoco;
import com.minascafe.api.record.AtualizacaoStatusRequest;
import com.minascafe.api.record.DadosAtualizacaoCafeCoco;
import com.minascafe.api.record.DadosCadastroCafeCoco;
import com.minascafe.api.record.DadosListagemCafeCoco;
import com.minascafe.api.repositories.CafeCocoRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController // Endpoint (página web) de Controller
@RequestMapping("cafecoco") // Define a url da classe
public class CafeCocoController {

    public static final Logger log = LoggerFactory.getLogger(CafeCocoController.class);// O log pode ser útil para
                                                                                       // acompanhar o fluxo de
                                                                                       // execução, identificar
                                                                                       // problemas e analisar o
                                                                                       // comportamento do aplicativo.
    // Através do logger, é possível registrar informações, avisos, erros e outras
    // mensagens relevantes durante a execução do código.
    @Autowired
    private CafeCocoRepository cafe_coco; // Injetando o Repository como sendo um atributo

    @CrossOrigin
    @PostMapping // Grava um registro de Café em Côco
    @Transactional // Unidade de trabalho isolada que leva o banco de dados de um estado
                   // consistente a outro estado consistente
    public void cadastrar(@RequestBody @Valid DadosCadastroCafeCoco cc) { // RequestBody = Busca do corpo da requisição
        cafe_coco.save(new CafeCoco(cc)); // Salva um novo objeto entidade JPA do tipo CafeCoco passando os
        // parâmetros que vêm do Json da requisição no construtor da Entidade CafeCoco

        System.out.print("Lote de café em côco salvo no banco com sucesso!");
    }

    @CrossOrigin
    @GetMapping // Listagem de Café em Côco
    public ResponseEntity<List<CafeCoco>> listar() {
        List<CafeCoco> coq = cafe_coco.findAll();
        return ResponseEntity.ok().body(coq);
    }
    
    @CrossOrigin
    @GetMapping("/filter") // Realiza busca de ficha produtor filtrando por qualquer quantidade de letras
    public ResponseEntity <List<CafeCoco>> findCocoBynome(@RequestParam String produtor) { //Retorna uma lista por permitir consultar por nomes parciais
        System.out.println("Produtor:" + produtor);
        List <CafeCoco> co = cafe_coco.findByProdutorContains(produtor);
        return ResponseEntity.ok().body(co);
    }

    @CrossOrigin
    @GetMapping("/filter/meieiro") //endpoint para buscar por meieiro
    public ResponseEntity <List<CafeCoco>> findCocoByMeieiro(@RequestParam String meieiro) {
        System.out.println("meieiro: " +meieiro);
        List <CafeCoco> cc = cafe_coco.findByMeieiroContains(meieiro);
        return ResponseEntity.ok().body(cc);
    }

    @CrossOrigin
    @GetMapping("/baixado") // listagem de Café em Côco deletado (inativo)
    public Page<DadosListagemCafeCoco> Cancelado(Pageable paginacao) {
        return cafe_coco.findAllByAtivoFalse(paginacao).map(DadosListagemCafeCoco::new);
    }

    @CrossOrigin
    @GetMapping("/{lote}") // listagem de lotes de café em côco ativos
    public ResponseEntity<List<CafeCoco>> buscar(@PathVariable int lote) { // No PathVariable o parâmetro é passado
                                                                           // diretamente no corpo da requisição e esse
                                                                           // valor faz parte do corpo da requisição
        List<CafeCoco> caf = cafe_coco.findByLoteAndAtivoTrue(lote);
        return ResponseEntity.ok().body(caf);
    }

    @CrossOrigin
    @PutMapping // Realiza atualizações (Update) no cadastro
    @Transactional // Para fazer escrita no banco de dados de forma efetiva
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCafeCoco da) {
        var cafe = cafe_coco.getReferenceById(da.lote()); // Carrega o cadastro do café em coco pelo lote que está vindo
                                                          // pelo DTO
        cafe.atualizarInformacoes(da); // Chama os métodos para atualizar os dados baseado no DTO
    }

    @CrossOrigin
    @PutMapping("/atualizar-status") // Realiza atualização de status no cadastro
    @Transactional
    public void atualizarStatusLotes(@RequestBody AtualizacaoStatusRequest request) {
        List<String> referenciaLotes = request.getReferenciaLotes();
        String novoStatus = request.getNovoStatus();

        for (String referencia : referenciaLotes) {
            List<CafeCoco> lotes = cafe_coco.findByReferenciaAndAtivoTrue(referencia);
            for (CafeCoco lote : lotes) {
                lote.setStatus(novoStatus);
                cafe_coco.save(lote);
            }
        }
    }

    @CrossOrigin
    @DeleteMapping("{lote}")
    @Transactional
    public void inativar(@PathVariable int lote) {
        var cafe = cafe_coco.getReferenceById(lote); // Carrega o cadastro do café em coco pelo lote que está vindo pelo
                                                     // DTO
        cafe.inativo();
    }
}