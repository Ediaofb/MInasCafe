package com.minascafe.api.controllers;

import com.minascafe.api.entities.CafeBeneficiado;
import com.minascafe.api.entities.CafeMaquina;
import com.minascafe.api.entities.Liga;
import com.minascafe.api.record.DadosAtualizacaoLiga;
import com.minascafe.api.record.DadosCadastroLiga;
import com.minascafe.api.repositories.CafeBeneficiadoRepository;
import com.minascafe.api.repositories.CafeMaquinaRepository;
import com.minascafe.api.repositories.LigaRepository;
import com.minascafe.api.services.LigaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/liga")
public class LigaController {

    @Autowired
    private LigaRepository ligar; // Injetando o Repository como sendo um atributo
    @Autowired
    private LigaService lgs;
    @Autowired
    private CafeBeneficiadoRepository cbr;
    @Autowired
    private CafeMaquinaRepository cmr;
    @Autowired
    private CafeMaquina cafeMaquina;

    @CrossOrigin
    @PostMapping // Cadastra uma liga e
    public ResponseEntity<Liga> criarLiga(@RequestBody DadosCadastroLiga dadosCadastroLiga) {// Retorna uma liga,
                                                                                             // adquirindo no corpo da
                                                                                             // requisição dados de uma
                                                                                             // liga
        Liga liga = new Liga(dadosCadastroLiga); // Cria a instância de Liga com os dados recebidos

        /*
         * String loteSemM;
         * int loteInt = 0;
         */

        for (String lote : liga.getLotes()) { // Para cada lote na lista de lotes...
            lgs.marcarLotesComoInativos(lote);// Marca os lotes utilizados na liga como inativos
        }
        liga = lgs.persistir(liga); // Persiste a liga no banco de dados

        /*
         * // Verificar quantidade de sacas e quilos desejada para cada lote
         * for (String lote : liga.getLotes()) {
         * int sacasDesejadas = liga.getSomatorio_sacas();
         * float quilosDesejados = liga.getSomatorio_quilos();
         * 
         * boolean verifCM = lgs.verificaLoteCM(lote); //verifica se o lote é de Café
         * Máquina
         * if(verifCM == true){
         * loteSemM = lote.replaceAll("M-", ""); //remove as iniciais "M-"
         * loteInt = Integer.parseInt(loteSemM);
         * }
         * // Verificar se o lote pertence a CafeMaquina
         * CafeMaquina cafeMaquina = cmr.findByLote(loteInt);
         * if (cafeMaquina != null) { //Se o café máquina não está vazio
         * int sacasDisponiveis = cafeMaquina.getSacas(); //verifica a quantidade de
         * sacas disponíveis no lote
         * float quilosDisponiveis = cafeMaquina.getQuilos(); //verifica a quantidade de
         * quilos disponíveis no lote
         * 
         * if (sacasDisponiveis >= sacasDesejadas && quilosDisponiveis >=
         * quilosDesejados) {
         * // Se sacas e quilos disponíveis "são suficientes", subtrair do lote
         * cafeMaquina.subtrairSacasQuilos(sacasDesejadas, quilosDesejados);
         * cmr.save(cafeMaquina);
         * continue; // Passar para o próximo lote
         * }
         * }
         * 
         * // Verificar se o lote pertence a CafeBeneficiado
         * CafeBeneficiado cafeBeneficiado = cbr.findByLote(lote);
         * if (cafeBeneficiado != null) {
         * int sacasDisponiveis = cafeBeneficiado.getSacas();
         * float quilosDisponiveis = cafeBeneficiado.getQuilos();
         * 
         * if (sacasDisponiveis >= sacasDesejadas && quilosDisponiveis >=
         * quilosDesejados) {
         * // Sacas e quilos disponíveis são suficientes, subtrair do lote
         * cafeBeneficiado.subtrairSacasQuilos(sacasDesejadas, quilosDesejados);
         * cbr.save(cafeBeneficiado);
         * continue; // Passar para o próximo lote
         * }
         * }
         * 
         * // Sacas e quilos desejados não estão disponíveis no lote, criar novo lote de
         * CafeBeneficiado
         * CafeBeneficiado novoLote = new CafeBeneficiado();
         * novoLote.setProdutor("Resto de Liga");
         * novoLote.setSacas(sacasDesejadas);
         * novoLote.setQuilos(quilosDesejados);
         * cbr.save(novoLote);
         * }
         */
        return ResponseEntity.ok(liga); // Retorna a liga no corpo da resposta
    }

    @CrossOrigin
    @GetMapping // Lista todas as Ligas existentes
    public List<Liga> listar() {
        return ligar.findAll();
    }

    @CrossOrigin
    @GetMapping("/{lote}")
    public ResponseEntity<?> listarPorLote(@PathVariable String lote) {
        Liga liga = ligar.findByLotes(lote);
        if (liga != null) {
            return ResponseEntity.ok(liga);
        } else {
            String mensagem = "Liga não encontrada para este lote";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @CrossOrigin
    @GetMapping("/data/{data}")
    public List<Liga> buscarPorData(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        List<Liga> ligas = ligar.findBydata(data);
        return ligar.findBydata(data);
    }

    @CrossOrigin
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoLiga dal) {
        var lig = ligar.getReferenceById(dal.id());
        lig.atualizarLiga(dal);
    }
}