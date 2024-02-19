package com.sistem.sisvet.Entities;

public class FormaPagamento {
 
    private Long id;
    private String  tipoPagemento;
    
    public FormaPagamento(Long id, String tipoPagemento) {
        this.id = id;
        this.tipoPagemento = tipoPagemento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoPagemento() {
        return tipoPagemento;
    }

    public void setTipoPagemento(String tipoPagemento) {
        this.tipoPagemento = tipoPagemento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((tipoPagemento == null) ? 0 : tipoPagemento.hashCode());
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
        FormaPagamento other = (FormaPagamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (tipoPagemento == null) {
            if (other.tipoPagemento != null)
                return false;
        } else if (!tipoPagemento.equals(other.tipoPagemento))
            return false;
        return true;
    }

    
    


    

}

