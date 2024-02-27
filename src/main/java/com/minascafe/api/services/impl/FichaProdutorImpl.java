package com.minascafe.api.services.impl;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.FichaProdutor;
import com.minascafe.api.repositories.FichaProdutorRepository;
import com.minascafe.api.services.FichaProdutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //Cria um serviço
public class FichaProdutorImpl implements FichaProdutorService {

    private static final Logger log = LoggerFactory.getLogger(FichaProdutorImpl.class);//Declarando o log = "descreve eventos do funcionamento do sistema".

    @Autowired
    private FichaProdutorRepository ficha_ProdutorRepository;

    @Override //Sobrescrevendo (e não criando) um método
    public Optional<FichaProdutor> buscarPorId(int Id){ //Optional = evita NullPointerException
        log.info("Buscando os dados de um produtor pelo Id {}", Id);
        return Optional.ofNullable(ficha_ProdutorRepository.findById(Id));
    }

    @Override
    public Optional <FichaProdutor> buscarPorNome(String nome){
        log.info("Buscando os dados de um produtor a partir do nome {}", nome);
        return Optional.ofNullable(ficha_ProdutorRepository.findByNome(nome));
    }

    @Override
    public Optional <FichaProdutor> buscarPorApelido(String apelido){
        log.info("Buscando os dados de um produtor pelo apelido {}", apelido);
        return Optional.ofNullable(ficha_ProdutorRepository.findByApelido(apelido));
    }

    @Override
    public Optional <FichaProdutor> buscarPorCpf(String cpf){
        log.info("Buscando os dados de um produtor a partir do cpf: {}", cpf);
        return Optional.ofNullable(ficha_ProdutorRepository.findByCpf(cpf));
    }

    @Override
    public void remover (String nome) {
        log.info("Removendo um produtor de nome {}: ", nome);
        this.ficha_ProdutorRepository.deleteAll();
    }

    @Override
    public void removerPorNome(String nome){
        FichaProdutor fichaprodutor = ficha_ProdutorRepository.findByNome(nome);
        if (fichaprodutor != null){
            ficha_ProdutorRepository.delete(fichaprodutor);
        } else{
            throw new RuntimeException("Ficha de produtor não encontrada como o nome: " + nome);
        }
    }   
}