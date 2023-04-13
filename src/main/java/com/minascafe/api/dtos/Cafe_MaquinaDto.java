package com.minascafe.api.dtos;

import java.util.Date;

public class Cafe_MaquinaDto {

    private int lote;
    private String produtor;
    private Date data;
    private int sacas;
    private double quilos;
    private String subproduto;

    public Cafe_MaquinaDto() {
    }

    public int getLote() {
        return lote;
    }
    public void setLote(int lote) {
        this.lote = lote;
    }
    public String getProdutor() {
        return produtor;
    }
    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public int getSacas() {
        return sacas;
    }
    public void setSacas(int sacas) {
        this.sacas = sacas;
    }
    public double getQuilos() {
        return quilos;
    }
    public void setQuilos(double quilos) {
        this.quilos = quilos;
    }
    public String getSubproduto() {
        return subproduto;
    }
    public void setSubproduto(String subproduto) {
        this.subproduto = subproduto;
    }

    @Override
    public String toString() {
        return "Cafe_Maquina [lote=" + lote + ", produtor=" + produtor + ", data=" + data
                + ", sacas=" + sacas + ", quilos=" + quilos + ", subproduto=" + subproduto
                + "]";
    }
}
