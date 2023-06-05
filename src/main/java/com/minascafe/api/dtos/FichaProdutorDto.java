package com.minascafe.api.dtos;

import com.minascafe.api.entities.FichaProdutor;

import java.time.LocalDate;

public class FichaProdutorDto {

    private int id;//visibilidade - tipo - nome
    LocalDate data;
    private String nome;
    private String apelido;
    private String cpf;
    private String telefone;
    private int renda;
    private float humidade;
    private float valor_total;
    private String banco;
    private String agencia;
    private String operacao;
    private String tipo_conta;
    private String numero_conta;
    private String nome_correntista;
    private String chave_pix;
    private int saldo_duro_sacos;
    private Float saldo_duro_quilos;
    private Integer saldo_riado_sacos;
    private Float saldo_riado_quilos;
    private Integer saldo_rio_sacos;
    private Float saldo_rio_quilos;
    private Integer saldo_escolha_sacos;
    private Float saldo_escolha_quilos;
    private Integer saldo_mooca_sacos;
    private Float saldo_mooca_quilos;
    private Float preco;


    public FichaProdutorDto() {
    }

    public static FichaProdutorDto converter(FichaProdutor fp){ //converte Entidade para classe de response (dto)
        var fichaprod = new FichaProdutorDto();
        fichaprod.setId(fp.getId());
        fichaprod.setData(fp.getData());
        fichaprod.setNome(fp.getNome());
        fichaprod.setApelido(fp.getApelido());
        fichaprod.setCpf(fp.getCpf());
        fichaprod.setTelefone(fp.getTelefone());
        fichaprod.setRenda(fp.getRenda());
        fichaprod.setHumidade(fp.getHumidade());
        fichaprod.setValor_total(fp.getValor_total());
        fichaprod.setBanco(fp.getBanco());
        fichaprod.setAgencia(fp.getAgencia());
        fichaprod.setOperacao(fp.getOperacao());
        fichaprod.setTipo_conta(fp.getTipo_conta());
        fichaprod.setNumero_conta(fp.getNumero_conta());
        fichaprod.setNome_correntista(fp.getNome_correntista());
        fichaprod.setChave_pix(fp.getChave_pix());
        fichaprod.setSaldo_duro_sacos(fp.getSaldo_duro_sacos());
        fichaprod.setSaldo_duro_quilos(fp.getSaldo_duro_quilos());
        fichaprod.setSaldo_riado_sacos(fp.getSaldo_riado_sacos());
        fichaprod.setSaldo_duro_quilos(fp.getSaldo_riado_quilos());
        fichaprod.setSaldo_rio_sacos(fp.getSaldo_rio_sacos());
        fichaprod.setSaldo_rio_quilos(fp.getSaldo_rio_quilos());
        fichaprod.setSaldo_escolha_sacos(fp.getSaldo_escolha_sacos());
        fichaprod.setSaldo_escolha_quilos(fp.getSaldo_escolha_quilos());
        fichaprod.setSaldo_mooca_sacos(fp.getSaldo_mooca_sacos());
        fichaprod.setSaldo_mooca_quilos(fp.getSaldo_mooca_quilos());
        fichaprod.setPreco(fp.getPreco());
        return fichaprod;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getRenda() {
        return renda;
    }

    public void setRenda(int renda) {
        this.renda = renda;
    }

    public float getHumidade() {
        return humidade;
    }

    public void setHumidade(float humidade) {
        this.humidade = humidade;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    public String getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;
    }

    public String getNome_correntista() {
        return nome_correntista;
    }

    public void setNome_correntista(String nome_correntista) {
        this.nome_correntista = nome_correntista;
    }

    public String getChave_pix() {
        return chave_pix;
    }

    public void setChave_pix(String chave_pix) {
        this.chave_pix = chave_pix;
    }

    public int getSaldo_duro_sacos() {
        return saldo_duro_sacos;
    }

    public void setSaldo_duro_sacos(int saldo_duro_sacos) {
        this.saldo_duro_sacos = saldo_duro_sacos;
    }

    public Float getSaldo_duro_quilos() {
        return saldo_duro_quilos;
    }

    public void setSaldo_duro_quilos(Float saldo_duro_quilos) {
        this.saldo_duro_quilos = saldo_duro_quilos;
    }

    public Integer getSaldo_riado_sacos() {
        return saldo_riado_sacos;
    }

    public void setSaldo_riado_sacos(Integer saldo_riado_sacos) {
        this.saldo_riado_sacos = saldo_riado_sacos;
    }

    public Float getSaldo_riado_quilos() {
        return saldo_riado_quilos;
    }

    public void setSaldo_riado_quilos(Float saldo_riado_quilos) {
        this.saldo_riado_quilos = saldo_riado_quilos;
    }

    public Integer getSaldo_rio_sacos() {
        return saldo_rio_sacos;
    }

    public void setSaldo_rio_sacos(Integer saldo_rio_sacos) {
        this.saldo_rio_sacos = saldo_rio_sacos;
    }

    public Float getSaldo_rio_quilos() {
        return saldo_rio_quilos;
    }

    public void setSaldo_rio_quilos(Float saldo_rio_quilos) {
        this.saldo_rio_quilos = saldo_rio_quilos;
    }

    public Integer getSaldo_escolha_sacos() {
        return saldo_escolha_sacos;
    }

    public void setSaldo_escolha_sacos(Integer saldo_escolha_sacos) {
        this.saldo_escolha_sacos = saldo_escolha_sacos;
    }

    public Float getSaldo_escolha_quilos() {
        return saldo_escolha_quilos;
    }

    public void setSaldo_escolha_quilos(Float saldo_escolha_quilos) {
        this.saldo_escolha_quilos = saldo_escolha_quilos;
    }

    public Integer getSaldo_mooca_sacos() {
        return saldo_mooca_sacos;
    }

    public void setSaldo_mooca_sacos(Integer saldo_mooca_sacos) {
        this.saldo_mooca_sacos = saldo_mooca_sacos;
    }

    public Float getSaldo_mooca_quilos() {
        return saldo_mooca_quilos;
    }

    public void setSaldo_mooca_quilos(Float saldo_mooca_quilos) {
        this.saldo_mooca_quilos = saldo_mooca_quilos;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getApelido() {
        return apelido;
    }
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "FichaProdutorDto{" +
                "id=" + id +
                ", data=" + data +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", renda='" + renda + '\'' +
                ", humidade=" + humidade +
                ", valor_total=" + valor_total +
                ", banco='" + banco + '\'' +
                ", agencia='" + agencia + '\'' +
                ", operacao='" + operacao + '\'' +
                ", tipo_conta='" + tipo_conta + '\'' +
                ", numero_conta='" + numero_conta + '\'' +
                ", nome_correntista='" + nome_correntista + '\'' +
                ", chave_pix='" + chave_pix + '\'' +
                ", saldo_duro_sacos=" + saldo_duro_sacos +
                ", saldo_duro_quilos=" + saldo_duro_quilos +
                ", saldo_riado_sacos=" + saldo_riado_sacos +
                ", saldo_riado_quilos=" + saldo_riado_quilos +
                ", saldo_rio_sacos=" + saldo_rio_sacos +
                ", saldo_rio_quilos=" + saldo_rio_quilos +
                ", saldo_escolha_sacos=" + saldo_escolha_sacos +
                ", saldo_escolha_quilos=" + saldo_escolha_quilos +
                ", saldo_mooca_sacos=" + saldo_mooca_sacos +
                ", saldo_mooca_quilos=" + saldo_mooca_quilos +
                ", preco=" + preco +
                '}';
    }

}