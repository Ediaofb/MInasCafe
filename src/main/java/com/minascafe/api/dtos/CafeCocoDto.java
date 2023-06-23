package com.minascafe.api.dtos;

import java.util.Date;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CafeCocoDto {

    private int lote;
    private String produtor;
    private String apelido;
    private Date data;
    private int catacao;
    private int barracao;
    private String classificacao;
    private String lancado;
    private int peneira;
    private float humidade;
    private int numero_nota;
    private String status;
    private String referencia;
    private String subproduto;
    private int sacos;
    private float quilos;
    private String observacoes;
    private String meieiro;
    private String porcentagem_meieiro;
    private String porcentagem_produtor;

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    public String getApelido() {
        return apelido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBarracao() {
        return barracao;
    }

    public void setBarracao(int barracao) {
        this.barracao = barracao;
    }

    public String getSubproduto() {
        return subproduto;
    }

    public void setSubproduto(String subproduto) {
        this.subproduto = subproduto;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMeieiro() {
        return meieiro;
    }

    public void setMeieiro(String meieiro) {
        this.meieiro = meieiro;
    }

    public String getPorcentagem_produtor() {
        return porcentagem_produtor;
    }

    public void setPorcentagem_produtor(String porcentagem_produtor) {
        this.porcentagem_produtor = porcentagem_produtor;
    }

    public int getLote() {
        return lote;
    }
    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getPorcentagem_meieiro() {
        return porcentagem_meieiro;
    }

    public void setPorcentagem_meieiro(String porcentagem_meieiro) {
        this.porcentagem_meieiro = porcentagem_meieiro;
    }

    @Override
    public String toString() {
        return "CafeCocoDto{" +
                "lote=" + lote +
                ", produtor='" + produtor + '\'' +
                ", apelido='" + apelido + '\'' +
                ", data=" + data +
                ", catacao=" + catacao +
                ", barracao=" + barracao +
                ", classificacao='" + classificacao + '\'' +
                ", lancado='" + lancado + '\'' +
                ", peneira=" + peneira +
                ", humidade=" + humidade +
                ", numero_nota=" + numero_nota +
                ", status='" + status + '\'' +
                ", referencia='" + referencia + '\'' +
                ", subproduto='" + subproduto + '\'' +
                ", sacos=" + sacos +
                ", quilos=" + quilos +
                ", observacoes='" + observacoes + '\'' +
                ", meieiro='" + meieiro + '\'' +
                ", porcentagem_meieiro='" + porcentagem_meieiro + '\'' +
                ", porcentagem_produtor='" + porcentagem_produtor + '\'' +
                '}';
    }

    public CafeCocoDto() {
    }

    @NotEmpty(message = "O nome não pode ser vazio.") // Regra de validação - O nome do produtor não pode ser vazio
    @Length(min = 3, max = 50, message = "O nome do produtor deve conter entre 3 e 40 caracteres.")
    public String getProdutor() {
        return produtor;
    }
    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    @NotNull(message = "A data não pode ser vazia.")
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public int getSacos() {
        return sacos;
    }
    public void setSacos(int sacos) {
        this.sacos = sacos;
    }
    public double getQuilos() {
        return quilos;
    }
    public void setQuilos(float quilos) {
        this.quilos = quilos;
    }

}