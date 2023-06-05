package com.minascafe.api.controllers;

import com.minascafe.api.entities.CafeBaixado;
import com.minascafe.api.record.DadosAtualizacaoCafeBaixado;
import com.minascafe.api.record.DadosCadastroCafeBaixado;
import com.minascafe.api.record.DadosListagemCafeBaixado;
import com.minascafe.api.repositories.CafeBaixadoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

 //Injetando o Repository como sendo um atributo

@RestController//Endpoint (página web) de Controller
@RequestMapping("cafebaixado")//Define a url da classe
public class CafeBaixadoController {

    @Autowired
    private CafeBaixadoRepository cafe_baixado; //Injetando o Repository como sendo um atributo

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCafeBaixado cb){
        cafe_baixado.save(new CafeBaixado(cb));//Salva um novo objeto entidade JPA do tipo CafeBaixado passando os
        // parâmetros que vêm do Json da requisição no construtor da Entidade CafeBaixado

        System.out.print("Lote de café em baixado salvo no banco com sucesso!");
    }

    @GetMapping //Lista todos os lotes de cafés que foram dado baixas
    public Page<DadosListagemCafeBaixado>Listar(Pageable paginacao){//Devolve uma lista de Café Baixado e informações sobre a paginação. É apenas leitura, não precisa da anotação @Transactional
      return cafe_baixado.findAll(paginacao).map(DadosListagemCafeBaixado::new);//map = Mapeamento. Converte uma lista de CafeCoco (Entidade) para uma lista de DadosListagemCafeCoco. stream() = controle de fluxo de dados. Abstração para expressar operações eficientes do estilo SQL em relação a uma coleção de dados
    }

    @GetMapping("/{lote}")
    public ResponseEntity<CafeBaixado> buscar(@PathVariable int lote) { //No PathVariable o parâmetro é passado diretamente no corpo da requisição e esse valor faz parte do corpo da requisição
        CafeBaixado baix = cafe_baixado.findByLote(lote);
        return ResponseEntity.ok().body(baix);
    }

    @PutMapping //Realiza atualizações (Update) no cadastro
    @Transactional //Para fazer escrita no banco de dados de forma efetiva
    public void atualizar(@RequestBody @Valid DadosAtualizacaoCafeBaixado caf){
      var baixado = cafe_baixado.getReferenceById(caf.lote());
      baixado.atualizarBaixado(caf);
    }

}