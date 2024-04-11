package com.minascafe.api.record;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;
import java.time.LocalDate;

public record DadosCadastroCafeCoco(
        @NotBlank(message = "O campo produtor não pode estar vazio!") //verifica se não é nulo e não é vazio = @NotNull + verificação de vazio
        String produtor,
        String apelido,
        @NotNull
        LocalDate data,
        int catacao,
        int barracao,
        String classificacao,
        String lancado,
        int peneira,
        Float humidade,
        int numero_nota,
        String status,
        String referencia,
        String subproduto,
        @NotNull(message = "A quantidade de quilos deve ser preenchida, mesmo que seja com '0'")
        int sacos,
        @NotNull
        @Range(min = 0, max = 44, message = "Acima de 45 quilos, considere adicionar mais 1 saco!")
        float quilos,
        String observacoes,
        String meieiro,
        int porcentagem_meieiro,
        int porcentagem_produtor) {

}