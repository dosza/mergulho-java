package com.algaworks.banco.app;

import com.algaworks.banco.model.Banco;
import com.algaworks.banco.model.Conta;

import java.util.Optional;

public class Principal5 {
    public static void main(String[] args) {
        Banco banco =new Banco();

        //Obtem a conta em contrada ou lança exceção com Optional
        Conta contaEncontrada=banco.buscar(123,333)
                .orElseThrow( ()-> new RuntimeException( "Conta não encontrada"));

        System.out.println(contaEncontrada.getTitular());
    }
}
