package com.minascafe.api.record;

import com.minascafe.api.entities.CafeBeneficiado;
import java.time.LocalDate;

public record DadosListagemCafeBeneficiado(int lote, String produtor, String status, LocalDate data, int sacas, double quilos,
 int barracao, String subproduto, int numero_nota, String classificacao, int catacao, int peneira, String lancado,
 String observacoes, String referencia, String meieiro, int porcentagem_produtor, int porcentagem_meieiro) {

    public DadosListagemCafeBeneficiado(CafeBeneficiado cafe_beneficiado) {
        this(cafe_beneficiado.getLote(), cafe_beneficiado.getProdutor(), cafe_beneficiado.getApelido(), cafe_beneficiado.getData(),
            cafe_beneficiado.getSacas(), cafe_beneficiado.getQuilos(), cafe_beneficiado.getBarracao(), cafe_beneficiado.getSubproduto(),
            cafe_beneficiado.getNumero_nota(), cafe_beneficiado.getClassificacao(), cafe_beneficiado.getCatacao(), cafe_beneficiado.getPeneira(),
            cafe_beneficiado.getLancado(), cafe_beneficiado.getObservacoes(), cafe_beneficiado.getMeieiro(), cafe_beneficiado.getStatus(),
            cafe_beneficiado.getPorcentagem_produtor(), cafe_beneficiado.getPorcentagem_meieiro());
    }
}