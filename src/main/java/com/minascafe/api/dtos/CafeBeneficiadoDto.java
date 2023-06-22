package com.minascafe.api.dtos;

import java.util.Date;

public class CafeBeneficiadoDto {

    private int lote;
    private String produtor;
    private boolean ativo;
    private Date data;
    private int sacas;
    private double quilos;
    private String subproduto;
    private Float humidade;
    private int numero_nota;
    private String classificacao;
    private int catacao;
    private int peneira;
    private String lancado;
    private String observacoes;
    private String meieiro;
    private int porcentagem_produtor;
    private int porcentagem_meieiro;

    public CafeBeneficiadoDto() {
    }

    public int getLote() {
        return lote;
    }
    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getProdutor() {
        return produtor;
    }
    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public int getSacas() {
        return sacas;
    }
    public void setSacas(int sacas) {
        this.sacas = sacas;
    }

    public double getQuilos() {
        return quilos;
    }
    public void setQuilos(double quilos) {
        this.quilos = quilos;
    }

    public String getSubproduto() {
        return subproduto;
    }
    public void setSubproduto(String subproduto) {
        this.subproduto = subproduto;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Float getHumidade() {
        return humidade;
    }

    public void setHumidade(Float humidade) {
        this.humidade = humidade;
    }

    public int getNumero_nota() {
        return numero_nota;
    }

    public void setNumero_nota(int numero_nota) {
        this.numero_nota = numero_nota;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public int getCatacao() {
        return catacao;
    }

    public void setCatacao(int catacao) {
        this.catacao = catacao;
    }

    public int getPeneira() {
        return peneira;
    }

    public void setPeneira(int peneira) {
        this.peneira = peneira;
    }

    public String getLancado() {
        return lancado;
    }

    public void setLancado(String lancado) {
        this.lancado = lancado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getMeieiro() {
        return meieiro;
    }

    public void setMeieiro(String meieiro) {
        this.meieiro = meieiro;
    }

    public int getPorcentagem_produtor() {
        return porcentagem_produtor;
    }

    public void setPorcentagem_produtor(int porcentagem_produtor) {
        this.porcentagem_produtor = porcentagem_produtor;
    }

    public int getPorcentagem_meieiro() {
        return porcentagem_meieiro;
    }

    public void setPorcentagem_meieiro(int porcentagem_meieiro) {
        this.porcentagem_meieiro = porcentagem_meieiro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return "CafeBeneficiadoDto{" +
                "lote=" + lote +
                ", produtor='" + produtor + '\'' +
                ", ativo=" + ativo +
                ", data=" + data +
                ", sacas=" + sacas +
                ", quilos=" + quilos +
                ", subproduto='" + subproduto + '\'' +
                ", humidade=" + humidade +
                ", numero_nota=" + numero_nota +
                ", classificacao='" + classificacao + '\'' +
                ", catacao=" + catacao +
                ", peneira=" + peneira +
                ", lancado='" + lancado + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", meieiro='" + meieiro + '\'' +
                ", porcentagem_produtor=" + porcentagem_produtor +
                ", porcentagem_meieiro=" + porcentagem_meieiro +
                '}';
    }

}
