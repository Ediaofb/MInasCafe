package com.minascafe.api.record;

import java.sql.Date;

public record DadosCadastroCafeBeneficiado(String produtor, String status, Date data, int sacas, double quilos, int barracao,
  String subproduto, int numero_nota, String classificacao, int catacao, int peneira, String lancado, String observacoes,
  String referencia, String meieiro, String porcentagem_produtor, String porcentagem_meieiro) {
}
