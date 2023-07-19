package com.minascafe.api.entities;

import com.minascafe.api.record.DadosAtualizarAmostra;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.time.LocalDate;

import com.minascafe.api.record.DadosCadastroAmostraSemEstoque;

@Setter
@Getter
@ToString
@Entity
@Table(name = "amostra_sem_estoque")
public class AmostraSemEstoque implements Serializable {

    @Id //Chave primária = Spring criará e gerenciará os identificadores únicos da tabela "cad_cafe_coco"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String produtor;
    private String apelido;
    private LocalDate data;
    private int catacao;
    private int peneira;
    private String classificacao;
    private Float humidade;
    private String observacoes;

    public AmostraSemEstoque(){
    }

    public AmostraSemEstoque(DadosCadastroAmostraSemEstoque dcase){
      this.produtor = dcase.produtor();
      this.apelido = dcase.apelido();
      this.data = dcase.data();
      this.catacao = dcase.catacao();
      this.peneira = dcase.peneira();
      this.classificacao = dcase.classificacao();
      this.humidade = dcase.humidade();
      this.observacoes = dcase.observacoes();
    }

    public void atualizarAmostra(DadosAtualizarAmostra aa){
         if (aa.produtor() != null){
             this.produtor = aa.produtor();
         }
         if (aa.apelido() != null){
             this.apelido = aa.apelido();
         }
         if (aa.data() != null){
             this.data = aa.data();
         }
         if (aa.catacao() != null){
             this.catacao = aa.catacao();
         }
         if (aa.peneira() != null){
             this.peneira = aa.peneira();
         }
         if (aa.classificacao() != null){
             this.classificacao = aa.classificacao();
         }
         if (aa.humidade() != null){
             this.humidade = aa.humidade();
         }
         if (aa.observacoes() != null){
             this.observacoes = aa.observacoes();
         }
    }
}
