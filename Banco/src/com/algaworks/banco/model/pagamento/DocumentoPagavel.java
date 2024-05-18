package com.algaworks.banco.model.pagamento;

public interface DocumentoPagavel {
    double getValorTotal();
    boolean estáPago();
    void  quitarPagamento();

}
