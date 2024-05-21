package com.algaworks.banco.app;

import com.algaworks.banco.model.Banco;
import com.algaworks.banco.model.Conta;

import java.math.BigDecimal;
import java.util.Optional;

public class Principal5 {
    public static void main(String[] args) {
        Banco banco =new Banco();

        //Usa optional para retornar o saldo da conta ou Zero (se não for encontraada)
        BigDecimal  saldo = banco.buscar(123,222)
                .map(Conta::getSaldo)
                .orElse(BigDecimal.ZERO);

        System.out.println(saldo);
    }
}
