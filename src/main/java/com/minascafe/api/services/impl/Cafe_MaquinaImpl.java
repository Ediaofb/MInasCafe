package com.minascafe.api.services.impl;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.Cafe_Maquina;
import com.minascafe.api.repositories.Cafe_MaquinaRepository;
import com.minascafe.api.services.Cafe_Maquina_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Cria um serviço
public class Cafe_MaquinaImpl implements Cafe_Maquina_Service {

    private static final Logger log = LoggerFactory.getLogger(Cafe_MaquinaImpl.class);//Declarando o log = "descreve eventos do funcionamento do sistema"

    @Autowired
    private Cafe_MaquinaRepository cafe_MaquinaRepository;//Declarando variável cafe_MaquinaRepository

    @Override
    public Optional<Cafe_Maquina> buscarPorLote(int Lote){
        log.info("Buscando  pelo lote: {}, um café que foi beneficiado no armazém (M)", Lote);
        return Optional.ofNullable(cafe_MaquinaRepository.findByLote(Lote));
    }

    @Override
    public Optional<Cafe_Maquina> buscarPorProdutor(String Produtor){
        log.info("Buscando um café do produtor {}, que foi beneficiado no armazém (M)", Produtor);
        return Optional.ofNullable(cafe_MaquinaRepository.findByProdutor(Produtor));
    }

    @Override
    public Cafe_Maquina persistir (Cafe_Maquina cafe_Maquina) {
        log.info("Persistindo Café Beneficiado no armazém: {}", cafe_Maquina);
        return this.cafe_MaquinaRepository.save(cafe_Maquina);
    }

    @Override
    public void remover (int lote) {
        log.info("Removendo o café beneficiado (no armazém) de lote {}: ", lote);
        this.cafe_MaquinaRepository.deleteById(lote);
    }
}
