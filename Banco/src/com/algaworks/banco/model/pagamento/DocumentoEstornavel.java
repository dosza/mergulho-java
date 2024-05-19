package com.algaworks.banco.model.pagamento;

public interface DocumentoEstornavel {
    boolean estáPago();
    double getValorTotal();
    void estornarDocumento();
}
