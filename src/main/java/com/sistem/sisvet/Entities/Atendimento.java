package com.sistem.sisvet.Entities;

import java.util.List;

public class Atendimento {
    private Long id;
    private String paciente;
    private Clinica clinica;
    private String data;
    private List<Exame> exames;
    private FormaPagamento formaPagamento;
    private double valorVeterinarioRecebe;
    public Atendimento(Long id, String paciente, Clinica clinica, String data, List<Exame> exames,
            FormaPagamento formaPagamento, double valorVeterinarioRecebe) {
        this.id = id;
        this.paciente = paciente;
        this.clinica = clinica;
        this.data = data;
        this.exames = exames;
        this.formaPagamento = formaPagamento;
        this.valorVeterinarioRecebe = valorVeterinarioRecebe;
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
    public Clinica getClinica() {
        return clinica;
    }
    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public List<Exame> getExames() {
        return exames;
    }
    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public double getValorVeterinarioRecebe() {
        return valorVeterinarioRecebe;
    }
    public void setValorVeterinarioRecebe(double valorVeterinarioRecebe) {
        this.valorVeterinarioRecebe = valorVeterinarioRecebe;
    }

    


}