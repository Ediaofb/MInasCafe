package com.minascafe.api.services;

import com.minascafe.api.entities.CafeCoco;
import com.minascafe.api.entities.Liga;
import com.minascafe.api.record.DadosCadastroLiga;

import java.util.List;
import java.util.Optional;

public interface LigaService {

    /**
     * Retorna uma liga dado um lote
     *
     * @param Lote
     * @return Liga
     * @author Edson
     */
    Optional <Liga> buscarPorLotes(String Lote);

    /**
     * Retorna uma liga dado um nomeliga
     *
     * @param nomeliga
     * @return Liga
     * @author Edson
     */
    Optional <Liga> buscarPorNomeliga(String nomeliga);

    /**
     * Retorna uma liga dado um Id
     *
     * @param Id
     * @return Liga
     * @author Edson
     */
    Optional <Liga> buscarPorId(int Id);

    /**
     * Cadastra uma liga na base de dados
     *
     * @param liga
     * @return liga
     * @author Edson
     */
    Liga persistir(Liga liga);

    /**
     * Remove uma liga da base de dados
     *
     * @param id
     */
    void remover(int id);

    /**
     * Cria uma liga classe liga
     * @param dadosLiga
     * @return Liga
     */
    Liga criarLiga(DadosCadastroLiga dadosLiga);

    /**
     * Deleta um lote de Café Máquina que foi inserido na Liga
     * @param lotes
     */
    void removerLotesCafeMaquina(List<String> lotes);

    /**
     * Deleta um lote de Café Beneficiado que foi inserido na Liga
     *
     * @param lotes
     */
    void removerLotesCafeBeneficiado(List<String> lotes);
}