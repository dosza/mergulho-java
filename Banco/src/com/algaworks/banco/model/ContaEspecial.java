package com.algaworks.banco.model;

import java.math.BigDecimal;

public class ContaEspecial extends  Conta {
    private BigDecimal valorLimite;

    public ContaEspecial(Pessoa titular, int agencia, int numero, BigDecimal valorLimite) {
        super(titular, agencia, numero);
        this.valorLimite = valorLimite;
    }

    public BigDecimal getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(BigDecimal valorLimite) {
        this.valorLimite = valorLimite;
    }

    @Override
    public BigDecimal getSaldoDisponivel() {
        return super.getSaldoDisponivel().add(getValorLimite());
    }

    @Override
    public void debitarTarifaMensal() {
        sacar(new BigDecimal("20.0"));
    }
}
