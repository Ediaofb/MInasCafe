package com.minascafe.api.entities;
//@author Edson Ferreira Barbosa

import java.io.Serializable;
import java.time.LocalDate;
import com.minascafe.api.record.DadosAtualizacaoCafeBeneficiado;
import com.minascafe.api.record.DadosCadastroCafeBeneficiado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Entity //A classe é também uma entidade, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados onde os dados de objetos desse tipo poderão ser persistidos
@Table(name = "cad_cafe_beneficiado") //Define o nome da tabela no banco em que a entity representa (em caso de não ser o mesmo nome da Entity)
@Component
public class CafeBeneficiado implements Serializable{

    private static final long serialVersionUID = 5255241255596615186L;
    @Id //Chave primária = Spring criará e gerenciará os identificadores únicos da tabela "Cad_Cafe_Beneficiado"
    @GeneratedValue(strategy=GenerationType.IDENTITY)//Gera valores de maneira crescente iniciando pelo valor 1
    private int lote;
    private String produtor;
    private String apelido;
    private boolean ativo;
    private String status;
    private LocalDate data;
    private int sacas;
    private float quilos;
    private Float humidade;
    private int barracao;
    private String subproduto;
    private int numero_nota;
    private String classificacao;
    private int catacao;
    private int peneira;
    private String lancado;
    private String observacoes;
    private String referencia;
    private String meieiro;
    private int porcentagem_produtor;
    private int porcentagem_meieiro;

    public CafeBeneficiado(DadosCadastroCafeBeneficiado cb) {
        this.produtor = cb.produtor();
        this.apelido = cb.apelido();
        this.ativo = true;
        this.data = cb.data();
        this.catacao = cb.catacao();
        this.barracao = cb.barracao();
        this.humidade = cb.humidade();
        this.classificacao = cb.classificacao();
        this.lancado = "nao";
        this.peneira = cb.peneira();
        this.numero_nota = cb.numero_nota();
        this.referencia = cb.referencia();
        this.status = cb.status();
        this.subproduto = cb.subproduto();
        this.sacas = cb.sacas();
        this.quilos = cb.quilos();
        this.observacoes = cb.observacoes();
        this.meieiro = cb.meieiro();
        this.porcentagem_meieiro = cb.porcentagem_meieiro();
        this.porcentagem_produtor = cb.porcentagem_produtor();
    }

    public CafeBeneficiado(){
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

    @Column (name = "apelido", nullable = true)
    public String getApelido(){ return apelido; }

    public void setApelido(String apelido) {this.apelido = apelido;}

    @Column (name = "status", nullable = true)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column (name = "data", nullable = false)
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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
    public float getQuilos() {
        return quilos;
    }

    public void setQuilos(float d) {
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

    @Column (name = "peneira", nullable = true)
    public int getPeneira() {
        return peneira;
    }

    public void setPeneira(int peneira) {
        this.peneira = peneira;
    }

    @Column (name = "lancado", nullable = true)
    public String getLancado() {
        return lancado;
    }

    public void setLancado(String lancado) {
        this.lancado = lancado;
    }

    @Column (name = "observacoes", nullable = true)
    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Column (name = "meieiro", nullable = true)
    public String getMeieiro() {
        return meieiro;
    }

    public void setMeieiro(String meieiro) {
        this.meieiro = meieiro;
    }

    @Column (name = "porcentagem_produtor", nullable = true)
    public int getPorcentagem_produtor() {
        return porcentagem_produtor;
    }

    public void setPorcentagem_produtor(int porcentagem_produtor) {
        this.porcentagem_produtor = porcentagem_produtor;
    }

    @Column (name = "porcentagem_meieiro", nullable = true)
    public int getPorcentagem_meieiro() {
        return porcentagem_meieiro;
    }

    public void setPorcentagem_meieiro(int porcentagem_meieiro) {
      this.porcentagem_meieiro = porcentagem_meieiro;
    }

    @Column (name = "humidade", nullable = true)
        public float gethumidade() { return humidade; }

    public void setHumidade(float humidade){
        this.humidade = humidade;
    }

/*    @PreUpdate //executa o método anotado antes da entidade ser atualizada
    public void preUpdate() {
        data = new Date();
    }

    @PrePersist //executa o método anotado antes da entidade ser persistida
    public void prePersist() {
        final Date atual = new Date();
        data = atual;
    }*/

    @Override
    public String toString() {
        return "CafeBeneficiado{" +
                "lote=" + lote +
                ", produtor='" + produtor + '\'' +
                ", apelido='" + apelido + '\'' +
                ", ativo=" + ativo +
                ", status='" + status + '\'' +
                ", data=" + data +
                ", sacas=" + sacas +
                ", quilos=" + quilos +
                ", humidade=" + humidade +
                ", barracao=" + barracao +
                ", subproduto='" + subproduto + '\'' +
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

    public void inativar() {
        this.ativo = false;
    }

    public void atualizarInformacoes(DadosAtualizacaoCafeBeneficiado cb) {
        if(cb.produtor() != null){
            this.produtor = cb.produtor();
        }
        if(cb.data() != null){
            this.data = cb.data();
        }
        if(cb.sacas() != null){
            this.sacas = cb.sacas();
        }
        if(cb.quilos() != null){
            this.quilos = cb.quilos();
        }
        if(cb.barracao() != null){
            this.barracao = cb.barracao();
        }
        if(cb.catacao() != null){
            this.catacao = cb.catacao();
        }
        if(cb.classificacao() != null){
            this.classificacao = cb.classificacao();
        }
        if(cb.lancado() != null){
            this.lancado = cb.lancado();
        }
        if(cb.humidade() != null){
            this.humidade = cb.humidade();
        }
        if(cb.meieiro() != null){
            this.meieiro = cb.meieiro();
        }
        if(cb.numero_nota() != null){
            this.numero_nota = cb.numero_nota();
        }
        if(cb.subproduto() != null){
            this.subproduto = cb.subproduto();
        }
        if(cb.observacoes() != null){
            this.observacoes = cb.observacoes();
        }
        if(cb.peneira() != null){
            this.peneira = cb.peneira();
        }
        if(cb.porcentagem_produtor() != null){
            this.porcentagem_produtor = cb.porcentagem_produtor();
        }
        if (cb.porcentagem_meieiro() != null){
            this.porcentagem_meieiro = cb.porcentagem_meieiro();
        }
    }

    public void subtrairSacasQuilos(int sacas, float quilos) { //subtrai sacas e quilos utilizados em uma liga
        this.sacas -= sacas;
        this.quilos -= quilos;
    }
}