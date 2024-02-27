package com.minascafe.api.entities;
//@author Edson Ferreira Barbosa

import java.io.Serializable;
import java.time.LocalDate;

import com.minascafe.api.record.DadosAtualizacaoFichaProdutor;
import com.minascafe.api.record.DadosCadastroFichaProdutor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ficha_produtor") //Define o nome da tabela no banco em que a entity representa (em caso de não ser o mesmo nome da Entity)
@Getter //Gera os métodos getters
@Setter //Gera os métodos setters
@ToString //Mostra os atributos da classe
@NoArgsConstructor //Gera o construtor default, sem argumentos (parâmetros)
@AllArgsConstructor //Gera um construtor que recebe todos os campos
@EqualsAndHashCode //Verifica se valor/tipo de objetos são iguais e gera referência (hash) sobre o lote
//O lombok gera os códigos em tempo de compilação

public class FichaProdutor implements Serializable{

    private static final long serialVersionUID = -7197449617554309251L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//Gera valores de maneira crescente iniciando pelo valor 1
    private int id;//visibilidade - tipo - nome

    private String lote;
    private String nome;
    private String apelido;
    private String cpf;
    private String telefone;
    private LocalDate data;
    private boolean ativo;
    private String entrada_saida;
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
    private Integer saldo_duro_sacos;
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

    public FichaProdutor(DadosCadastroFichaProdutor fp) {
        this.lote = fp.lote();
        this.nome = fp.nome();
        this.apelido = fp.apelido();
        this.cpf = fp.cpf();
        this.telefone = fp.telefone();
        this.data = fp.data();
        this.entrada_saida = fp.entrada_saida();
        this.renda = fp.renda();
        this.humidade = fp.humidade();
        this.valor_total = fp.valor_total();
        this.banco = fp.banco();
        this.agencia = fp.agencia();
        this.operacao = fp.operacao();
        this.tipo_conta = fp.tipo_conta();
        this.numero_conta = fp.numero_conta();
        this.nome_correntista = fp.nome_correntista();
        this.chave_pix = fp.chave_pix();
        this.saldo_duro_sacos = fp.saldo_duro_sacos();
        this.saldo_duro_quilos = fp.saldo_duro_quilos();
        this.saldo_riado_sacos = fp.saldo_riado_sacos();
        this.saldo_riado_quilos = fp.saldo_riado_quilos();
        this.saldo_rio_sacos = fp.saldo_rio_sacos();
        this.saldo_rio_quilos = fp.saldo_rio_quilos();
        this.saldo_escolha_sacos = fp.saldo_escolha_sacos();
        this.saldo_escolha_quilos = fp.saldo_escolha_quilos();
        this.saldo_mooca_sacos = fp.saldo_mooca_sacos();
        this.saldo_mooca_quilos = fp.saldo_mooca_quilos();
        this.preco = fp.preco();
    }

    public void atualizarInformacoes(DadosAtualizacaoFichaProdutor fb) {

        if(fb.data() != null){
          this.data = fb.data();
        }
        if(fb.produtor() != null){
          this.nome = fb.produtor();
        }
        if(fb.cpf() != null){
            this.cpf = fb.cpf();
        }
        if(fb.telefone() != null){
            this.telefone = fb.telefone();
        }
        if(fb.banco() != null){
            this.banco = fb.banco();
        }
        if(fb.agencia() != null){
            this.agencia = fb.agencia();
        }
        if(fb.operacao() != null){
            this.operacao = fb.operacao();
        }
        if(fb.numero_conta() != null){
            this.numero_conta = fb.numero_conta();
        }
        if(fb.nome_correntista() != null){
            this.nome_correntista = fb.nome_correntista();
        }
        if(fb.chave_pix() != null){
            this.chave_pix = fb.chave_pix();
        }
        if(fb.renda() != null){
            this.renda = fb.renda();
        }
        if(fb.entrada_saida() != null){
            this.entrada_saida = fb.entrada_saida();
        }
        if(fb.humidade() != null){
            this.humidade = fb.humidade();
        }
        if(fb.saldo_duro_sacos() != null){
            this.saldo_riado_sacos = fb.saldo_duro_sacos();
        }
        if(fb.saldo_duro_quilos() != null){
            this.saldo_duro_quilos = fb.saldo_duro_quilos();
        }
        if(fb.saldo_riado_sacos() != null){
            this.saldo_riado_sacos = fb.saldo_riado_sacos();
        }
        if(fb.saldo_riado_quilos() != null){
            this.saldo_riado_quilos = fb.saldo_riado_quilos();
        }
        if(fb.saldo_rio_sacos() != null){
            this.saldo_rio_sacos = fb.saldo_rio_sacos();
        }
        if(fb.saldo_rio_quilos() != null){
            this.saldo_rio_quilos = fb.saldo_rio_quilos();
        }
        if(fb.saldo_escolha_sacos() != null){
            this.saldo_escolha_sacos = fb.saldo_escolha_sacos();
        }
        if(fb.saldo_escolha_quilos() != null){
            this.saldo_escolha_quilos = fb.saldo_escolha_quilos();
        }
        if(fb.saldo_mooca_sacos() != null){
            this.saldo_mooca_sacos = fb.saldo_mooca_sacos();
        }
        if(fb.saldo_mooca_quilos() != null){
            this.saldo_mooca_quilos = fb.saldo_mooca_quilos();
        }
        if(fb.preco() != null){
            this.preco = fb.preco();
        }
    }
}