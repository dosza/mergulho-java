package com.algaworks.banco.app;

import com.algaworks.banco.model.Conta;
import com.algaworks.banco.model.ContaEspecial;
import com.algaworks.banco.model.ContaInvestimento;
import com.algaworks.banco.model.Pessoa;

public class Principal {
    public static void main(String[] args) {
        Pessoa maria=new Pessoa();
        Pessoa joao = new Pessoa();
        joao.setNome( "Joao da Silva");
        joao.setDocumento ("00000");
        maria.setNome("Maria Aparecida");
        maria.setDocumento("11110");

        ContaInvestimento minhaConta = new ContaInvestimento(joao,1,1);

        minhaConta.depositar(15000);
        minhaConta.creditarRendimentos(0.8);
        ContaEspecial suaConta = new ContaEspecial(maria,1,2,1000);

        suaConta.depositar(15000.00);
        suaConta.sacar(15500.00);
        minhaConta.sacar(1000,0.5);

        System.out.println("titular " + minhaConta.getTitular().getNome()
                +" saldo " +minhaConta.getSaldo());

       // System.out.println("Titular " + suaConta.titular.nome);
        System.out.println("Saldo " + suaConta.getSaldo());

    }
}
