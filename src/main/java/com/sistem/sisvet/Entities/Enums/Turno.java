package com.sistem.sisvet.Entities.Enums;

public enum Turno {
    COMERCIAL(1, "Comercial"),             // Definição do quarto valor do enum: COMERCIAL com código 4 e descrição "Comercial"
    PLANTAO(2, "Plantão"),                 // Definição do quinto valor do enum: PLANTAO com código 5 e descrição "Plantão"
    SABADO(3, "Sábado"),                   // Definição do sexto valor do enum: SABADO com código 6 e descrição "Sábado"
    PLANTAO_MEIA_NOITE(4, "Plantão Meia Noite"); // Definição do sétimo valor do enum: PLANTAO_MEIA_NOITE com código 7 e descrição "Plantão Meia Noite"

    private final int codigo;              // Declaração do campo para armazenar o código do turno
    private final String descricao;        // Declaração do campo para armazenar a descrição do turno

    // Construtor do enum que recebe um código e uma descrição e atribui aos campos correspondentes
    Turno(int codigo, String descricao) {
        this.codigo = codigo;               // Atribuição do código recebido ao campo código
        this.descricao = descricao;         // Atribuição da descrição recebida ao campo descrição
    }

    // Método público para obter o código do turno
    public int getCodigo() {
        return codigo;                      // Retorna o código do turno
    }

    // Método público para obter a descrição do turno
    public String getDescricao() {
        return descricao;                   // Retorna a descrição do turno
    }
}
