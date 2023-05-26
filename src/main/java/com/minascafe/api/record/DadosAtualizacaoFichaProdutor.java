package com.minascafe.api.record;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoFichaProdutor(
        @NotNull
        String lote,
        LocalDate data,
        String produtor,
        String cpf,
        String telefone,
        String banco,
        String agencia,
        String operacao,
        String numero_conta,
        String nome_correntista,
        String chave_pix,
        Integer renda,
        String entrada_saida,
        Float humidade,
        Integer saldo_duro_sacos,
        Float saldo_duro_quilos,
        Integer saldo_riado_sacos,
        Float saldo_riado_quilos,
        Integer saldo_rio_sacos,
        Float saldo_rio_quilos,
        Integer saldo_escolha_sacos,
        Float saldo_escolha_quilos,
        Integer saldo_mooca_sacos,
        Float saldo_mooca_quilos,
        Float preco) {
}