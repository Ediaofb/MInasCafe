package com.minascafe.api.dtos;

public class Ficha_ProdutorDto {

    private int id;//visibilidade - tipo - nome
    private String nome;
    private String apelido;
    private String cpf;
    private String telefone;

    public Ficha_ProdutorDto() {
    }

    public int getId() {
        return id;
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
        return "Ficha_ProdutorDto [id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", cpf=" + cpf
                + ", telefone=" + telefone + "]";
    }
}