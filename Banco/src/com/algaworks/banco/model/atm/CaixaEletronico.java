package com.algaworks.banco.model.atm;

import com.algaworks.banco.model.Conta;
import com.algaworks.banco.model.pagamento.DocumentoPagavel;

public class CaixaEletronico {
    public void imprimirSaldo(Conta conta){
        System.out.println( "Conta: "+ conta.getAgencia() + "/" +conta.getNumero());
        System.out.println("Titular: "+  conta.getTitular().getNome());
        System.out.println("Saldo: "+ conta.getSaldo());
        System.out.println("Saldo disponível: " + conta.getSaldoDisponivel());

    }
    public void pagar(DocumentoPagavel documento, Conta conta){

    }
}
