package com.minascafe.api.services.impl;
//@author Edson Ferreira Barbosa

import java.util.List;
import java.util.Optional;

import com.minascafe.api.entities.CafeMaquina;
import com.minascafe.api.repositories.CafeMaquinaRepository;
import com.minascafe.api.services.CafeMaquinaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Cria um serviço
public class Cafe_MaquinaImpl implements CafeMaquinaService {

    private static final Logger log = LoggerFactory.getLogger(Cafe_MaquinaImpl.class);//Declarando o log = "descreve eventos do funcionamento do sistema"

    @Autowired
    private CafeMaquinaRepository cafe_MaquinaRepository;//Declarando variável cafe_MaquinaRepository

    @Override
    public Optional<CafeMaquina> buscarPorLote(int Lote){
        log.info("Buscando  pelo lote: {}, um café que foi beneficiado no armazém (M)", Lote);
        return Optional.ofNullable(cafe_MaquinaRepository.findByLote(Lote));
    }

    @Override
    public Optional<List<CafeMaquina>> buscarPorProdutor(String Produtor){
        log.info("Buscando um café do produtor {}, que foi beneficiado no armazém (M)", Produtor);
        return Optional.ofNullable(cafe_MaquinaRepository.findByProdutor(Produtor));
    }

    @Override
    public CafeMaquina persistir (CafeMaquina cafe_Maquina) {
        log.info("Persistindo Café Beneficiado no armazém: {}", cafe_Maquina);
        return this.cafe_MaquinaRepository.save(cafe_Maquina);
    }

    @Override
    public void remover (int lote) {
        log.info("Removendo o café beneficiado (no armazém) de lote {}: ", lote);
        this.cafe_MaquinaRepository.deleteById(lote);
    }
}