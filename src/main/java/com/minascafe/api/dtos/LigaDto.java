package com.minascafe.api.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString

public class LigaDto {

    private int id;
    private LocalDate data;
    private List<String> lote;
    private int sacas;
    private Float quilos;
    private String produtor;
    private String bebida;
    private int somatorio_lotes;
    private int somatorio_sacas;
    private int somatorio_quilos;
    private String nomeliga;
}
