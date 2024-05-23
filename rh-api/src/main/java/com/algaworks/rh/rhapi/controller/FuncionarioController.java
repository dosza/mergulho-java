package com.algaworks.rh.rhapi.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    public String testar(){
        return "123 testando";
    }
}
