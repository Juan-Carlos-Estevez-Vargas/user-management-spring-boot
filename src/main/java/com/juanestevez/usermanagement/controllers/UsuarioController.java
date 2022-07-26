package com.juanestevez.usermanagement.controllers;

import com.juanestevez.usermanagement.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @GetMapping("/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Juan");
        usuario.setApellido("Estevez");
        usuario.setEmail("juan@example.com");
        usuario.setTelefono("3213213213");
        return usuario;
    }

    @GetMapping("/usuario1")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Estevez");
        usuario.setEmail("juan@example.com");
        usuario.setTelefono("3213213213");
        return usuario;
    }

    @GetMapping("/usuario2")
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Estevez");
        usuario.setEmail("juan@example.com");
        usuario.setTelefono("3213213213");
        return usuario;
    }

    @GetMapping("/usuario3")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Estevez");
        usuario.setEmail("juan@example.com");
        usuario.setTelefono("3213213213");
        return usuario;
    }
}
