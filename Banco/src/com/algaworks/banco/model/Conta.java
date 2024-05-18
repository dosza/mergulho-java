package com.algaworks.banco.model;

import java.util.Objects;

 public class Conta {
    private int agencia;
    private int numero;
    private double saldo;
    private Pessoa titular;
    //construtor

     Conta() {
    }
    public Conta(Pessoa titular,int agencia, int numero){
        Objects.requireNonNull(titular);
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }
    public void depositar(double valor){
        if ( valor <= 0){
            throw  new IllegalArgumentException("Valor deve ser maior que 0");
        }
        this.saldo += valor;
    }
    public void sacar(double valor){
        if ( valor <= 0){
            throw  new IllegalArgumentException("Valor deve ser maior que 0");
        }
        if ((getSaldoDisponivel() -valor) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }

        if ( valor <= 0){
            throw  new IllegalArgumentException("Valor deve ser maior que 0");
        }
            this.saldo-=valor;
    }

    public void sacar(double valor, double taxaSaque){
        sacar(valor + taxaSaque);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public double getSaldoDisponivel(){
         return getSaldo();
    }
}
