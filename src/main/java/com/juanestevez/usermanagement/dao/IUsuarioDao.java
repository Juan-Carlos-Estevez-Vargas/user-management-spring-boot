package com.juanestevez.usermanagement.dao;

import com.juanestevez.usermanagement.models.Usuario;

import java.util.List;

public interface IUsuarioDao {

    List<Usuario> getUsuarios();
    void eliminar(Long id);
    void registrar(Usuario usuario);
}
