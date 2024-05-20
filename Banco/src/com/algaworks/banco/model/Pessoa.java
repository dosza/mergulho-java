package com.algaworks.banco.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pessoa {
    private String nome;
    private String documento;
    private BigDecimal rendmentoAnual;
    private TipoPessoa tipo = TipoPessoa.FISICA;

    public Pessoa(){

    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ( obj == null) return false;
        if  (this.getClass() != obj.getClass()) return false;

        Pessoa pessoa = (Pessoa) obj;
        return this.documento.equals(pessoa.documento);

    }

    public Pessoa(String nome, String documento){
        this.nome = nome;
        this.documento = documento;
    }
    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    private LocalDateTime dataUltimaAtualizacao= LocalDateTime.now();
    public BigDecimal getRendmentoAnual() {
        return rendmentoAnual;
    }

    public void setRendmentoAnual(BigDecimal rendmentoAnual) {
        this.rendmentoAnual = rendmentoAnual;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
