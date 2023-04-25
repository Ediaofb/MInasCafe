package com.minascafe.api.services;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.CafeCoco;

public interface CafeCocoService { //Lógica de negócios da aplicação

    /**
     * Retorna um Café em Côco dado um lote
     *
     * @param Lote
     * @return CafeCoco
     * @author Edson
     */
    Optional <CafeCoco> buscarPorLote(int Lote);

    /**
     * Retorna um Café em Côco dado um produtor
     *
     * @param Produtor
     * @return CafeCoco
     * @author Edson
     */
    Optional<CafeCoco> buscarPorProdutor(String Produtor);

    /**
     * Cadastra um Café em Côco na base de dados
     *
     * @param cafe_coco
     * @return cafe_coco
     * @author Edson
     */
    CafeCoco persistir(CafeCoco cafe_coco);

    /**
     * Remove um café em côco da base de dados
     *
     * @param lote
     */
    void remover(int lote);
}
