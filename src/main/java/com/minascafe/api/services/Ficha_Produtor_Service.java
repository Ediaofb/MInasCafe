package com.minascafe.api.services;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.Ficha_Produtor;

public interface Ficha_Produtor_Service { //Lógica de negócios da aplicação

    /**
     * Retorna a ficha de um produtor dado um id
     *
     * @param Id
     * @return Ficha Produtor
     * @author Edson
     */
    Optional<Ficha_Produtor> buscarPorId(int Id);

    /**
     * Retorna a ficha de um produtor dado um nome
     *
     * @param nome
     * @return Ficha Produtor
     * @author Edson
     */
    Optional<Ficha_Produtor> buscarPorNome(String nome);

    /**
     * Retorna a ficha de um produtor dado um apelido
     *
     * @param apelido
     * @return Ficha Produtor
     * @author Edson
     */
    Optional<Ficha_Produtor> buscarPorApelido(String apelido);

    /**
     * Retorna a ficha de um produtor dado um cpf
     *
     * @param cpf
     * @retun Ficha Produtor
     * @author Edson
     */
    Optional<Ficha_Produtor> buscarPorCpf(String cpf);

    /**
     * Remove um produtor da base de dados
     *
     * @param nome
     */
    void remover(String nome);
}
