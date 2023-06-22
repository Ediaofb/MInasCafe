package com.minascafe.api.services;

import com.minascafe.api.entities.Liga;

import java.time.LocalDate;
import java.util.Optional; //uma espécie de caixa que pode ser preenchida ou não, caso possua algo

public interface LigaService { //Lógica de negócios da aplicação - controle, gestão

    /**
     * Retorna uma liga dado um lote
     *
     * @param lote
     * @Return Liga
     * @author Edson
     */
    Optional<Liga> buscarPorLotes(String lote);

    /**
     * Retorna uma liga dado uma data
     *
     * @param data
     * @Return Liga
     * @autor Edson
     */
    Optional<Liga> buscarPorData(LocalDate data);

    /**
     * Retorna uma liga dado um id
     *
     * @param id
     * @Return Liga
     * @author Edson
     */
    Optional<Liga> buscarPorId(int id);

    /**
     * Retorna uma liga dado um nomeliga
     *
     * @param nomeliga
     * @Return Liga
     * @author Edson
     */
    Optional<Liga> buscarPorNomeliga(String nomeliga);
}
