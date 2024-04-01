package com.minascafe.api.record;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoCafeBeneficiado(
       @NotNull
       Integer lote,
       String produtor,
       LocalDate data,
       Integer sacas,
       Float quilos,
       Integer barracao,
       Integer catacao,
       String classificacao,
       String lancado,
       Float humidade,
       String subproduto,
       String meieiro,
       Integer numero_nota,
       String observacoes,
       Integer peneira,
       Integer porcentagem_produtor,
       Integer porcentagem_meieiro){
}