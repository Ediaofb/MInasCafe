package com.minascafe.api.record;

import com.minascafe.api.entities.Cafe_Coco;

import java.util.Date;


public record DadosListagemCafeCoco(int lote, String produtor, String status, Date data, int sacos, double quilos,
  int barracao, String subproduto, int numero_nota, String classificacao, int catacao, int peneira, String lancado,
  String observacoes, String referencia, String meieiro, String porcentagem_produtor, String porcentagem_meieiro){

    public DadosListagemCafeCoco(Cafe_Coco cafe_coco){
        this(cafe_coco.getLote(), cafe_coco.getProdutor(), cafe_coco.getStatus(), cafe_coco.getData(), cafe_coco.getSacos(),
             cafe_coco.getQuilos(), cafe_coco.getBarracao(), cafe_coco.getSubproduto(), cafe_coco.getNumero_nota(), cafe_coco.getClassificacao(),
             cafe_coco.getCatacao(), cafe_coco.getPeneira(), cafe_coco.getLancado(),cafe_coco.getObservacoes(),
             cafe_coco.getReferencia(), cafe_coco.getMeieiro(), cafe_coco.getPorcentagem_produtor(), cafe_coco.getPorcentagem_meieiro());
    }
}
