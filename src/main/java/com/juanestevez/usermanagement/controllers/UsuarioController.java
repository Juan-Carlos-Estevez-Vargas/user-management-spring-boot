package com.juanestevez.usermanagement.controllers;

import com.juanestevez.usermanagement.dao.IUsuarioDao;
import com.juanestevez.usermanagement.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioDao usuarioDao;

    @GetMapping("/api/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Juan");
        usuario.setApellido("Estevez");
        usuario.setEmail("juan@example.com");
        usuario.setTelefono("3213213213");
        return usuario;
    }

    @GetMapping("/api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Estevez");
        usuario.setEmail("juan@example.com");
        usuario.setTelefono("3213213213");
        return usuario;
    }

    @DeleteMapping("/api/usuario/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
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
