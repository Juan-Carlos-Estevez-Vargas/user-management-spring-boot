package com.juanestevez.usermanagement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @GetMapping("/prueba")
    public List<String> prueba(){
        return List.of("Manzaba", "kIWI");
    }
}
