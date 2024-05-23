package com.algaworks.rh.rhapi.controller;


import com.algaworks.rh.rhapi.model.Funcionario;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @GetMapping
    public String testar(){
        return "java";
    }

    @PostMapping
    public Funcionario cadastrar(@RequestBody Funcionario funcionario){
        System.out.println(funcionario.toString());
        return  funcionario;
    }
}
