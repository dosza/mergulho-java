package com.algaworks.banco.model;

public class Pessoa {
    private String nome;
    private String documento;
    private Double rendmentoAnual;
    private TipoPessoa tipo = TipoPessoa.FISICA;

    public Double getRendmentoAnual() {
        return rendmentoAnual;
    }

    public void setRendmentoAnual(Double rendmentoAnual) {
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
