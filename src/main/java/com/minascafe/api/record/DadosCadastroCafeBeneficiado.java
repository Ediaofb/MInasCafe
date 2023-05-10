package com.minascafe.api.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import java.sql.Date;
import java.time.LocalDate;

public record DadosCadastroCafeBeneficiado(
        @NotBlank //verifica se não é nulo e não é vazio = @NotNull + verificação de vazio
        String produtor,
        String apelido,
        String status,
        @NotNull
        LocalDate data,
        @NotNull(message = "A quantidade de quilos deve ser preenchida, mesmo que seja com '0'")
        int sacas,
        @NotNull
        @Range(min = 0, max = 60, message = "Acima de 60 quilos, considere adicionar mais 1 saco!")
        double quilos,
        int barracao,
        String subproduto,
        int numero_nota,
        String classificacao,
        int catacao,
        int peneira,
        float humidade,
        String lancado,
        String observacoes,
        String meieiro,
        int porcentagem_produtor,
        int porcentagem_meieiro) {
}