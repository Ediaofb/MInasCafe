package com.minascafe.api.record;

import java.util.Date;

public record DadosAtualizacaoCafeBaixado(
    Integer lote,
    String produtor,
    Date data,
    Integer catacao,
    String classificacao,
    String lancado,
    String meieiro,
    Integer numero_nota,
    String observacoes,
    Integer peneira,
    Integer porcentagem_meieiro,
    Integer porcentagem_produtor) {

}
