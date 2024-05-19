package com.algaworks.banco.model.pagamento;

import com.algaworks.banco.model.Pessoa;

public class Holerite  implements DocumentoPagavel {

    private boolean pago;
    private Pessoa funcionario;
    private int quantidadeHoras;
    private double valorHora;


    public Holerite(Pessoa funcionaro,  double valorHora, int quantidadeHoras){
        this.funcionario = funcionaro;
        this.quantidadeHoras = quantidadeHoras;
        this.valorHora = valorHora;
    }
    @Override
    public double getValorTotal() {
        return quantidadeHoras * valorHora;
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
