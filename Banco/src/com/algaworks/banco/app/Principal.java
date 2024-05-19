package com.algaworks.banco.app;

import com.algaworks.banco.model.*;
import com.algaworks.banco.model.atm.CaixaEletronico;
import com.algaworks.banco.model.pagamento.Boleto;
import com.algaworks.banco.model.pagamento.Holerite;

public class Principal {
    public static void main(String[] args) {
        Pessoa titular= new Pessoa();
        Pessoa titular2 = new Pessoa();
        titular2.setNome( "Joao da Silva");
        titular2.setDocumento ("00000");
        titular.setNome("Maria Aparecida");
        titular.setDocumento("11110");
        CaixaEletronico caixaEletronico = new CaixaEletronico();


        ContaInvestimento minhaConta = new ContaInvestimento(titular2,1,1);
        minhaConta.depositar(30000);
       // minhaConta.creditarRendimentos(0.8);
        ContaEspecial suaConta = new ContaEspecial(titular,1,2,1000);

        suaConta.depositar(15_000);
        suaConta.sacar(15_500);
        minhaConta.sacar(1_000);
       // minhaConta.debitarTarifaMensal();
        suaConta.debitarTarifaMensal();

        Boleto boletoEscola  = new Boleto(titular2,800);
        Holerite salarioFuncionario = new Holerite(titular2,100,160);


        caixaEletronico.pagar(boletoEscola,minhaConta);
        caixaEletronico.pagar(salarioFuncionario,minhaConta);
        caixaEletronico.estornarPagamento(boletoEscola,minhaConta);
        boletoEscola.imprimirRecibo();
        salarioFuncionario.imprimirRecibo();



        System.out.println();
        caixaEletronico.imprimirSaldo(minhaConta);
        caixaEletronico.imprimirSaldo(suaConta);



    }
}
