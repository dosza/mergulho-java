package com.algaworks.banco.app;

import com.algaworks.banco.model.Banco;
import com.algaworks.banco.model.Conta;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class Principal4 {
    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.getContas().stream()
                .filter(
                        conta -> conta.getSaldo().compareTo(new BigDecimal("130")) > 0)
                .filter(conta -> conta.getNumero() > 300)
                .forEach(conta -> {
                    System.out.println(
                            conta.getAgencia() + "/" + conta.getNumero()
                                    + " = " + conta.getSaldo());
                });
    }
}
