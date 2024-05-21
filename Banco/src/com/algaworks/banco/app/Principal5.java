package com.algaworks.banco.app;

import com.algaworks.banco.model.Banco;
import com.algaworks.banco.model.Conta;

import java.util.Optional;

public class Principal5 {
    public static void main(String[] args) {
        Banco banco =new Banco();
        //use optional com expressao lambda
        banco.buscar(123,333).ifPresent(Conta::getSaldo);
    }
}
