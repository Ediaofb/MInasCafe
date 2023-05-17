package com.minascafe.api.record;

import com.minascafe.api.entities.CafeBaixado;

import java.time.LocalDate;
import java.util.Date;

public record DadosListagemCafeBaixado(int lote, String produtor, String status, LocalDate data, int sacos, double quilos,
 int barracao, String subproduto, int numero_nota, String classificacao, int catacao, int peneira, String lancado,
 Float humidade, String observacoes, String referencia, String meieiro, int porcentagem_produtor, int porcentagem_meieiro) {

    public DadosListagemCafeBaixado(CafeBaixado cafe_baixado) {
        this(cafe_baixado.getLote(), cafe_baixado.getProdutor(), cafe_baixado.getStatus(), cafe_baixado.getData(), cafe_baixado.getSacas(),
             cafe_baixado.getQuilos(), cafe_baixado.getBarracao(), cafe_baixado.getSubproduto(), cafe_baixado.getNumero_nota(),
             cafe_baixado.getClassificacao(), cafe_baixado.getCatacao(), cafe_baixado.getPeneira(), cafe_baixado.getLancado(),
             cafe_baixado.getHumidade(), cafe_baixado.getObservacoes(), cafe_baixado.getReferencia(), cafe_baixado.getMeieiro(), cafe_baixado.getPorcentagem_produtor(),
             cafe_baixado.getPorcentagem_meieiro());
    }
}
