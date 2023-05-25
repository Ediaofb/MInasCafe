package com.minascafe.api.entities;

//@author Edson Ferreira Barbosa

import java.io.Serializable;
import java.time.LocalDate;

import com.minascafe.api.record.DadosAtualizacaoCafeBaixado;
import com.minascafe.api.record.DadosCadastroCafeBaixado;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity //A classe é também uma entidade, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados onde os dados de objetos desse tipo poderão ser persistidos
@Table(name = "cad_cafe_baixado") //Define o nome da tabela no banco em que a entity representa (em caso de não ser o mesmo nome da Entity)
@Getter //Gera os métodos getters
@Setter //Gera os métodos setters
@ToString //Mostra os atributos da classe
@NoArgsConstructor //Gera o construtor default, sem argumentos
@AllArgsConstructor //Gera um construtor que recebe todos os campos
@EqualsAndHashCode(of = "lote") //Verifica se valor/tipo de objetos são iguais e gera referência (hash) sobre o lote
//O lombok gera os códigos em tempo de compilação

public class CafeBaixado implements Serializable{

    private static final long serialVersionUID = 2069695207928350720L;

    @Id //Chave primária = Spring criará e gerenciará os identificadores únicos da tabela "cad_cafe_coco"
    @GeneratedValue(strategy=GenerationType.IDENTITY)//Gera valores de maneira crescente iniciando pelo valor 1

    private int lote;
    private String produtor;
    private String apelido;
    private String status;
    private LocalDate data;
    private int sacas;
    private float quilos;
    private int barracao;
    private String subproduto;
    private int numero_nota;
    private String classificacao;
    private int catacao;
    private int peneira;
    private Float humidade;
    private String lancado;
    private String observacoes;
    private String referencia;
    private String meieiro;
    private int porcentagem_produtor;
    private int porcentagem_meieiro;

    public CafeBaixado(DadosCadastroCafeBaixado baix){
        this.produtor = baix.produtor();
        this.apelido = baix.apelido();
        this.status = baix.status();
        this.data = baix.data();
        this.sacas = baix.sacas();
        this.quilos = baix.quilos();
        this.barracao = baix.barracao();
        this.subproduto = baix.subproduto();
        this.numero_nota = baix.numero_nota();
        this.classificacao = baix.classificacao();
        this.catacao = baix.catacao();
        this.peneira = baix.peneira();
        this.humidade = baix.humidade();
        this.lancado = baix.lancado();
        this.observacoes = baix.observacoes();
        this.referencia = baix.referencia();
        this.meieiro = baix.meieiro();
        this.porcentagem_produtor = baix.porcentagem_produtor();
        this.porcentagem_meieiro = baix.porcentagem_meieiro();
    }

    public void atualizarBaixado(DadosAtualizacaoCafeBaixado baix){
        if(baix.produtor() != null){
            this.produtor = baix.produtor();
        }
        if(baix.data() != null){
            this.data = baix.data();
        }
        if(baix.catacao() != null){
            this.catacao = baix.catacao();
        }
        if(baix.classificacao() != null){
            this.classificacao = baix.classificacao();
        }
        if(baix.humidade() != null){
            this.humidade = baix.humidade();
        }
        if(baix.lancado() != null){
            this.lancado = baix.lancado();
        }
        if(baix.meieiro() != null){
            this.meieiro = baix.meieiro();
        }
        if(baix.numero_nota() != null) {
            this.numero_nota = baix.numero_nota();
        }
        if(baix.peneira() != null){
            this.peneira = baix.peneira();
        }
        if(baix.observacoes() != null){
            this.observacoes = baix.observacoes();
        }
        if(baix.porcentagem_meieiro() != null){
            this.porcentagem_meieiro = baix.porcentagem_meieiro();
        }
        if(baix.porcentagem_produtor() != null){
            this.porcentagem_produtor = baix.porcentagem_produtor();
        }
    }
}