package com.algaworks.banco.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pessoa {
    private String nome;
    private String documento;
    private BigDecimal rendmentoAnual;
    private TipoPessoa tipo = TipoPessoa.FISICA;

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
