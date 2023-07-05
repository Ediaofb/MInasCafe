package com.minascafe.api.services.impl;

import com.minascafe.api.entities.CafeBeneficiado;
import com.minascafe.api.entities.CafeMaquina;
import com.minascafe.api.entities.Liga;
import com.minascafe.api.record.DadosCadastroLiga;
import com.minascafe.api.repositories.CafeBeneficiadoRepository;
import com.minascafe.api.repositories.CafeMaquinaRepository;
import com.minascafe.api.repositories.LigaRepository;
import com.minascafe.api.services.LigaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LigaServiceImpl implements LigaService {

    private static final Logger log = LoggerFactory.getLogger(LigaServiceImpl.class); //Declarando o log = "descreve eventos do funcionamento do sistema".
    private final LigaRepository ligaRepository;

    @Autowired
    CafeMaquina cafeMaquina;
    @Autowired
    CafeMaquinaRepository cafeMaquinaRepository;
    @Autowired
    CafeBeneficiadoRepository cafeBeneficiadoRepository;

    public LigaServiceImpl(LigaRepository ligaRepository) {
        this.ligaRepository = ligaRepository;
    }

    @Override
    public Optional<Liga> buscarPorLotes(String Lote) {
        log.info("Buscando uma liga pelo lote : {}", Lote);
        return Optional.ofNullable(ligaRepository.findByLotes(Lote));
    }

    @Override
    public Optional<Liga> buscarPorNomeliga(String nomeliga) {
        log.info("Buscando uma liga pelo nome: {}", nomeliga);
        return Optional.ofNullable(ligaRepository.findByNomeliga(nomeliga));
    }

    @Override
    public Optional<Liga> buscarPorId(int Id) {
        log.info("Buscando uma liga pelo Id: {}", Id);
        return Optional.ofNullable(ligaRepository.findById(Id));
    }

    @Override
    public Liga persistir(Liga liga) {
        log.info("Persistindo a Liga: {}", liga);
        return this.ligaRepository.save(liga);
    }

    @Override
    public void remover (int id){
        log.info("Removendo a liga de id: {}", id);
        this.ligaRepository.deleteById(id);
    }

    @Override
    public Liga criarLiga(DadosCadastroLiga dadosLiga){
      Liga liga = new Liga(dadosLiga);
      return persistir(liga);
    }

    public void removerLotesCafeMaquina(List<String> lotes){
        for(String lote : lotes){
            // Remove os caracteres "M" e "-"
            String loteSemPrefixo = lote.replaceAll("[M-]", "");

            //Converte para inteiro
            int loteInt = Integer.parseInt(loteSemPrefixo);

            // Remove o lote de CafeMaquina pelo ID
            Optional<CafeMaquina> cafeMaquina = Optional.ofNullable(cafeMaquinaRepository.findByLote(loteInt));
            cafeMaquina.ifPresent(cafeMaquinaRepository::delete);
        }
    }

    public void removerLotesCafeBeneficiado(List<String> lotes){
        for (String lote : lotes){
            //Remove os caracteres "E" e "-"
            String loteSemPrefixo = lote.replaceAll("[E-]", "");
            //Converte a String para inteiro
            int loteInt = Integer.parseInt(loteSemPrefixo);

            //Remove o lote de CafeBeneficiado por Id
            Optional <CafeBeneficiado> cafeBeneficiado = Optional.ofNullable(cafeBeneficiadoRepository.findByLote(loteInt));
            cafeBeneficiado.ifPresent(cafeBeneficiadoRepository::delete);
        }
    }
}