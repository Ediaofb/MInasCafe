package com.minascafe.api.services.impl;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.CafeBeneficiado;
import com.minascafe.api.repositories.CafeBeneficiadoRepository;
import com.minascafe.api.services.CafeBeneficiadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Cria um serviço
public class CafeBeneficiadoImpl implements CafeBeneficiadoService {

    private static final Logger log = LoggerFactory.getLogger(CafeBeneficiadoImpl.class); //Declarando o log = "descreve eventos do funcionamento do sistema".

    @Autowired //Injetando dependência de forma automática
    private CafeBeneficiadoRepository cafe_BeneficiadoRepository;//Declarando variável cafe_BeneficiadoRepository

    @Override //Sobrescrevendo um método e não criando um novo
    public Optional<CafeBeneficiado> buscarPorLote(int Lote){ //***** Optional ajuda a manipular os objetos nulos *********
        log.info("Buscando café beneficiado pelo lote {}", Lote);
        return Optional.ofNullable(cafe_BeneficiadoRepository.findByLote(Lote));
    }

    @Override
    public CafeBeneficiado persistir (CafeBeneficiado cafe_Beneficiado) {
        log.info("Persistindo café beneficiado: {}", cafe_Beneficiado);//imprime na tela
        return this.cafe_BeneficiadoRepository.save(cafe_Beneficiado);
    }

    @Override
    public Optional<CafeBeneficiado> buscarPorProdutor(String Produtor){
        log.info("Buscando um café beneficiado pelo produtor: {}", Produtor);
        return Optional.ofNullable(cafe_BeneficiadoRepository.findByProdutor(Produtor));
    }

    @Override
    public void remover (int lote) {
        log.info("Removendo o café beneficiado de lote {}: ", lote);
        this.cafe_BeneficiadoRepository.deleteById(lote);
    }
}