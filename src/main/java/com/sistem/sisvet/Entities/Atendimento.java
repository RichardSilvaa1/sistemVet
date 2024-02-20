package com.sistem.sisvet.Entities;

import java.util.List;

import com.sistem.sisvet.Entities.Enums.FormaPagamento;

public class Atendimento {
    private Long id;
    private String paciente;
    private Clinica clinica;
    private String data;
    private List<Exame> exames;
    private FormaPagamento formaPagamento;
    private double valorAtendimento;
    private double valorVeterinarioRecebe;

    
    public Atendimento(Long id, String paciente, Clinica clinica, String data, List<Exame> exames,
            FormaPagamento formaPagamento, double valorAtendimento, double valorVeterinarioRecebe) {
        this.id = id;
        this.paciente = paciente;
        this.clinica = clinica;
        this.data = data;
        this.exames = exames;
        this.formaPagamento = formaPagamento;
        this.valorAtendimento = valorAtendimento;
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
    public double getValorAtendimento() {
        return valorAtendimento;
    }
    public void setValorAtendimento(double valorAtendimento) {
        this.valorAtendimento = valorAtendimento;
    }
    public double getValorVeterinarioRecebe() {
        return valorVeterinarioRecebe;
    }
    public void setValorVeterinarioRecebe(double valorVeterinarioRecebe) {
        this.valorVeterinarioRecebe = valorVeterinarioRecebe;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Atendimento other = (Atendimento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    


}