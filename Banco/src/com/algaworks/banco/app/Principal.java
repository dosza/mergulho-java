package com.algaworks.banco.app;

import com.algaworks.banco.model.*;
import com.algaworks.banco.model.atm.CaixaEletronico;
import com.algaworks.banco.model.excecao.SaldoInsuficienteException;
import com.algaworks.banco.model.pagamento.Boleto;
import com.algaworks.banco.model.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Principal {
    public static void main(String[] args) {
        Pessoa titular = new Pessoa();
        Pessoa titular2 = new Pessoa();
        titular2.setNome("Joao da Silva");
        titular2.setDocumento("00000");

        titular.setRendmentoAnual(new BigDecimal("15000"));

        titular.setDataUltimaAtualizacao(LocalDateTime.parse("2023-06-27T13:20:00"));
        System.out.println(titular.getDataUltimaAtualizacao());
        CaixaEletronico caixaEletronico = new CaixaEletronico();


        ContaInvestimento minhaConta = new ContaInvestimento(titular2, 1, 1);
        ContaEspecial suaConta = new ContaEspecial(titular, 1, 2, new BigDecimal("1000"));
        try {
            minhaConta.depositar(new BigDecimal("30000"));
            // minhaConta.creditarRendimentos(0.8);


            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("15500"));
            minhaConta.sacar( new BigDecimal("1000"));
            // minhaConta.debitarTarifaMensal();
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, new BigDecimal("35000"));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);


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
