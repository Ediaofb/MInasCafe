package com.minascafe.api.controllers;

import com.minascafe.api.entities.Liga;
import com.minascafe.api.record.DadosCadastroLiga;
import com.minascafe.api.repositories.LigaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("liga")
public class LigaController {

    @Autowired
    private LigaRepository lig; //Injetando o Repository como sendo um atributo

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroLiga li) {//RequestBody = informação está vindo do corpo da requisição
        lig.save(new Liga(li));
        System.out.print("Liga de café criada com sucesso!");
    }

    /*@PostMapping
    @Transactional
    public ResponseEntity<String> criarliga(@RequestBody @Valid DadosCadastroLiga lg){
        try {
            lig.save(new Liga((lg)));
            System.out.println("Liga de café salva no banco com sucesso!");
            return ResponseEntity.ok("Liga criada com sucesso!");
         }catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar a liga.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        *//*try{
            Liga liga = new Liga();
            liga.setLotes(lg.lotes());
            liga.setData(lg.data());
            liga.setSacas(lg.sacas());
            liga.setQuilos(lg.quilos());
            liga.setProdutor(lg.produtor());
            liga.setBebida(lg.bebida());
            liga.setSomatorio_lotes(lg.somatorio_lotes());
            liga.setSomatorio_quilos(lg.somatorio_quilos());
            liga.setSomatorio_sacas(lg.somatorio_sacas());
            liga.setNomeliga(lg.nomeliga());

            lig.save(liga);

            return ResponseEntity.ok("Liga criada com sucesso!");
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar a liga.", HttpStatus.INTERNAL_SERVER_ERROR);
        }*//*
    }*/

    //ResponseEntity = significa representar toda a resposta HTTP

    @GetMapping
    public ResponseEntity<Liga> retornar(@PathVariable String lote){
        Liga l = lig.findByLote(lote);
        return ResponseEntity.ok().body(l);
    }
}
