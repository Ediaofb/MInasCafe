package com.minascafe.api.services;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.CafeMaquina;

public interface CafeMaquinaService { //Lógica de negócios da aplicação

    /**
     * Retorna um Café que foi beneficiado no armazém dado um lote
     *
     * @param Lote
     * @return CafeMaquina
     * @author Edson
     */
    Optional<CafeMaquina> buscarPorLote(int Lote);

    /**
     * Retorna um Café que foi beneficiado no armazém dado um produtor
     *
     * @param Produtor
     * @return CafeMaquina
     * @author Edson
     */
    Optional<CafeMaquina> buscarPorProdutor(String Produtor);

    /**
     * Cadastra um Café beneficiado na base de dados
     *
     * @param cafe_beneficiado
     * @return cafe_beneficiado
     * @author Edson
     */
    CafeMaquina persistir(CafeMaquina cafe_Maquina);

    /**
     * Remove um café beneficiado da base de dados
     *
     * @param id
     */
    void remover(int lote);
}