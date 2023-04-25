package com.minascafe.api.services;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.CafeBaixado;

import java.util.Optional;
//**********************************************************************************************************************
//******O "SERVICE" é uma camada acima do JPA Repository e será consumido por um CONTROLLER mais adiante****************
//**********************************************************************************************************************


public interface CafeBaixadoService {//Lógica de negócios da aplicação

    /**
     * Retorna um CafeBaixado dado um Lote
     *
     * @param Lote
     * @return CafeBaixado
     */
    Optional <CafeBaixado> buscarPorLote(int Lote);

    /**
     * Retorna um Café Baixado dado um Produtor
     *
     * @param produtor
     * @return cafe_baixado
     */
    Optional <CafeBaixado> buscarPorProdutor(String Produtor);

    /**
     * Cadastra um Café Baixado na base de dados
     * @param cafe_baixado
     * @return cafe_baixado
     */
    CafeBaixado persistir(CafeBaixado cafe_baixado);

    /**
     * Remove um Café Baixado da base de dados
     *
     * @param id
     */
    void remover(int id);
}
