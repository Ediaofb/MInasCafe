package com.minascafe.api.services;
//@author Edson Ferreira Barbosa

import java.util.Optional;
import com.minascafe.api.entities.Cafe_Maquina;

public interface Cafe_Maquina_Service { //Lógica de negócios da aplicação

    /**
     * Retorna um Café que foi beneficiado no armazém dado um lote
     *
     * @param Lote
     * @return Cafe_Maquina
     * @author Edson
     */
    Optional<Cafe_Maquina> buscarPorLote(int Lote);

    /**
     * Retorna um Café que foi beneficiado no armazém dado um produtor
     *
     * @param Produtor
     * @return Cafe_Maquina
     * @author Edson
     */
    Optional<Cafe_Maquina> buscarPorProdutor(String Produtor);

    /**
     * Cadastra um Café beneficiado na base de dados
     *
     * @param cafe_beneficiado
     * @return cafe_beneficiado
     * @author Edson
     */
    Cafe_Maquina persistir(Cafe_Maquina cafe_Maquina);

    /**
     * Remove um café beneficiado da base de dados
     *
     * @param id
     */
    void remover(int lote);
}