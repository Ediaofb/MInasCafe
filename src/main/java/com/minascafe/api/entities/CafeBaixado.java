package com.minascafe.api.entities;

//@author Edson Ferreira Barbosa

import java.io.Serializable;
import java.time.LocalDate;
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
    private String status;
    private LocalDate data;
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
    private String referencia;
    private String meieiro;
    private int porcentagem_produtor;
    private int porcentagem_meieiro;

}
