package com.minascafe.api.services.impl;

import com.minascafe.api.entities.Liga;
import com.minascafe.api.repositories.LigaRepository;
import com.minascafe.api.services.LigaService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;

public class LigaServiceImpl implements LigaService {

    private static final Logger log = LoggerFactory.getLogger(LigaServiceImpl.class); //Declarando o log = "descreve eventos do funcionamento do sistema"

    @Autowired
    private LigaRepository liga_Repository;

    public Optional<Liga>  buscarPorLote(String lote){
        log.info("Buscando liga pelo Lote: {}", lote);
        return Optional.ofNullable(liga_Repository.findByLote(lote));
    }

    @Override
    public Optional<Liga> buscarPorLotes(String lote) {
        return Optional.empty();
    }

    @Override
    public Optional<Liga> buscarPorData(LocalDate data){
        log.info("Buscando liga por data: {}", data);
        return Optional.ofNullable(liga_Repository.findByData(data));
    }

    @Override
    public Optional<Liga> buscarPorId(int Id){
        log.info("Buscando liga por id: {}", Id);
        return Optional.ofNullable(liga_Repository.findById(Id));
    }

    @Override
    public Optional<Liga> buscarPorNomeliga(String nomeliga) {
        log.info("Buscando liga por nomeliga: {}", nomeliga);
        return Optional.ofNullable(liga_Repository.findByNomeliga(nomeliga));
    }
}
