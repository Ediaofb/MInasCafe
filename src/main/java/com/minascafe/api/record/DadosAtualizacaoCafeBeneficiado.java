package com.minascafe.api.record;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record DadosAtualizacaoCafeBeneficiado(
       @NotNull
       Integer lote,
       String produtor,
       LocalDate data,
       Integer catacao,
       String classificacao,
       String lancado,
       String meieiro,
       Integer numero_nota,
       String observacoes,
       Integer peneira,
       Integer porcentagem_produtor,
       Integer porcentagem_meieiro){
}