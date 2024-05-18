package com.algaworks.banco.app;

import com.algaworks.banco.model.*;
import com.algaworks.banco.model.atm.CaixaEletronico;

public class Principal {
    public static void main(String[] args) {
        Pessoa maria= new Pessoa();
        Pessoa joao = new Pessoa();
        joao.setNome( "Joao da Silva");
        joao.setDocumento ("00000");
        maria.setNome("Maria Aparecida");
        maria.setDocumento("11110");
        CaixaEletronico caixaEletronico = new CaixaEletronico();


        ContaInvestimento minhaConta = new ContaInvestimento(joao,1,1);
        minhaConta.depositar(15000);
        minhaConta.creditarRendimentos(0.8);
        ContaEspecial suaConta = new ContaEspecial(maria,1,2,1000);

        suaConta.depositar(15_000);
        suaConta.sacar(15_500);
        minhaConta.sacar(1_000,0.5);
        minhaConta.debitarTarifaMensal();
        suaConta.debitarTarifaMensal();
        caixaEletronico.imprimirSaldo(minhaConta);
        caixaEletronico.imprimirSaldo(suaConta);



    }
}
