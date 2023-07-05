package com.minascafe.api.record;

import java.time.LocalDate;
import java.util.List;

public record DadosAtualizacaoLiga(
        int id,
        LocalDate data,
        List<String>lotes,
        Integer somatorio_lotes,
        Integer somatorio_sacas,
        Float somatorio_quilos,
        String nomeliga) {

    public boolean lotesVazio(){
        return lotes == null || lotes.isEmpty();
    }
}