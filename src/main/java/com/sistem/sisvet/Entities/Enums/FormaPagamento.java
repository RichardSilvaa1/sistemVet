package com.sistem.sisvet.Entities.Enums;

public enum FormaPagamento {
 
   PIX(1, "Pix"),
   PIX_VET(2,"Pix Vet"),
   NO_FARO(3, "NoFaro"),
   CARTAO(4,"Cartão"),
   CADERNO (5,"Caderno");
    
private final int codigo;
private final String descricao;

private FormaPagamento(int codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
}
public int getCodigo() {
    return codigo;
}
public String getDescricao() {
    return descricao;
}



    

}

