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

    
    


    

}

