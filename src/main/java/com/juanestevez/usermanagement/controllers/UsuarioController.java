package com.juanestevez.usermanagement.controllers;

import com.juanestevez.usermanagement.models.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(123L);
        usuario.setNombre("Juan");
        usuario.setApellido("Estevez");
        usuario.setEmail("juan@example.com");
        usuario.setTelefono("3213213213");

        Usuario usuario2 = new Usuario();
        usuario2.setId(456L);
        usuario2.setNombre("Juan1");
        usuario2.setApellido("Estevez1");
        usuario2.setEmail("juan@example.com1");
        usuario2.setTelefono("32132132131");

        Usuario usuario3 = new Usuario();
        usuario3.setId(789L);
        usuario3.setNombre("Juan2");
        usuario3.setApellido("Estevez2");
        usuario3.setEmail("juan@example.com2");
        usuario3.setTelefono("32132132132");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;
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
