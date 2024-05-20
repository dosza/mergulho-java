package com.algaworks.banco.app;

import com.algaworks.banco.model.Banco;
import com.algaworks.banco.model.Conta;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class Principal4 {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Stream<Conta> stream = banco.getContas().stream();
        stream.forEach(conta->{
            conta.depositar(new BigDecimal("10"));
            System.out.println(
                    conta.getAgencia()+ "/"+conta.getNumero()
                    + " = " + conta.getSaldo()) ;
        });
    }
}
