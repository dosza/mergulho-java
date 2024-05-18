package com.algaworks.banco.model;

public class ContaInvestimento  extends  Conta{
    public ContaInvestimento(Pessoa titular, int agencia, int conta){
        super(titular,agencia,conta);
    }

    public void creditarRendimentos(double percentualJuros){
        double valorRedimento = getSaldo() + percentualJuros/100.00;
        depositar(valorRedimento);

    }

    @Override
    public void debitarTarifaMensal() {
        if  ( getSaldo() < 10_000){
            sacar(30);
        }
    }
}
