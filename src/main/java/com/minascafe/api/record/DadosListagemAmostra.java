package com.minascafe.api.record;

import com.minascafe.api.entities.AmostraSemEstoque;

import java.time.LocalDate;
import java.util.Date;

public record DadosListagemAmostra(int id, String produtor, String apelido, LocalDate data, int catacao, int peneira, String classificacao,
 Float humidade, String observacoes) {

    public DadosListagemAmostra(AmostraSemEstoque amostra){
        this(amostra.getId(), amostra.getProdutor(), amostra.getApelido(), amostra.getData(), amostra.getCatacao(), amostra.getPeneira(),
             amostra.getClassificacao(), amostra.getHumidade(), amostra.getObservacoes());
    }
}