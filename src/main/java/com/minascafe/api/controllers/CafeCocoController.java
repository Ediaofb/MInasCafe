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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController //Endpoint (página web) de Controller
@RequestMapping("cafecoco") //Define a url da classe
public class CafeCocoController {

    public static final Logger log = LoggerFactory.getLogger(CafeCocoController.class);

    @Autowired
    private CafeCocoRepository cafe_coco; //Injetando o Repository como sendo um atributo

    @PostMapping //Grava um     registro de Café em Côco
    @Transactional//Unidade de trabalho isolada que leva o banco de dados de um estado consistente a outro estado consistente
    public void cadastrar(@RequestBody @Valid DadosCadastroCafeCoco cc){ //RequestBody = Busca do corpo da requisição
        cafe_coco.save(new CafeCoco(cc)); //Salva um novo objeto entidade JPA do tipo CafeCoco passando os
        // parâmetros que vêm do Json da requisição no construtor da Entidade CafeCoco

        System.out.print("Lote de café em côco salvo no banco com sucesso!");
    }

    @GetMapping
    public Page<DadosListagemCafeCoco> listar(Pageable paginacao){//Devolve uma lista de Café em Côco e informações sobre a paginação. É apenas leitura, não precisa da anotação @Transactional
      return cafe_coco.findAll(paginacao).map(DadosListagemCafeCoco::new);//map = Mapeamento. Converte uma lista de CafeCoco para uma lista de DadosListagemCafeCoco. stream() = controle de fluxo de dados. Abstração para expressar operações eficientes do estilo SQL em relação a uma coleção de dados
        //.toList() = converte para uma lista
        // cafe_coco.findAll devolve uma lista de cafe_coco e o retorno do método é uma lista de DadosListagemCafeCoco (é um Dto)
    }

    @GetMapping("/{lote}")
    public ResponseEntity<CafeCoco> buscar(@PathVariable int lote){ //No PathVariable o parâmetro é passado diretamente no corpo da requisição e esse valor faz parte do corpo da requisição
       CafeCoco caf = cafe_coco.findByLote(lote);
        return ResponseEntity.ok().body(caf);
    }

    @PutMapping //Realiza atualizações (Update) no cadastro
    @Transactional //Para fazer escrita no banco de dados de forma efetiva
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCafeCoco da){
       var cafe = cafe_coco.getReferenceById(da.lote()); //Carrega o cadastro do café em coco pelo lote que está vindo pelo DTO
       cafe.atualizarInformacoes(da); //Chama os métodos para atualizar os dados baseado no DTO
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