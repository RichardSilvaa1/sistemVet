package com.sistem.sisvet.Exceptions;

// Definição da classe DataInvalidaException, que estende RuntimeException,
// indicando que é uma exceção de tempo de execução e não requer tratamento explícito.
public class DataInvalidaException extends RuntimeException {
    
    // Construtor da classe, que recebe uma mensagem como parâmetro.
    public DataInvalidaException(String message) {
        // Chama o construtor da superclasse RuntimeException com a mensagem fornecida.
        super(message);
    }
}
