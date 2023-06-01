package com.minascafe.api.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.sql.Date;
import java.time.LocalDate;

public record DadosCadastroCafeMaquina(
        @NotBlank //Verifica se não é nulo e não é vazio =@NotNull + verificação de vazio
        String produtor,
        String apelido,
        float humidade,
        String status,
        LocalDate data,
        @NotNull(message = "A quantidade de sacas ou sacos deve ser preenchida, mesmo que seja com '0'!")
        int sacas,
        @NotNull(message = "A quantidade de quilos deve ser preenchida, mesmo que seja com '0'!")
        @Range(min = 0, max =59, message = "Acima de 60 quilos, considere adicionar mais 1 saco!")
        float quilos,
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
        int porcentagem_produtor,
        int porcentagem_meieiro) {
}