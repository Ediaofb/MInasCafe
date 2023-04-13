package com.minascafe.api.record;

import java.sql.Date;

public record DadosCadastroCafeBaixado(String produtor, String status, Date data, int sacos, double quilos, int barracao,
  String subproduto, int numero_nota, String classificacao, int catacao, int peneira, String lancado, String observacoes,
  String referencia, String meieiro, String porcentagem_produtor, String porcentagem_meieiro) {
}
