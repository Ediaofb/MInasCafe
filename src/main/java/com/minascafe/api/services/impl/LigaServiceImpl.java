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
    Liga liga;
    @Autowired
    CafeMaquina cafeMaquina;
    @Autowired
    CafeMaquinaRepository cmr;
    @Autowired
    CafeBeneficiadoRepository cbr;

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

    public boolean verificaLoteCM(String lote){ //Verifica se o lote é de Café Máquina
        boolean flagCM;
        flagCM = lote.contains("M");
        return flagCM;
    }

    public boolean verificaLoteCB(String lote){ //Verifica se o lote é de Café Beneficiado
        boolean flagCB;
        flagCB = lote.contains("E");
        return flagCB;
    }

    String retornaLoteSemPrefixo(String lote){
        if (lote.startsWith("M-")) {
            String lot = lote.replaceAll("[M-]", "");
        }
        return lote;
    }
    public void marcarLotesComoInativos(String lote){
        //Verificar se o lote começa com "E-" (Café Beneficiado)
        if (lote.startsWith("M-")) { //Se o lote inicia com "M-"
            String loteSemPrefixo = lote.replaceAll("[M-]", "");//Remove "M-" do lote
            int loteInt = Integer.parseInt(loteSemPrefixo); //Converte o lote para inteiro

            CafeMaquina cafeMaquina = cmr.findByLote(loteInt); //Busca um Café Máquina pelo lote
            if (cafeMaquina != null){
                cafeMaquina.inativar();
                String observacoes = cafeMaquina.getObservacoes();
                observacoes += "Lote utilizado na liga: " + liga.getId() + ".";
                cafeMaquina.setObservacoes(observacoes);
                cmr.save(cafeMaquina);
            }
        }
        //verificar se o lote começa com "M-" (Café Máquina)
        else if (lote.startsWith("E-")) {
            String loteSemPrefixo = lote.replaceAll("[E-]", ""); //Remove "E-" do lote
            int loteInt = Integer.parseInt(loteSemPrefixo); //Converte o lote para inteiro

            CafeBeneficiado cafeBeneficiado = cbr.findByLote(loteInt); //Busca um Café Beneficiado pelo lote
            if (cafeBeneficiado != null){
                cafeBeneficiado.inativar();
                String observacoes = cafeBeneficiado.getObservacoes();
                observacoes += "Lote utilizado na liga: " + liga.getId() + ".";
                cafeBeneficiado.setObservacoes(observacoes);
                cbr.save(cafeBeneficiado);
            }
        }
    }

    public void removerLotesCafeMaquina(List<String> lotes){
        for(String lote : lotes){
            // Remove os caracteres "M" e "-"
            String loteSemPrefixo = lote.replaceAll("[M-]", "");

            //Converte para inteiro
            int loteInt = Integer.parseInt(loteSemPrefixo);

            // Remove o lote de CafeMaquina pelo ID
            Optional<CafeMaquina> cafeMaquina = Optional.ofNullable(cmr.findByLote(loteInt));
            cafeMaquina.ifPresent(cmr::delete);
        }
    }

    public void removerLotesCafeBeneficiado(List<String> lotes){
        for (String lote : lotes){
            //Remove os caracteres "E" e "-"
            String loteSemPrefixo = lote.replaceAll("[E-]", "");
            //Converte a String para inteiro
            int loteInt = Integer.parseInt(loteSemPrefixo);

            //Remove o lote de CafeBeneficiado por Id
            Optional <CafeBeneficiado> cafeBeneficiado = Optional.ofNullable(cbr.findByLote(loteInt));
            cafeBeneficiado.ifPresent(cbr::delete);
        }
    }
}