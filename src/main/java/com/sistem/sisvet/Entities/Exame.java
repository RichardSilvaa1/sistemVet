package com.sistem.sisvet.Entities;

import java.util.List;

public class Exame {
    private Long id;
    private String tipoExame;
    private double descontoSound;
    private double descontoNf;
    private double descontoAparelho;
    private double valorExame;
    private List<TurnoExame> turnoExame;
    
    

    public Exame(Long id, String tipoExame, double descontoSound, double descontoNf, double descontoAparelho,
            double valorExame, List<TurnoExame> turnoExame) {
        this.id = id;
        this.tipoExame = tipoExame;
        this.descontoSound = descontoSound;
        this.descontoNf = descontoNf;
        this.descontoAparelho = descontoAparelho;
        this.valorExame = valorExame;
        this.turnoExame = turnoExame;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public double getDescontoSound() {
        return descontoSound;
    }

    public void setDescontoSound(double descontoSound) {
        this.descontoSound = descontoSound;
    }

    public double getDescontoNf() {
        return descontoNf;
    }

    public void setDescontoNf(double descontoNf) {
        this.descontoNf = descontoNf;
    }

    public double getDescontoAparelho() {
        return descontoAparelho;
    }

    public void setDescontoAparelho(double descontoAparelho) {
        this.descontoAparelho = descontoAparelho;
    }

    public double getValorExame() {
        return valorExame;
    }

    public void setValorExame(double valorExame) {
        this.valorExame = valorExame;
    }

    public List<TurnoExame> getTurnoExame() {
        return turnoExame;
    }

    public void setTurnoExame(List<TurnoExame> turnoExame) {
        this.turnoExame = turnoExame;
    }

}
