package com.sistem.sisvet.Entities;

import java.util.List;

public class Atendimento {
    private Long id;
    private String paciente;
    private String clinica;
    private String data;
    private List<Exame> exames;
    private FormaPagamento formaPagamento;
    private double valorVeterinarioRecebe;

    // Construtor, getters e setters

    public void realizarPagamento() {
        double totalExames = calcularTotalExames();
        if (formaPagamento != null) {
            formaPagamento.processarPagamento(totalExames);
        } else {
            // Lidar com o caso em que a forma de pagamento não está definida
        }
    }

    private double calcularTotalExames() {
        double total = 0.0;
        for (Exame exame : exames) {
            total += exame.calcularValorExame();
        }
        return total;
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