package com.minascafe.api.entities;
//@author Edson Ferreira Barbosa

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ficha_produtor") //Define o nome da tabela no banco em que a entity representa (em caso de não ser o mesmo nome da Entity)
public class Ficha_Produtor implements Serializable{

    private static final long serialVersionUID = -7197449617554309251L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//Gera valores de maneira crescente iniciando pelo valor 1
    private int id;//visibilidade - tipo - nome

    private String nome;
    private String apelido;
    private String cpf;
    private String telefone;
    private Date data;
    private String entrada_saida;
    private String lote;
    private float duro;
    private float riado;
    private float rio;
    private float escolha;
    private int renda;
    private int humidade;
    private float valor_total;
    private String banco;
    private String agencia;
    private String operacao;
    private String tipo_conta;
    private String numero_conta;
    private String nome_corentista;
    private String chave_pix;
    private Date aniversario;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column (name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column (name = "apelido", nullable = true)
    public String getApelido() {
        return apelido;
    }
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Column (name = "cpf", nullable = true)
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column (name = "banco", nullable = true)
    public String getBanco() {
        return banco;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }

    @Column (name = "agencia", nullable = true)
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    @Column (name = "operacao", nullable = true)
    public String getOperacao() {
        return operacao;
    }
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    @Column (name = "tipo_conta", nullable = true)
    public String getTipo_conta() {
        return tipo_conta;
    }
    public void setTipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    @Column (name = "numero_conta", nullable = true)
    public String getNumero_conta() {
        return numero_conta;
    }
    public void setNumero_conta(String numero_conta) {
        this.numero_conta = numero_conta;
    }

    @Column (name = "nome_correntista", nullable = true)
    public String getNome_corentista() {
        return nome_corentista;
    }
    public void setNome_corentista(String nome_corentista) {
        this.nome_corentista = nome_corentista;
    }

    @Column (name = "chave_pix", nullable = true)
    public String getChave_pix() {
        return chave_pix;
    }
    public void setChave_pix(String chave_pix) {
        this.chave_pix = chave_pix;
    }
    @Column (name = "telefone", nullable = true)
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column (name = "data", nullable = false)
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    @Column (name = "entrada_saida", nullable = false)
    public String getEntrada_saida() {
        return entrada_saida;
    }
    public void setEntrada_saida(String entrada_saida) {
        this.entrada_saida = entrada_saida;
    }

    @Column (name = "lote", nullable = false)
    public String getLote() {
        return lote;
    }
    public void setLote(String lote) {
        this.lote = lote;
    }

    @Column(name = "duro", nullable = true)
    public float getDuro() {
        return duro;
    }
    public void setDuro(float duro) {
        this.duro = duro;
    }

    @Column (name = "riado", nullable = true)
    public float getRiado() {
        return riado;
    }
    public void setRiado(float riado) {
        this.riado = riado;
    }

    @Column (name = "rio", nullable = true)
    public float getRio() {
        return rio;
    }
    public void setRio(float rio) {
        this.rio = rio;
    }

    @Column (name = "escolha", nullable = true)
    public float getEscolha() {
        return escolha;
    }
    public void setEscolha(float escolha) {
        this.escolha = escolha;
    }

    @Column (name = "renda", nullable = true)
    public int getRenda() {
        return renda;
    }
    public void setRenda(int renda) {
        this.renda = renda;
    }

    @Column (name = "humidade", nullable = true)
    public int getHumidade() {
        return humidade;
    }
    public void setHumidade(int humidade) {
        this.humidade = humidade;
    }

    @Column (name = "valor_total", nullable = true)
    public float getValor_total() {
        return valor_total;
    }
    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    @Column (name = "aniversario", nullable = true)
    public Date getAniversario(){
        return aniversario;
    }
    public void setAniversario(Date aniversario){
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return "Ficha_Produtor [id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", cpf=" + cpf + ", telefone="
                + telefone + ", data=" + data + ", entrada_saida=" + entrada_saida + ", lote=" + lote + ", duro=" + duro
                + ", riado=" + riado + ", rio=" + rio + ", escolha=" + escolha + ", renda=" + renda + ", humidade="
                + humidade + ", valor_total=" + valor_total + ", banco=" + banco + ", agencia=" + agencia
                + ", operacao=" + operacao + ", tipo_conta=" + tipo_conta + ", numero_conta=" + numero_conta
                + ", nome_corentista=" + nome_corentista + ", chave_pix=" + chave_pix + ", aniversario=" + aniversario + "]";
    }
}