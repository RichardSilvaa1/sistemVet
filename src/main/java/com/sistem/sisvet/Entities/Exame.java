package com.sistem.sisvet.Entities;

import java.util.List;

import com.sistem.sisvet.Entities.Enums.TurnoExame;

public class Exame {
    private Long id;
    private String tipoExame;
    private double valorExame;
    private TurnoExame turno;
    private List<Descontos> desconto;

    public Exame(Long id, String tipoExame, double valorExame, TurnoExame turno, List<Descontos> desconto) {
        this.id = id;
        this.tipoExame = tipoExame;
        this.valorExame = valorExame;
        this.turno = turno;
        this.desconto = desconto;
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
    public TurnoExame getTurno() {
        return turno;
    }
    public void setTurno(TurnoExame turno) {
        this.turno = turno;
    }
    public List<Descontos> getDesconto() {
        return desconto;
    }
    public void setDesconto(List<Descontos> desconto) {
        this.desconto = desconto;
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
