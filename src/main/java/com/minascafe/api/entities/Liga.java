package com.minascafe.api.entities;

import com.minascafe.api.record.DadosCadastroLiga;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity //A classe é também uma entidade, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados onde os dados de objetos desse tipo poderão ser persistidos
@Table(name = "liga") //Define o nome da tabela no banco em que a entity representa (em caso de não ser o mesmo nome da Entity)
@Getter //Gera os métodos getters
@Setter //Gera os métodos setters
@ToString //Mostra os atributos da classe
public class Liga implements Serializable {

    @Id //Chave primária = Spring criará e gerenciará os identificadores únicos da tabela "cad_cafe_coco"
    @GeneratedValue
    private int id;
    private LocalDate data;

    @OneToMany(mappedBy = "liga", orphanRemoval = true, cascade = CascadeType.ALL) //Uma liga tem vários lotes. Referencia o campo liga da classe Lote. Se deletar uma liga, remove também os lotes dela.
    //CascadeType.All = operações de inserção, alteração e exclusão na classe liga serão aplicadas em cascata a classe lote
    private List<Lote> lotes = new ArrayList<Lote>();
    private int sacas;
    private Float quilos;
    private String produtor;
    private String bebida;
    private int somatorio_lotes;
    private int somatorio_sacas;
    private int somatorio_quilos;
    private String nomeliga;

    public Liga(){
    }

    public Liga(DadosCadastroLiga lig){
        this.data = lig.data();
        this.lotes = lig.lotes();
        this.sacas = lig.sacas();
        this.quilos = lig.quilos();
        this.produtor = lig.produtor();
        this.bebida = lig.bebida();
        this.somatorio_lotes = lig.somatorio_lotes();
        this.somatorio_sacas = lig.somatorio_sacas();
        this.somatorio_quilos = lig.somatorio_quilos();
        this.nomeliga = lig.nomeliga();
    }
}