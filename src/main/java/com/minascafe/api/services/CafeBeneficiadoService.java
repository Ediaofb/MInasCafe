package com.minascafe.api.services;
//@author Edson Ferreira Barbosa

import com.minascafe.api.entities.CafeBeneficiado;

import java.util.List;
import java.util.Optional;

public interface CafeBeneficiadoService { // Lógica de negócios da aplicação

    /**
     * Retorna um CafeBeneficiado dado um lote
     *
     * @param Lote
     * @return CafeBeneficiado
     * @author Edson
     */
    Optional<CafeBeneficiado> buscarPorLote(int Lote);

    /**
     * Retorna um Café Beneficiado dado um produtor
     *
     * @param Produtor
     * @return cafe_Beneficiado
     * @author Edson
     */
    Optional<List<CafeBeneficiado>> buscarPorProdutor(String Produtor);

    /**
     * Cadastra um Café Beneficiado na base de dados
     * 
     * @param cafe_beneficiado
     * @return cafe_beneficiado
     * @author Edson
     */
    CafeBeneficiado persistir(CafeBeneficiado cafe_beneficiado);

    /**
     * Remove um café Beneficiado da base de dados
     *
     * @param lote
     */
    void remover(int lote);
}