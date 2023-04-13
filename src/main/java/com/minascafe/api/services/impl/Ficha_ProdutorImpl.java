package com.minascafe.api.services.impl;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.Ficha_Produtor;
import com.minascafe.api.repositories.Ficha_ProdutorRepository;
import com.minascafe.api.services.Ficha_Produtor_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //Cria um serviço
public class Ficha_ProdutorImpl implements Ficha_Produtor_Service {

    private static final Logger log = LoggerFactory.getLogger(Ficha_ProdutorImpl.class);//Declarando o log = "descreve eventos do funcionamento do sistema".

    @Autowired
    private Ficha_ProdutorRepository ficha_ProdutorRepository;

    @Override //Sobrescrevendo (e não criando) um método
    public Optional<Ficha_Produtor> buscarPorId(int Id){ //Optional = evita NullPointerException
        log.info("Buscando os dados de um produtor pelo Id {}", Id);
        return Optional.ofNullable(ficha_ProdutorRepository.findById(Id));
    }

    @Override
    public Optional <Ficha_Produtor> buscarPorNome(String nome){
        log.info("Buscando os dados de um produtor a partir do nome {}", nome);
        return Optional.ofNullable(ficha_ProdutorRepository.findByNome(nome));
    }

    @Override
    public Optional <Ficha_Produtor> buscarPorApelido(String apelido){
        log.info("Buscando os dados de um produtor pelo apelido {}", apelido);
        return Optional.ofNullable(ficha_ProdutorRepository.findByApelido(apelido));
    }

    @Override
    public Optional <Ficha_Produtor> buscarPorCpf(String cpf){
        log.info("Buscando os dados de um produtor a partir do cpf: {}", cpf);
        return Optional.ofNullable(ficha_ProdutorRepository.findByCpf(cpf));
    }

    @Override
    public void remover (String nome) {
        log.info("Removendo um produtor de nome {}: ", nome);
        this.ficha_ProdutorRepository.deleteAll();
    }
}