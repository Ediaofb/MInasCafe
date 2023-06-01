package com.minascafe.api.record;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizacaoCafeMaquina (

      @NotNull
      Integer lote,
      String produtor,
      LocalDate data,
      Float humidade,
      String subproduto,
      Integer numero_nota,
      String classificacao,
      Integer catacao,
      Integer peneira,
      String lancado,
      String meieiro,
      String observacoes,
      Integer porcentagem_meieiro,
      Integer porcentagem_produtor){

}