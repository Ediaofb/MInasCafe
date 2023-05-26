package com.minascafe.api.record;

import com.minascafe.api.entities.FichaProdutor;

import java.time.LocalDate;

public record DadosListagemFichaProdutor(int id, String lote, String nome, String apelido, String cpf, String telefone, LocalDate data,
  String entrada_saida, int renda, float humidade, float valor_total, String banco, String agencia, String operacao, String tipo_conta,
  String numero_conta, String nome_correntista, String chave_pix, int saldo_duro_sacos, float saldo_duro_quilos, int saldo_riado_sacos,
  float saldo_riado_quilos, int saldo_rio_sacos, float saldo_rio_quilos, int saldo_escolha_sacos, float saldo_escolha_quilos,
  int saldo_mooca_sacos, float saldo_mooca_quilos, float preco) {

    public DadosListagemFichaProdutor(FichaProdutor ficha_produtor){
        this(ficha_produtor.getId(), ficha_produtor.getLote(), ficha_produtor.getNome(), ficha_produtor.getApelido(), ficha_produtor.getCpf(),
            ficha_produtor.getTelefone(), ficha_produtor.getData(), ficha_produtor.getEntrada_saida(), ficha_produtor.getRenda(), ficha_produtor.getHumidade(),
            ficha_produtor.getValor_total(), ficha_produtor.getBanco(), ficha_produtor.getAgencia(), ficha_produtor.getOperacao(),ficha_produtor.getTipo_conta(),
            ficha_produtor.getNumero_conta(), ficha_produtor.getNome_correntista(), ficha_produtor.getChave_pix(), ficha_produtor.getSaldo_duro_sacos(),
            ficha_produtor.getSaldo_duro_quilos(), ficha_produtor.getSaldo_riado_sacos(), ficha_produtor.getSaldo_riado_quilos(), ficha_produtor.getSaldo_rio_sacos(),
            ficha_produtor.getSaldo_rio_quilos(), ficha_produtor.getSaldo_escolha_sacos(), ficha_produtor.getSaldo_escolha_quilos(), ficha_produtor.getSaldo_mooca_sacos(),
            ficha_produtor.getSaldo_mooca_quilos(), ficha_produtor.getPreco());
    }
}
