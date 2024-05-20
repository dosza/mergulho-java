package com.algaworks.banco.app;

import com.algaworks.banco.model.Banco;
import com.algaworks.banco.model.Conta;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.stream.Stream;

public class Principal4 {
    public static void main(String[] args) {
        Banco banco = new Banco();
        BigDecimal saldoTotal = banco.getContas().stream()
                .map(Conta::getSaldo)
                .reduce(BigDecimal.ZERO,  BigDecimal::add);

        System.out.println(saldoTotal);

    }
}
