package com.algaworks.banco.model.excecao;

public class SaldoInsuficienteException  extends RuntimeException {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
