package com.minascafe.api.record;

public record DadosAtualizacaoCafeCoco(
        int lote,
        String produtor,
        int catacao,
        String classificacao,
        String lancado,
        String meieiro,
        int numero_nota,
        String observacoes,
        int peneira,
        int porcentagem_meieiro,
        int porcentagem_produtor) {
}