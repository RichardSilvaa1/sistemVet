package com.sistem.sisvet.Entities;

import java.util.List;

public class Exame {
    private Long id;
    private String tipoExame;
    private double descontoSound;
    private double descontoNf;
    private List<TurnoExame> turnoExame;
    
    public Exame(Long id, String tipoExame, double descontoSound, double descontoNf, List<TurnoExame> turnoExame) {
        this.id = id;
        this.tipoExame = tipoExame;
        this.descontoSound = descontoSound;
        this.descontoNf = descontoNf;
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

    public List<TurnoExame> getTurnoExame() {
        return turnoExame;
    }

    public void setTurnoExame(List<TurnoExame> turnoExame) {
        this.turnoExame = turnoExame;
    }
    
    // Método para calcular o valor do exame com base nos descontos e valores do turno
    public double calcularValorExame() {
        double valorExame = 0.0;
        if (turnoExame != null && !turnoExame.isEmpty()) {
            TurnoExame turno = turnoExame.get(0); // Supondo que cada exame tenha apenas um turno
            double valorTurno = turno.getValorExame();
            valorExame += valorTurno;

            // Aplicar descontos
            valorExame *= (1 - descontoSound);
            valorExame *= (1 - descontoNf);
        }
        return valorExame;
    }
}
