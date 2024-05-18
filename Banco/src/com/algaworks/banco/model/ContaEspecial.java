package com.algaworks.banco.model;

public class ContaEspecial extends  Conta {
    private double valorLimite;

    public ContaEspecial(Pessoa titular, int agencia, int numero, double valorLimite) {
        super(titular, agencia, numero);
        this.valorLimite = valorLimite;
    }
}
