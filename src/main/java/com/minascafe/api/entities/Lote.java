package com.minascafe.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Entity
public class Lote implements Serializable {

    @Id
    private String codigo;
    @JoinColumn(name = "liga_id") //Definição de chave estrangeira, de nome liga_id
    @ManyToOne //Muitos lotes para uma Liga
        private Liga liga;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }
}
