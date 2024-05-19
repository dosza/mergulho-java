package com.algaworks.banco.model.pagamento;

import com.algaworks.banco.model.Pessoa;

import java.math.BigDecimal;

public class Boleto  implements  DocumentoPagavel,DocumentoEstornavel {

    private Pessoa beneficiario;
    private BigDecimal valor;
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
    public BigDecimal getValorTotal() {
        return valor;
    }

    public Boleto(Pessoa beneficiario, BigDecimal valor) {
        this.beneficiario = beneficiario;
        this.valor = valor;
    }

    @Override
    public void estornarDocumento() {
        pago = false;
    }
}
