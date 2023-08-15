package com.minascafe.api.controllers;

import com.minascafe.api.entities.CafeCoco;
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
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController //Endpoint (página web) de Controller
@RequestMapping("cafecoco") //Define a url da classe
@CrossOrigin(origins = "http://localhost:3000") //Permitindo a requisição do endereço e porta do frontend
public class CafeCocoController {

    public static final Logger log = LoggerFactory.getLogger(CafeCocoController.class);//O log pode ser útil para acompanhar o fluxo de execução, identificar problemas e analisar o comportamento do aplicativo.
    //Através do logger, é possível registrar informações, avisos, erros e outras mensagens relevantes durante a execução do código.
    @Autowired
    private CafeCocoRepository cafe_coco; //Injetando o Repository como sendo um atributo

    @PostMapping //Grava um registro de Café em Côco
    @Transactional //Unidade de trabalho isolada que leva o banco de dados de um estado consistente a outro estado consistente
    public void cadastrar(@RequestBody @Valid DadosCadastroCafeCoco cc){ //RequestBody = Busca do corpo da requisição
        cafe_coco.save(new CafeCoco(cc)); //Salva um novo objeto entidade JPA do tipo CafeCoco passando os
        // parâmetros que vêm do Json da requisição no construtor da Entidade CafeCoco

        System.out.print("Lote de café em côco salvo no banco com sucesso!");
    }

    @GetMapping //Listagem de Café em Côco Ativo
    public Page<DadosListagemCafeCoco> listar(Pageable paginacao){//Devolve uma lista de Café em Côco e informações sobre a paginação. É apenas leitura, não precisa da anotação @Transactional
      return cafe_coco.findAllByAtivoTrue(paginacao).map(DadosListagemCafeCoco::new);//map = Mapeamento. Converte uma lista de CafeCoco para uma lista de DadosListagemCafeCoco.
    }

    @GetMapping("/baixado") //listagem de Café em Côco deletado (inativo)
    public Page<DadosListagemCafeCoco> Cancelado(Pageable paginacao){
       return cafe_coco.findAllByAtivoFalse(paginacao).map(DadosListagemCafeCoco::new);
    }

    @GetMapping("/{lote}") //listagem de lotes de café em côco ativos
    public ResponseEntity<List<CafeCoco>> buscar(@PathVariable int lote){ //No PathVariable o parâmetro é passado diretamente no corpo da requisição e esse valor faz parte do corpo da requisição
       List<CafeCoco> caf = cafe_coco.findByLoteAndAtivoTrue(lote);
       return ResponseEntity.ok().body(caf);
    }

    @PutMapping //Realiza atualizações (Update) no cadastro
    @Transactional //Para fazer escrita no banco de dados de forma efetiva
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCafeCoco da){
       var cafe = cafe_coco.getReferenceById(da.lote()); //Carrega o cadastro do café em coco pelo lote que está vindo pelo DTO
       cafe.atualizarInformacoes(da); //Chama os métodos para atualizar os dados baseado no DTO
    }

    @DeleteMapping("{lote}")
    @Transactional
    public void inativar(@PathVariable int lote)
    {
        var cafe = cafe_coco.getReferenceById(lote); //Carrega o cadastro do café em coco pelo lote que está vindo pelo DTO
        cafe.inativo();
    }

    /*@PostMapping
    public ResponseEntity<CafeCocoResponse<CafeCocoDto>> cadastrar(@Valid @RequestBody CafeCocoDto cafe_cocoDto,//Pega os dados do request e converte em um Dto. @Valid chama a validação que eu criei no Dto.
                                                                     BindingResult result) throws NoSuchAlgorithmException{//Exceção da parte de geração de senhas - BindingResult - terá a informação do resultado da validação do Dto.
        log.info("Cadastrando um café em côco: {}", cafe_cocoDto.toString()); //passa os dados que chegaram via Post Request
        CafeCocoResponse<CafeCocoDto> response = new CafeCocoResponse<CafeCocoDto>(); //Criando uma instância de CafeCocoResponse que será utilizadom para
        validarDadosExistentes(cafe_cocoDto, result);

        return ResponseEntity.ok(response);
    }
    private void validarDadosExistentes(CafeCocoDto cafe_CocoDto, BindingResult result) { //Verifica se esse café em côco já existe no banco de dados
        this.cafe_Coco_Service.buscarPorProdutor(cafe_CocoDto.getProdutor())
                .ifPresent(emp -> result.addError/*Adicionando um erro ao result *//*(new ObjectError("cafe_Coco", "Este café em Côco já existe!")));
    }*/
}