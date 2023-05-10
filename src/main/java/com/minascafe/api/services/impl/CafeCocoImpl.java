package com.minascafe.api.services.impl;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.CafeCoco;
import com.minascafe.api.repositories.CafeCocoRepository;
import com.minascafe.api.services.CafeCocoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Cria um serviço
public class CafeCocoImpl implements CafeCocoService {

    private static final Logger log = LoggerFactory.getLogger(CafeCocoImpl.class);//Declarando o log = "descreve eventos do funcionamento do sistema"

    @Autowired //indica um ponto onde a injeção automática deve ser aplicada.
    private CafeCocoRepository cafe_CocoRepository; //Declarando variável cafe_CocoRepository

    @Override //Sobrescrevendo um método e não criando um novo
    public Optional<CafeCoco> buscarPorLote(int Lote){
        log.info("Buscando café em coco pelo Lote: {}", Lote);
        return Optional.ofNullable(cafe_CocoRepository.findByLote(Lote));
    }

    @Override
    public Optional<CafeCoco> buscarPorProdutor(String Produtor){
        log.info("Buscando um café em côco do produtor: {}", Produtor);
        return Optional.ofNullable(cafe_CocoRepository.findByProdutor(Produtor));
    }

    @Override
    public CafeCoco persistir (CafeCoco cafe_Coco) {
        log.info("Persistindo Café em Coco: {}", cafe_Coco);
        return this.cafe_CocoRepository.save(cafe_Coco);
    }

    @Override
    public void remover (int lote) {
        log.info("Removendo o café em côco de lote {}: ", lote);
        this.cafe_CocoRepository.deleteById(lote);
    }
}