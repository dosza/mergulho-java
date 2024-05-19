package com.algaworks.banco.model;

import com.algaworks.banco.model.excecao.SaldoInsuficienteException;

import java.math.BigDecimal;
import java.util.Objects;

 public  abstract class Conta {
    private int agencia;
    private int numero;
    private BigDecimal saldo = new BigDecimal("0");
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
    public void depositar(BigDecimal valor){
        if ( valor.compareTo(BigDecimal.ZERO) <= 0){
            throw  new IllegalArgumentException("Valor deve ser maior que 0");
        }
        this.saldo = saldo.add(valor);
    }
    public abstract void debitarTarifaMensal();
    public void sacar (BigDecimal valor){
        if ( valor.compareTo(BigDecimal.ZERO) <= 0){
            throw  new IllegalArgumentException("Valor deve ser maior que 0");
        }
        if ((getSaldoDisponivel().subtract(valor)).compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        if ( valor.compareTo(BigDecimal.ZERO) <= 0){
            throw  new IllegalArgumentException("Valor deve ser maior que 0");
        }
            this.saldo = saldo.subtract(valor);
    }

    public void sacar(BigDecimal valor, BigDecimal taxaSaque){
        sacar(saldo.add(taxaSaque));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public BigDecimal getSaldoDisponivel(){
         return getSaldo();
    }


}
