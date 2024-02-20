package com.sistem.sisvet.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.sistem.sisvet.Entities.Enums.FormaPagamento;

public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L; 
    
    private Long id;
    private String paciente;
    private Clinica clinica;
    private LocalDateTime data;
    private List<Exame> exames;
    private FormaPagamento formaPagamento;
    private double valorTotalAtendimento;
    private double valorTotalVeterinarioRecebe;

    
    
    public Atendimento(Long id, String paciente, Clinica clinica, LocalDateTime data, List<Exame> exames,
            FormaPagamento formaPagamento, double valorTotalAtendimento, double valorTotalVeterinarioRecebe) {
        this.id = id;
        this.paciente = paciente;
        this.clinica = clinica;
        this.data = data;
        this.exames = exames;
        this.formaPagamento = formaPagamento;
        this.valorTotalAtendimento = valorTotalAtendimento;
        this.valorTotalVeterinarioRecebe = valorTotalVeterinarioRecebe;
    }

    

    public static long getSerialversionuid() {
        return serialVersionUID;
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



    public LocalDateTime getData() {
        return data;
    }



    public void setData(LocalDateTime data) {
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



    public double getvalorTotalAtendimento() {
        return valorTotalAtendimento;
    }



    public void setvalorTotalAtendimento(double valorTotalAtendimento) {
        this.valorTotalAtendimento = valorTotalAtendimento;
    }



    public double getvalorTotalVeterinarioRecebe() {
        return valorTotalVeterinarioRecebe;
    }



    public void setvalorTotalVeterinarioRecebe(double valorTotalVeterinarioRecebe) {
        this.valorTotalVeterinarioRecebe = valorTotalVeterinarioRecebe;
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