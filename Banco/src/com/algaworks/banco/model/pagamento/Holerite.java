package com.algaworks.banco.model.pagamento;

import com.algaworks.banco.model.Pessoa;

import java.math.BigDecimal;

public class Holerite  implements DocumentoPagavel {

    private boolean pago;
    private Pessoa funcionario;
    private int quantidadeHoras;
    private BigDecimal valorHora;


    public Holerite(Pessoa funcionaro, BigDecimal valorHora, int quantidadeHoras){
        this.funcionario = funcionaro;
        this.quantidadeHoras = quantidadeHoras;
        this.valorHora = valorHora;
    }
    @Override
    public BigDecimal getValorTotal() {
        BigDecimal valorTotal = new BigDecimal(quantidadeHoras).multiply(valorHora);
        return valorTotal;
    }

    @Override
    public boolean estáPago() {
        return pago;
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }
}
