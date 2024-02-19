package com.sistem.sisvet.Entities;

public class Clinica {

    private Long id;
    private String nomeClinica;

    public Clinica(Long id, String nomeClinica) {
        this.id = id;
        this.nomeClinica = nomeClinica;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomeClinica() {
        return nomeClinica;
    }
    public void setNomeClinica(String nomeClinica) {
        this.nomeClinica = nomeClinica;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nomeClinica == null) ? 0 : nomeClinica.hashCode());
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
        Clinica other = (Clinica) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nomeClinica == null) {
            if (other.nomeClinica != null)
                return false;
        } else if (!nomeClinica.equals(other.nomeClinica))
            return false;
        return true;
    }
    
    

}