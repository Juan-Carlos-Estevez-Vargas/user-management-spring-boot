package com.juanestevez.usermanagement.controllers;

import com.juanestevez.usermanagement.dao.IUsuarioDao;
import com.juanestevez.usermanagement.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private IUsuarioDao usuarioDao;

    @PostMapping("/api/login")
    public String login(@RequestBody Usuario usuario){
       if (usuarioDao.verificarCredenciales(usuario)) {
           return "ok";
       } else {
           return "fail";
       }
    }

}
