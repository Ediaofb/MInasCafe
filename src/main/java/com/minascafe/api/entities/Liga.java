package com.minascafe.api.entities;

import com.minascafe.api.record.DadosAtualizacaoLiga;
import com.minascafe.api.record.DadosCadastroLiga;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity //A classe é também uma entidade, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados onde os dados de objetos desse tipo poderão ser persistidos
@Table(name = "liga") //Define o nome da tabela no banco em que a entity representa (em caso de não ser o mesmo nome da Entity)
@Component //Cria instância da classe
@Getter //Gera os métodos getters
@Setter //Gera os métodos setters
@ToString //Mostra os atributos da classe

public class Liga implements Serializable {

    @Id //Chave primária = Spring criará e gerenciará os identificadores únicos da tabela "cad_cafe_coco"
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liga_seq")
    @SequenceGenerator(name = "liga_seq", sequenceName = "liga_sequence", allocationSize = 1)//nome da sequencia no banco de dados. allocatioSize - define o tamanho do incremento.
    private int id;
    private LocalDate data;
    @ElementCollection
    private List<String> lotes;
    private int somatorio_lotes;
    private int somatorio_sacas;
    private Float somatorio_quilos;
    private String nomeliga;

    public Liga(){
    }

    public Liga(DadosCadastroLiga lig){
        this.data = lig.data();
        this.lotes = lig.lotes();
        this.somatorio_lotes = lig.somatorio_lotes();
        this.somatorio_sacas = lig.somatorio_sacas();
        this.somatorio_quilos = lig.somatorio_quilos();
        this.nomeliga = lig.nomeliga();
    }

    public void atualizarLiga(DadosAtualizacaoLiga dal){
        if (!dal.lotesVazio()){ //Se não estiver vazio ou nulo
            this.lotes = dal.lotes(); //atualiza
        }
        if(dal.somatorio_lotes() != null){
            this.somatorio_lotes = dal.somatorio_lotes();
        }
        if(dal.somatorio_quilos() != null){
            this.somatorio_quilos = dal.somatorio_quilos();
        }
        if(dal.somatorio_sacas() != null){
            this.somatorio_sacas = dal.somatorio_sacas();
        }
        if(dal.nomeliga() != null){
            this.nomeliga = dal.nomeliga();
        }
    }

    public void receberLotesCafeBeneficiado(List<CafeBeneficiado> lotes){
        for (CafeBeneficiado cafebeneficiado : lotes){
            cafebeneficiado.subtrairSacasQuilos(cafebeneficiado.getSacas(), cafebeneficiado.getQuilos());
        }
    }

    public void receberLotesCafeMaquina(List<CafeMaquina> lotes){
        for (CafeMaquina cafeMaquina : lotes){
            cafeMaquina.subtrairSacasQuilos(cafeMaquina.getSacas(), cafeMaquina.getQuilos());
        }
    }
}