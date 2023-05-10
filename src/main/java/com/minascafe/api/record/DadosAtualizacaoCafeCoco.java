package com.minascafe.api.record;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoCafeCoco(
        @NotNull
        Integer lote,
        String produtor,
        LocalDate data,
        Integer catacao,
        String subproduto,
        String classificacao,
        Float humidade,
        String lancado,
        String meieiro,
        Integer numero_nota,
        String observacoes,
        Integer peneira,
        Integer porcentagem_meieiro,
        Integer porcentagem_produtor) {
}