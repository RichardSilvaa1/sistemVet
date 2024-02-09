package com.sistem.sisvet.Entities;

public class TurnoExame{

    private long id;
    private String descricao;
    private Exame tipoExame;
    private double valorExame;
    public TurnoExame(long id, String descricao, double valorExame) {
        this.id = id;
        this.descricao = descricao;
        this.valorExame = valorExame;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Exame getTipoExame() {
        return tipoExame;
    }
    public void setTipoExame(Exame tipoExame) {
        this.tipoExame = tipoExame;
    }
    public double getValorExame() {
        return valorExame;
    }
    public void setValorExame(double valorExame) {
        this.valorExame = valorExame;
    }


    
}