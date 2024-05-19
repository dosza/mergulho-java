package com.algaworks.banco.model.pagamento;

import java.math.BigDecimal;

public interface DocumentoPagavel {
    BigDecimal getValorTotal();
    boolean estáPago();
    void  quitarPagamento();

    default  void imprimirRecibo(){
        System.out.println("Recibo: ");
        System.out.println("Valor: " + getValorTotal());
        System.out.println("Pago: " + estáPago());
    }

}
