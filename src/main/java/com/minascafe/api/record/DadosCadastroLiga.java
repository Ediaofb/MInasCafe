package com.minascafe.api.record;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastroLiga(
        @NotNull
        LocalDate data,
        @NotEmpty
        List<String> lotes,
        int somatorio_lotes,
        int somatorio_sacas,
        Float somatorio_quilos,
        String nomeliga) {

}
