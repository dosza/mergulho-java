package com.algaworks.banco.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(Pessoa titular, int agencia, int conta) {
        super(titular, agencia, conta);
    }

    public void creditarRendimentos(BigDecimal percentualJuros) {
        BigDecimal valorRedimento = getSaldo().add(percentualJuros
                        .divide(new BigDecimal("100"),2, RoundingMode.HALF_EVEN));
        depositar(valorRedimento);

    }

    @Override
    public void debitarTarifaMensal() {
        if (getSaldo().compareTo(new BigDecimal("10000")) < 0) {
            sacar(new BigDecimal("30"));
        }
    }
}
