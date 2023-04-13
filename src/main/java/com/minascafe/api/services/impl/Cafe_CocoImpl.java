package com.minascafe.api.services.impl;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.Cafe_Coco;
import com.minascafe.api.repositories.Cafe_CocoRepository;
import com.minascafe.api.services.Cafe_Coco_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Cria um serviço
public class Cafe_CocoImpl implements Cafe_Coco_Service {

    private static final Logger log = LoggerFactory.getLogger(Cafe_CocoImpl.class);//Declarando o log = "descreve eventos do funcionamento do sistema"

    @Autowired //indica um ponto onde a injeção automática deve ser aplicada.
    private Cafe_CocoRepository cafe_CocoRepository; //Declarando variável cafe_CocoRepository

    @Override //Sobrescrevendo um método e não criando um novo
    public Optional<Cafe_Coco> buscarPorLote(int Lote){
        log.info("Buscando café em coco pelo Lote: {}", Lote);
        return Optional.ofNullable(cafe_CocoRepository.findByLote(Lote));
    }

    @Override
    public Optional<Cafe_Coco> buscarPorProdutor(String Produtor){
        log.info("Buscando um café em côco do produtor: {}", Produtor);
        return Optional.ofNullable(cafe_CocoRepository.findByProdutor(Produtor));
    }

    @Override
    public Cafe_Coco persistir (Cafe_Coco cafe_Coco) {
        log.info("Persistindo Café em Coco: {}", cafe_Coco);
        return this.cafe_CocoRepository.save(cafe_Coco);
    }

    @Override
    public void remover (int lote) {
        log.info("Removendo o café em côco de lote {}: ", lote);
        this.cafe_CocoRepository.deleteById(lote);
    }
}
