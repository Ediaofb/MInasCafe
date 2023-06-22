package com.minascafe.api.record;

import com.fasterxml.jackson.databind.JsonNode;
import com.minascafe.api.entities.Liga;
import com.minascafe.api.entities.Lote;

import java.time.LocalDate;
import java.util.List;

public record DadosListagemLiga(int id, LocalDate data, List<Lote>lote, int sacas, Float quilos, String produtor, String bebida,
                                int somatorio_lotes, int somatorio_sacas, int somatorio_quilos, String nomeliga) {

    public DadosListagemLiga(Liga liga){
        this(liga.getId(), liga.getData(), liga.getLotes(), liga.getSacas(), liga.getQuilos(), liga.getProdutor(), liga.getBebida(),
        liga.getSomatorio_lotes(), liga.getSomatorio_sacas(), liga.getSomatorio_quilos(), liga.getNomeliga());
    }
}
