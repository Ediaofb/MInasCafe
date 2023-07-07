package com.minascafe.api.record;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizarAmostra(
        @NotNull
        Integer id,
        String produtor,
        String apelido,
        LocalDate data,
        Integer catacao,
        Integer peneira,
        String classificacao,
        Float humidade,
        String observacoes) {
}
