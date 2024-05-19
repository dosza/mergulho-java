package com.algaworks.banco.model.pagamento;

public interface DocumentoPagavel {
    double getValorTotal();
    boolean estáPago();
    void  quitarPagamento();

    default  void imprimirRecibo(){
        System.out.println("Recibo: ");
        System.out.println("Valor: " + getValorTotal());
        System.out.println("Pago: " + estáPago());
    }

}
