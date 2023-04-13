package com.minascafe.api.record;

import java.sql.Date;

public record DadosFichaProdutor(String nome, String apelido, String cpf, String telefone, Date data, String entrada_saida,
  String lote, float duro, float riado, float rio, float escolha, int renda, int humidade, float valor_total,
  String banco, String agencia, String operacao, String tipo_conta, String numero_conta, String nome_correntista,
  String chave_pix, Date aniversario) {
}
