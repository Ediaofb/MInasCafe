package com.minascafe.api.services;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.Cafe_Beneficiado;

public interface Cafe_Beneficiado_Service { //Lógica de negócios da aplicação

    /**
     * Retorna um Cafe_Beneficiado dado um lote
     *
     * @param Lote
     * @return Cafe_Beneficiado
     * @author Edson
     */
    Optional <Cafe_Beneficiado> buscarPorLote(int Lote);

    /**
     * Retorna um Café Beneficiado dado um produtor
     *
     * @param produtor
     * @return cafe_Beneficiado
     * @author Edson
     */
    Optional <Cafe_Beneficiado> buscarPorProdutor(String Produtor);

    /**
     * Cadastra um Café Beneficiado na base de dados
     * @param cafe_beneficiado
     * @return cafe_beneficiado
     * @author Edson
     */
    Cafe_Beneficiado persistir(Cafe_Beneficiado cafe_beneficiado);

    /**
     * Remove um café Beneficiado da base de dados
     *
     * @param lote
     */
    void remover(int lote);
}
