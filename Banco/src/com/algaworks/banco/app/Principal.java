package com.algaworks.banco.app;

import com.algaworks.banco.model.*;
import com.algaworks.banco.model.atm.CaixaEletronico;
import com.algaworks.banco.model.excecao.SaldoInsuficienteException;
import com.algaworks.banco.model.pagamento.Boleto;
import com.algaworks.banco.model.pagamento.Holerite;

public class Principal {
    public static void main(String[] args) {
        Pessoa titular = new Pessoa();
        Pessoa titular2 = new Pessoa();
        titular2.setNome("Joao da Silva");
        titular2.setDocumento("00000");

        titular.setRendmentoAnual(15_000d);
        titular.setDocumento("11110");
        CaixaEletronico caixaEletronico = new CaixaEletronico();


        ContaInvestimento minhaConta = new ContaInvestimento(titular2, 1, 1);
        ContaEspecial suaConta = new ContaEspecial(titular, 1, 2, 1000);
        try {
            minhaConta.depositar(30000);
            // minhaConta.creditarRendimentos(0.8);


            suaConta.depositar(15_000);
            suaConta.sacar(15_500);
            minhaConta.sacar(35_000);
            // minhaConta.debitarTarifaMensal();
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, 800);
            Holerite salarioFuncionario = new Holerite(titular2, 100, 160);


            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);
            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);
            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();
            System.out.println();

        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        }

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);


    }
}
