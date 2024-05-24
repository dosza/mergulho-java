package com.algaworks.rh.rhapi.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private BigDecimal salario;
    private LocalDate dataAdmissao;
    private StatusFuncionario status;

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", salario=" + salario +
                ", dataAdmissao=" + dataAdmissao +
                ", status=" + status +
                '}';
    }
}
