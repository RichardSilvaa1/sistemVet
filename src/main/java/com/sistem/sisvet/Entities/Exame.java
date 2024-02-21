package com.sistem.sisvet.Entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="exames")
public class Exame implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// geracao de chaves id no bando de dados automaticamente conforme for inserindo
    private Long id;
    
    @Column(nullable = false) // criacao da coluna no banco de dados nao podendo ter valores nulos
    private String tipoExame;

    @Column(nullable = false)
    private double valorExame;

    @ManyToOne(fetch= FetchType.LAZY)//anotação é usada para especificar um relacionamento muitos-para-um entre entidades.
    private List<Descontos> desconto;

    @Column(nullable = false)
    private double valorExameVet;
    

    public Exame(Long id, String tipoExame, double valorExame, List<Descontos> desconto,
            double valorExameVet) {
        this.id = id;
        this.tipoExame = tipoExame;
        this.valorExame = valorExame;
        
        this.desconto = desconto;
        this.valorExameVet = valorExameVet;
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


    public double getValorExame() {
        return valorExame;
    }


    public void setValorExame(double valorExame) {
        this.valorExame = valorExame;
    }


    public List<Descontos> getDesconto() {
        return desconto;
    }


    public void setDesconto(List<Descontos> desconto) {
        this.desconto = desconto;
    }


    public double getValorExameVet() {
        return valorExameVet;
    }


    public void setValorExameVet(double valorExameVet) {
        this.valorExameVet = valorExameVet;
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
        Exame other = (Exame) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
