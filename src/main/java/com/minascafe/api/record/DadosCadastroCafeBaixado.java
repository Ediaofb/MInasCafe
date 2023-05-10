package com.minascafe.api.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record DadosCadastroCafeBaixado(
        @NotBlank
        String produtor,
        String status,
        @NotNull
        LocalDate data,
        @NotNull
        int sacos,
        @NotNull
        double quilos,
        int barracao,
        String subproduto,
        int numero_nota,
        String classificacao,
        int catacao,
        int peneira,
        String lancado,
        String observacoes,
        String referencia,
        String meieiro,
        String porcentagem_produtor,
        String porcentagem_meieiro) {
}