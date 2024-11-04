package com.minascafe.api.record;

import com.minascafe.api.entities.CafeCoco;
import java.time.LocalDate;

public record DadosListagemCafeCoco(int lote, String produtor, String apelido, String status, LocalDate data, int sacos, float quilos,
 Float humidade, int barracao, String subproduto, int numero_nota, String classificacao, int catacao, int peneira, String lancado,
 String baixado, String observacoes, String referencia, String meieiro, int porcentagem_produtor, int porcentagem_meieiro){

    public DadosListagemCafeCoco(CafeCoco cafe_coco){
        this(cafe_coco.getLote(), cafe_coco.getProdutor(), cafe_coco.getApelido(), cafe_coco.getStatus(), cafe_coco.getData(), cafe_coco.getSacos(),
             cafe_coco.getQuilos(), cafe_coco.getHumidade() ,cafe_coco.getBarracao(), cafe_coco.getSubproduto(), cafe_coco.getNumero_nota(), cafe_coco.getClassificacao(),
             cafe_coco.getCatacao(), cafe_coco.getPeneira(), cafe_coco.getLancado(), cafe_coco.getBaixado(), cafe_coco.getObservacoes(),
             cafe_coco.getReferencia(), cafe_coco.getMeieiro(), cafe_coco.getPorcentagem_produtor(), cafe_coco.getPorcentagem_meieiro());
    }
}