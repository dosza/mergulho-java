package com.algaworks.banco.model.pagamento;

public interface DocumentoEstornavel  extends DocumentoPagavel {
    void estornarDocumento();
}
