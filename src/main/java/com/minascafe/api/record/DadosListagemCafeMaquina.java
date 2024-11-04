package com.minascafe.api.record;

import com.minascafe.api.entities.CafeMaquina;
import java.time.LocalDate;

public record DadosListagemCafeMaquina(int lote, String produtor, String apelido, String status, LocalDate data, int sacas, float quilos,
  Float humidade, int barracao, String subproduto, int numero_nota, String classificacao, int catacao, int peneira, String lancado,
  String baixado, String observacoes, String referencia, String meieiro, int porcentagem_produtor, int porcentagem_meieiro) {

    public DadosListagemCafeMaquina(CafeMaquina cafe_maquina) {
      this(cafe_maquina.getLote(), cafe_maquina.getProdutor(), cafe_maquina.getApelido(), cafe_maquina.getStatus(), cafe_maquina.getData(),
            cafe_maquina.getSacas(), cafe_maquina.getQuilos(), cafe_maquina.getHumidade(), cafe_maquina.getBarracao(), cafe_maquina.getSubproduto(),
            cafe_maquina.getNumero_nota(), cafe_maquina.getClassificacao(), cafe_maquina.getCatacao(), cafe_maquina.getPeneira(), cafe_maquina.getLancado(),
            cafe_maquina.getBaixado(), cafe_maquina.getObservacoes(), cafe_maquina.getReferencia(), cafe_maquina.getMeieiro(), cafe_maquina.getPorcentagem_produtor(), cafe_maquina.getPorcentagem_meieiro());
    }
}