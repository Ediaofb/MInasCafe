package com.minascafe.api.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;

public record DadosCadastroCafeCoco(
        @NotBlank //verifica se não é nulo e não é vazio = @NotNull + verificação de vazio
        String produtor,
        String status,
        @NotNull
        Date data,
        int sacos,
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