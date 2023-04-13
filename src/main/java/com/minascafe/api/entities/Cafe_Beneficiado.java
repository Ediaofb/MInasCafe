package com.minascafe.api.entities;
//@author Edson Ferreira Barbosa

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity //A classe é também uma entidade, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados onde os dados de objetos desse tipo poderão ser persistidos
@Table(name = "cad_cafe_beneficiado") //Define o nome da tabela no banco em que a entity representa (em caso de não ser o mesmo nome da Entity)


public class Cafe_Beneficiado implements Serializable{

    private static final long serialVersionUID = 5255241255596615186L;
    @Id //Chave primária = Spring criará e gerenciará os identificadores únicos da tabela "Cad_Cafe_Beneficiado"
    @GeneratedValue(strategy=GenerationType.IDENTITY)//Gera valores de maneira crescente iniciando pelo valor 1
    private int lote;

    private String produtor;
    private String status;
    private Date data;
    private int sacas;
    private double quilos;
    private int barracao;
    private String subproduto;
    private int numero_nota;
    private String classificacao;
    private int catacao;
    private int peneira;
    private String lancado;
    private String observacoes;
    private String meieiro;
    private int porcentagem_produtor;
    private int porcentagem_meieiro;

    public Cafe_Beneficiado() {
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    @Column (name = "produtor", nullable = false)
    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    @Column (name = "status", nullable = true)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column (name = "data", nullable = false)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Column (name = "sacas", nullable = false)
    public int getSacas() {
        return sacas;
    }

    public void setSacas(int sacas) {
        this.sacas = sacas;
    }

    @Column (name = "quilos", nullable = true)
    public double getQuilos() {
        return quilos;
    }

    public void setQuilos(double d) {
        this.quilos = d;
    }

    @Column (name = "barracao", nullable = true)
    public int getBarracao() {
        return barracao;
    }

    public void setBarracao(int barracao) {
        this.barracao = barracao;
    }

    @Column (name = "subproduto", nullable = true)
    public String getSubproduto() {
        return subproduto;
    }

    public void setSubproduto(String subproduto) {
        this.subproduto = subproduto;
    }

    @Column (name = "numero_nota", nullable = true)
    public int getNumero_nota() {
        return numero_nota;
    }

    public void setNumero_nota(int numero_nota) {
        this.numero_nota = numero_nota;
    }

    @Column (name = "classificacao", nullable = true)
    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    @Column (name = "catacao", nullable = true)
    public int getCatacao() {
        return catacao;
    }

    public void setCatacao(int catacao) {
        this.catacao = catacao;
    }

    @Column (name = "peneira", nullable = false)
    public int getPeneira() {
        return peneira;
    }

    public void setPeneira(int peneira) {
        this.peneira = peneira;
    }

    @Column (name = "lancado", nullable = false)
    public String getLancado() {
        return lancado;
    }

    public void setLancado(String lancado) {
        this.lancado = lancado;
    }

    @Column (name = "observacoes", nullable = false)
    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Column (name = "meieiro", nullable = false)
    public String getMeieiro() {
        return meieiro;
    }

    public void setMeieiro(String meieiro) {
        this.meieiro = meieiro;
    }

    @Column (name = "porcentagem_produtor", nullable = false)
    public int getPorcentagem_produtor() {
        return porcentagem_produtor;
    }

    public void setPorcentagem_produtor(int porcentagem_produtor) {
        this.porcentagem_produtor = porcentagem_produtor;
    }

    @Column (name = "porcentagem_meieiro", nullable = false)
    public int getPorcentagem_meieiro() {
        return porcentagem_meieiro;
    }

    public void setPorcentagem_meieiro(int porcentagem_meieiro) {

    }

    @PreUpdate //executa o método anotado antes da entidade ser atualizada
    public void preUpdate() {
        data = new Date();
    }

    @PrePersist //executa o método anotado antes da entidade ser persistida
    public void prePersist() {
        final Date atual = new Date();
        data = atual;
    }

    @Override
    public String toString() { //retorna uma representação string de um objeto
        return "Cafe_Beneficiado [lote=" + lote + ", produtor=" + produtor + ", status=" + status + ", data=" + data
                + ", sacas=" + sacas + ", quilos=" + quilos + ", barracao=" + barracao + ", subproduto=" + subproduto
                + ", numero_nota=" + numero_nota + ", classificacao=" + classificacao + ", catacao=" + catacao
                + ", peneira=" + peneira + ", lancado=" + lancado + ", observacoes=" + observacoes + "]";
    }

}