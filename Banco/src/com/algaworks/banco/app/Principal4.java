package com.algaworks.banco.app;

import com.algaworks.banco.model.Banco;
import com.algaworks.banco.model.Conta;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.stream.Stream;

public class Principal4 {
    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.getContas().stream()
                .filter(
                        conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
                .sorted(Comparator.comparingInt(Conta::getNumero))
                .filter(conta -> conta.getNumero() > 200)
                .forEach(conta -> {
                    System.out.println(
                            conta.getAgencia() + "/" + conta.getNumero()
                                    + " = " + conta.getSaldo());
                });
    }
}
