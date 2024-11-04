package com.minascafe.api.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import java.sql.Date;
import java.time.LocalDate;

public record DadosCadastroCafeBeneficiado(
        @NotBlank(message = "O campo produtor não pode estar vazio!") //verifica se não é nulo e não é vazio = @NotNull + verificação de vazio
        String produtor,
        String apelido,
        @NotNull
        LocalDate data,
        @NotNull(message = "A quantidade de quilos deve ser preenchida, mesmo que seja com '0'")
        int sacas,
        @NotNull
        @Range(min = 0, max = 59, message = "Acima de 60 quilos, considere adicionar mais 1 saco!")
        float quilos,
        int barracao,
        String status,
        String subproduto,
        int numero_nota,
        String referencia,
        String classificacao,
        int catacao,
        int peneira,
        float humidade,
        String lancado,
        String baixado,
        String observacoes,
        String meieiro,
        int porcentagem_produtor,
        int porcentagem_meieiro) {
}