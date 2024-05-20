package com.algaworks.banco.app;

import com.algaworks.banco.model.Banco;
import com.algaworks.banco.model.Conta;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public class Principal3 {
    public static void main(String[] args) {
        Banco banco = new Banco();
        //ToIntFunction as lambda function
        ToIntFunction<Conta> function = (Conta conta) -> {
          return conta.getNumero();
        };
        banco.getContas().sort(Comparator.comparingInt(function));
        for (Conta conta: banco.getContas()){
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }
    }
}
