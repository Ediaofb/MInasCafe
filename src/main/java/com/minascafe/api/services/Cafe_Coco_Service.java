package com.minascafe.api.services;
//@author Edson Ferreira Barbosa

import java.util.Optional;

import com.minascafe.api.entities.Cafe_Coco;

public interface Cafe_Coco_Service { //Lógica de negócios da aplicação

    /**
     * Retorna um Café em Côco dado um lote
     *
     * @param Lote
     * @return Cafe_Coco
     * @author Edson
     */
    Optional <Cafe_Coco> buscarPorLote(int Lote);

    /**
     * Retorna um Café em Côco dado um produtor
     *
     * @param Produtor
     * @return Cafe_Coco
     * @author Edson
     */
    Optional<Cafe_Coco> buscarPorProdutor(String Produtor);

    /**
     * Cadastra um Café em Côco na base de dados
     *
     * @param cafe_coco
     * @return cafe_coco
     * @author Edson
     */
    Cafe_Coco persistir(Cafe_Coco cafe_coco);

    /**
     * Remove um café em côco da base de dados
     *
     * @param lote
     */
    void remover(int lote);
}
