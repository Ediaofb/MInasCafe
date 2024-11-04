package com.minascafe.api.record;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoCafeBeneficiado(
       @NotNull
       Integer lote,
       String produtor,
       Boolean ativo, //Alterado do primitivo 'boolean' para a classe (wrapper) 'Boolean'
       LocalDate data,
       Integer sacas,
       Float quilos,
       Integer barracao,
       Float humidade,
       String subproduto,
       String classificacao,
       Integer catacao,
       Integer peneira,
       String lancado,
       String baixado,
       String meieiro,
       Integer numero_nota,
       String observacoes,
       Integer porcentagem_produtor,
       Integer porcentagem_meieiro){
}