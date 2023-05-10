package com.minascafe.api.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.sql.Date;

public record DadosFichaProdutor(
      @NotBlank(message = "O nome não pode estar vazio! Por favor, cadastre um nome de produtor")
      String nome,
      String apelido,
      @CPF
      String cpf,
      String telefone,
      @NotNull
      Date data,
      String entrada_saida,
      String lote,
      float duro,
      float riado,
      float rio,
      float escolha,
      int renda,
      int humidade,
      float valor_total,
      String banco,
      String agencia,
      String operacao,
      String tipo_conta,
      String numero_conta,
      String nome_correntista,
      String chave_pix,
      Date aniversario) {
}
