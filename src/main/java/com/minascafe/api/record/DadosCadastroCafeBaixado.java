package com.minascafe.api.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

public record DadosCadastroCafeBaixado(
        @NotBlank (message = "O campo produtor deve ser preenchido.")
        //verifica se não é nulo e não é vazio = @NotNull + verificação de vazio
        String produtor,
        String apelido,
        String status,
        @NotNull(message = "O campo data deve ser preenchido para cadastrar.")
        LocalDate data,
        @NotNull(message = "O campo sacas deve ser preenchido para cadastrar.")
        int sacas,
        @NotNull(message = "O campo quilos deve ser preenchido para cadastrar.")
        @Range(min = 0, max = 59, message = "Acima de 59 quilos, considere adicionar mais 1 saco!")
        double quilos,
        int barracao,
        String subproduto,
        int numero_nota,
        String classificacao,
        int catacao,
        int peneira,
        Float humidade,
        String lancado,
        String observacoes,
        String referencia,
        String meieiro,
        int porcentagem_produtor,
        int porcentagem_meieiro) {
}