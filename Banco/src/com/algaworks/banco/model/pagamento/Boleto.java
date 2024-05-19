package com.algaworks.banco.model.pagamento;

import com.algaworks.banco.model.Pessoa;

public class Boleto  implements  DocumentoPagavel {

    private Pessoa beneficiario;
    private double valor;
    private boolean pago;
    @Override
    public boolean estáPago() {
        return pago;
    }

    @Override
    public void quitarPagamento() {
        pago = true;
    }

    @Override
    public double getValorTotal() {
        return valor;
    }

    public Boleto(Pessoa beneficiario, double valor) {
        this.beneficiario = beneficiario;
        this.valor = valor;
    }
}
