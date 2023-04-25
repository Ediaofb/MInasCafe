package com.minascafe.api.record;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
import java.sql.Date;

public record DadosCadastroCafeCoco(
        @NotBlank //verifica se não é nulo e não é vazio = @NotNull + verificação de vazio
        String produtor,
        String apelido,
        String status,
        @NotNull
        Date data,
        @NotNull
        int sacos,
        @NotNull
        @Range(min = 0, max = 45, message = "Acima de 45 quilos, considere adicionar mais 1 saco!")
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