package com.algaworks.rh.rhapi.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Funcionario {

    @Id
    private long id;
    private String nome;
    private String email;
    private BigDecimal salario;
    private LocalDateTime dataAdmissao;


}
