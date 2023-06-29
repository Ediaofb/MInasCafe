package com.minascafe.api.record;

import com.minascafe.api.entities.Liga;

import java.time.LocalDate;
import java.util.List;

public record DadosListagemLiga(int id, LocalDate data, List<String> lotes, int somatorio_lotes, int somatorio_sacas, Float somatorio_quilos,
                                String nomeliga) {
    public DadosListagemLiga(Liga liga){
     this(liga.getId(), liga.getData(), liga.getLotes(), liga.getSomatorio_lotes(), liga.getSomatorio_sacas(), liga.getSomatorio_quilos(),
          liga.getNomeliga());
    }
}
