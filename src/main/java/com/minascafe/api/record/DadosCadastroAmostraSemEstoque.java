package com.minascafe.api.record;

import java.time.LocalDate;

public record DadosCadastroAmostraSemEstoque(
    String produtor,
    String apelido,
    LocalDate data,
    int catacao,
    int peneira,
    String classificacao,
    Float humidade,
    String observacoes){
}
