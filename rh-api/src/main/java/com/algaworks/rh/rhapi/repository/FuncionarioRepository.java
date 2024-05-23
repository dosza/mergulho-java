package com.algaworks.rh.rhapi.repository;

import com.algaworks.rh.rhapi.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository  extends JpaRepository<Funcionario,Long> {

}
