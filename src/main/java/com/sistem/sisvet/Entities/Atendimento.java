package com.sistem.sisvet.Entities;

import java.util.Date;
import java.util.List;

public class Atendimento {
    
    private Long id;
    private String paciente;
    private String clinica;
    private Date data;
    private List<Exame> tipoExames;
    private Exame tipoExame;
    private List<TurnoExame> turnoExame;

    private FormaPagamento formaPagamento;

    public Atendimento(Long id, String paciente, String clinica, Date data, List<Exame> tipoExames) {
        this.id = id;
        this.paciente = paciente;
        this.clinica = clinica;
        this.data = data;
        this.tipoExames = tipoExames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Exame> getTipoExames() {
        return tipoExames;
    }

    public void setTipoExames(List<Exame> tipoExames) {
        this.tipoExames = tipoExames;
    }

    public Exame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(Exame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public List<TurnoExame> getTurnoExame() {
        return turnoExame;
    }

    public void setTurnoExame(List<TurnoExame> turnoExame) {
        this.turnoExame = turnoExame;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    // Método para calcular o valor total do exame com base nos turnos associados
    public double calcularValorExame() {
        double valorTotalExame = 0.0;
        for (TurnoExame turnoExame : this.turnoExame) {
            valorTotalExame += turnoExame.getValorExame();
        }
        return valorTotalExame;
    }
}
