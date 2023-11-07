package com.minascafe.api.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import java.time.LocalDate;

public record DadosCadastroFichaProdutor(
        @NotBlank(message = "O nome não pode estar vazio! Por favor, cadastre um nome de produtor")
        String nome,
        String apelido,
        @CPF(message = "O CPF digitado é inválido! Tente novamente com um CPF válido!")
        String cpf,
        String telefone,
        // @NotNull
        LocalDate data,
        String entrada_saida,
        String lote,
        int renda,
        float humidade,
        float valor_total,
        String banco,
        String agencia,
        String operacao,
        String tipo_conta,
        String numero_conta,
        String nome_correntista,
        String chave_pix,
        int saldo_duro_sacos,
        float saldo_duro_quilos,
        int saldo_riado_sacos,
        float saldo_riado_quilos,
        int saldo_rio_sacos,
        float saldo_rio_quilos,
        int saldo_escolha_sacos,
        float saldo_escolha_quilos,
        int saldo_mooca_sacos,
        float saldo_mooca_quilos,
        float preco
) {
}