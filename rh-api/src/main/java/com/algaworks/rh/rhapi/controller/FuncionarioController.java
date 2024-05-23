package com.algaworks.rh.rhapi.controller;


import com.algaworks.rh.rhapi.model.Funcionario;
import com.algaworks.rh.rhapi.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario cadastrar(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
}
