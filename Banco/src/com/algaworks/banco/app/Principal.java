package com.algaworks.banco.app;

import com.algaworks.banco.model.*;
import com.algaworks.banco.model.atm.CaixaEletronico;
import com.algaworks.banco.model.pagamento.Boleto;

public class Principal {
    public static void main(String[] args) {
        Pessoa maria= new Pessoa();
        Pessoa joao = new Pessoa();
        joao.setNome( "Joao da Silva");
        joao.setDocumento ("00000");
        maria.setNome("Maria Aparecida");
        maria.setDocumento("11110");
        CaixaEletronico caixaEletronico = new CaixaEletronico();


        ContaInvestimento minhaConta = new ContaInvestimento(joao,1,1);
        minhaConta.depositar(15000);
       // minhaConta.creditarRendimentos(0.8);
        ContaEspecial suaConta = new ContaEspecial(maria,1,2,1000);

        suaConta.depositar(15_000);
        suaConta.sacar(15_500);
        minhaConta.sacar(1_000);
       // minhaConta.debitarTarifaMensal();
        suaConta.debitarTarifaMensal();

        Boleto boletoEscola  = new Boleto(joao,800);
        System.out.println("Boleto pago: " + boletoEscola.estáPago());
        caixaEletronico.pagar(boletoEscola,minhaConta);
        System.out.println("Boleto pago: " + boletoEscola.estáPago());

        System.out.println();
        caixaEletronico.imprimirSaldo(minhaConta);
        caixaEletronico.imprimirSaldo(suaConta);



    }
}
