package com.algaworks.banco.app;

import com.algaworks.banco.model.Banco;
import com.algaworks.banco.model.Conta;
import com.algaworks.banco.model.Pessoa;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Principal4 {
    public static void main(String[] args) {
        Banco banco = new Banco();
        //usa collection dentro de stream para obter uma lista  de pessoas
        List<Pessoa> pessas  = banco.getContas().stream()
                .map(Conta::getTitular)
                .distinct()
                .toList();

    }
}
