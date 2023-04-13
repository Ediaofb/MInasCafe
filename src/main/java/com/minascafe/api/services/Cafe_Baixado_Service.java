package com.minascafe.api.services;
//@author Edson Ferreira Barbosa

import java.util.Optional;
//**********************************************************************************************************************
//******O "SERVICE" é uma camada acima do JPA Repository e será consumido por um CONTROLLER mais adiante****************
//**********************************************************************************************************************

import com.minascafe.api.entities.Cafe_Baixado;

public interface Cafe_Baixado_Service {//Lógica de negócios da aplicação

    /**
     * Retorna um Cafe_Baixado dado um Lote
     *
     * @param Lote
     * @return Cafe_Baixado
     */
    Optional <Cafe_Baixado> buscarPorLote(int Lote);

    /**
     * Retorna um Café Baixado dado um Produtor
     *
     * @param produtor
     * @return cafe_baixado
     */
    Optional <Cafe_Baixado> buscarPorProdutor(String Produtor);

    /**
     * Cadastra um Café Baixado na base de dados
     * @param cafe_baixado
     * @return cafe_baixado
     */
    Cafe_Baixado persistir(Cafe_Baixado cafe_baixado);

    /**
     * Remove um Café Baixado da base de dados
     *
     * @param id
     */
    void remover(int id);
}
