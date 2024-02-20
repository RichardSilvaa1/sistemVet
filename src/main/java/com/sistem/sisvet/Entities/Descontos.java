package com.sistem.sisvet.Entities;

public class Descontos {
    
    private Long id;
    private String tipoDesc;
    private double valorDesc;

    
    
    public Descontos(Long id, String tipoDesc, double valorDesc) {
        this.id = id;
        this.tipoDesc = tipoDesc;
        this.valorDesc = valorDesc;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTipoDesc() {
        return tipoDesc;
    }
    public void setTipoDesc(String tipoDesc) {
        this.tipoDesc = tipoDesc;
    }
    public double getvalorDesc() {
        return valorDesc;
    }
    public void setvalorDesc(double valorDesc) {
        this.valorDesc = valorDesc;
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
        Descontos other = (Descontos) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    

    



}
