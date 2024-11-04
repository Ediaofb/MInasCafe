package com.minascafe.api.entities;
//@author Edson Ferreira Barbosa

import java.io.Serializable;
import java.time.LocalDate;
import com.minascafe.api.record.DadosAtualizacaoCafeMaquina;
import com.minascafe.api.record.DadosCadastroCafeMaquina;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Entity //A classe é também uma entidade, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados onde os dados de objetos desse tipo poderão ser persistidos
@Table(name = "cad_cafe_maquina") //Define o nome da tabela no banco em que a entity representa (em caso de não ser o mesmo nome da Entity)
@Component //Cria instância da classe
public class CafeMaquina implements Serializable{

    private static final long serialVersionUID = 57352917407981597L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//Gera valores de maneira crescente iniciando pelo valor 1
    private int lote;
    private String produtor;
    private String apelido;
    private String status;

    @Column(columnDefinition = "Bit(1)")
    private Boolean ativo;

    private LocalDate data;
    private int sacas;
    private float quilos;
    Float humidade;
    private int barracao;
    private String subproduto;
    private int numero_nota;
    private String classificacao;
    private int catacao;
    private int peneira;
    private String lancado;
    private String baixado;
    private String referencia;
    private String observacoes;
    private String meieiro;
    private int porcentagem_produtor;
    private int porcentagem_meieiro;

    public CafeMaquina(DadosCadastroCafeMaquina cm){
        this.produtor = cm.produtor();
        this.apelido = cm.apelido();
        this.ativo = true;  
        this.status = cm.status();
        this.data = cm.data();
        this.sacas = cm.sacas();
        this.quilos = cm.quilos();
        this.humidade = cm.humidade();
        this.barracao = cm.barracao();
        this.subproduto = cm.subproduto();
        this.numero_nota = cm.numero_nota();
        this.classificacao = cm.classificacao();
        this.catacao = cm.catacao();
        this.peneira = cm.peneira();
        this.lancado = "nao";
        this.baixado = "nao";
        this.observacoes = cm.observacoes();
        this.referencia = cm.referencia();
        this.meieiro = cm.meieiro();
        this.porcentagem_produtor = cm.porcentagem_produtor();
        this.porcentagem_meieiro = cm.porcentagem_meieiro();
    }

    public CafeMaquina(){
    }

    // public int getLote() {
    //     return lote;
    // }
    // public void setLote(int lote) {
    //     this.lote = lote;
    // }

    // @Column (name = "produtor", nullable = false)
    // public String getProdutor() {
    //     return produtor;
    // }
    // public void setProdutor(String produtor) {
    //     this.produtor = produtor;
    // }

    // @Column (name = "apelido", nullable = true)
    // public String getApelido(){ return apelido; }
    // public void setApelido(String apelido) { this.apelido = apelido; }

    // @Column (name = "status", nullable = true)
    // public String getStatus() {
    //     return status;
    // }
    // public void setStatus(String status) {
    //     this.status = status;
    // }

    // @Column (name = "data", nullable = false)
    // public LocalDate getData() {
    //     return data;
    // }
    // public void setData(LocalDate data) {
    //     this.data = data;
    // }

    // @Column (name = "sacas", nullable = false)
    // public int getSacas() {
    //     return sacas;
    // }
    // public void setSacas(int sacas) {
    //     this.sacas = sacas;
    // }

    // @Column (name = "quilos", nullable = false)
    // public float getQuilos() {
    //     return quilos;
    // }
    // public void setQuilos(float d) {
    //     this.quilos = d;
    // }

    // @Column (name = "humidade", nullable = false)
    // public Float getHumidade() { return humidade; }
    // public void setHumidade(Float humidade) { this.humidade = humidade; }

    // @Column (name = "barracao", nullable = true)
    // public int getBarracao() {
    //     return barracao;
    // }
    // public void setBarracao(int barracao) {
    //     this.barracao = barracao;
    // }

    // @Column (name = "subproduto", nullable = true)
    // public String getSubproduto() {
    //     return subproduto;
    // }
    // public void setSubproduto(String subproduto) {
    //     this.subproduto = subproduto;
    // }

    // @Column (name = "numero_nota", nullable = true)
    // public int getNumero_nota() {
    //     return numero_nota;
    // }
    // public void setNumero_nota(int numero_nota) {
    //     this.numero_nota = numero_nota;
    // }

    // @Column (name = "classificacao", nullable = true)
    // public String getClassificacao() {
    //     return classificacao;
    // }
    // public void setClassificacao(String classificacao) {
    //     this.classificacao = classificacao;
    // }

    // @Column (name = "catacao", nullable = true)
    // public int getCatacao() {
    //     return catacao;
    // }
    // public void setCatacao(int catacao) {
    //     this.catacao = catacao;
    // }

    // @Column (name = "peneira", nullable = false)
    // public int getPeneira() {
    //     return peneira;
    // }
    // public void setPeneira(int peneira) {
    //     this.peneira = peneira;
    // }

    // @Column (name = "lancado", nullable = false)
    // public String getLancado() {
    //     return lancado;
    // }
    // public void setLancado(String lancado) {
    //     this.lancado = lancado;
    // }

    // @Column (name = "baixado", nullable = false)
    // public String getBaixado() {
    //     return baixado;
    // }

    // @Column (name = "referencia", nullable = false)
    // public String getReferencia() {
    //     return referencia;
    // }
    // public void setReferencia(String referencia) {
    //     this.referencia = referencia;
    // }

    // @Column (name = "meieiro", nullable = false)
    // public String getMeieiro() {
    //     return meieiro;
    // }
    // public void setMeieiro(String meieiro) {
    //     this.meieiro = meieiro;
    // }

    // @Column (name = "porcentagem_produtor", nullable = false)
    // public int getPorcentagem_produtor() {
    //     return porcentagem_produtor;
    // }
    // public void setPorcentagem_produtor(int porcentagem_produtor) {
    //     this.porcentagem_produtor = porcentagem_produtor;
    // }

    // @Column (name = "porcentagem_meieiro", nullable = false)
    // public int getPorcentagem_meieiro() {
    //     return porcentagem_meieiro;
    // }
    // public void setPorcentagem_meieiro(int porcentagem_meieiro) {
    //     this.porcentagem_meieiro = porcentagem_meieiro;
    // }

    // @Column (name = "observacoes", nullable = false)
    // public String getObservacoes() {
    //     return observacoes;
    // }
    // public void setObservacoes(String observacoes) {
    //     this.observacoes = observacoes;
    // }

    /*@PreUpdate //executa o método anotado antes da entidade ser atualizada
    public void preUpdate() {
        data = new Date();
    }
    @PrePersist //executa o método anotado antes da entidade ser persistida
    public void prePersist() {
        final Date atual = new Date();
        data = atual;
    }*/

    // @Override
    // public String toString() {
    //     return "CafeMaquina [" +
    //            "lote=" + lote +
    //            ", produtor=" + produtor + 
    //            ", apelido=" + apelido + 
    //            ", ativo=" + ativo + 
    //            ", status=" + status + 
    //            ", data=" + data + 
    //            ", sacas=" + sacas + 
    //            ", quilos=" + quilos + 
    //            ", humidade=" + humidade +
    //            ", barracao=" + barracao + 
    //            ", subproduto=" + subproduto + 
    //            ", numero_nota=" + numero_nota + 
    //            ", classificacao=" + classificacao + 
    //            ", catacao=" + catacao + 
    //            ", peneira=" + peneira + 
    //            ", lancado=" + lancado + 
    //            ", baixado" + baixado + 
    //            ", referencia=" + referencia + 
    //            ", observacoes=" + observacoes + 
    //            ", meieiro=" + meieiro + 
    //            ", porcentagem_produtor=" + porcentagem_produtor + 
    //            ", porcentagem_meieiro=" + porcentagem_meieiro + "]";
    // }

    public void inativar() {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizacaoCafeMaquina cm) {
        if (cm.produtor() != null){
            this.produtor = cm.produtor();
        }
        if(cm.data() != null){
            this.data = cm.data();
        }
        if(cm.sacas() != null){
            this.sacas = cm.sacas();
        }
        if(cm.quilos() != null){
            this.quilos = cm.quilos();
        }
        if(cm.barracao() != null){
            this.barracao = cm.barracao();
        }
        if(cm.humidade() != null){
            this.humidade = cm.humidade();
        }
        if(cm.subproduto() != null){
            this.subproduto = cm.subproduto();
        }
        if(cm.numero_nota() != null){
            this.numero_nota = cm.numero_nota();
        }
        if(cm.classificacao() != null){
            this.classificacao = cm.classificacao();
        }
        if(cm.catacao() != null){
            this.catacao = cm.catacao();
        }
        if(cm.peneira() != null){
            this.peneira = cm.peneira();
        }
        if(cm.lancado() != null){
            this.lancado = cm.lancado();
        }
        if(cm.baixado() != null){
            this.baixado = cm.baixado();
        }
        if(cm.meieiro() != null){
            this.meieiro = cm.meieiro();
        }
        if(cm.observacoes() != null){
            this.observacoes = cm.observacoes();
        }
        if(cm.porcentagem_meieiro() != null){
            this.porcentagem_meieiro = cm.porcentagem_meieiro();
        }
        if(cm.porcentagem_produtor() != null){
            this.porcentagem_produtor = cm.porcentagem_produtor();
        }
        if(cm.referencia() != null){
            this.referencia = cm.referencia();
        }
        if(cm.ativo() != null){
          this.ativo =  cm.ativo();
        }
    }

    public void subtrairSacasQuilos(int sacas, float quilos) { //subtrai sacas e quilos utilizados em uma liga
       this.sacas -= sacas;
       this.quilos -= quilos;
    }
}