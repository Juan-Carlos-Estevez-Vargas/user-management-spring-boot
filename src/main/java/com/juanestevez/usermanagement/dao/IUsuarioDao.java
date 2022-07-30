package com.juanestevez.usermanagement.dao;

import com.juanestevez.usermanagement.models.Usuario;

import java.util.List;

public interface IUsuarioDao {

    /**
     * Lista los usuarios presentes en la base de datos.
     *
     * @return listado de usuarios encontrado.
     */
    List<Usuario> getUsuarios();

    /**
     * Elimina un usuario directamente de la base de datos.
     * Esta acción es irreversible.
     *
     * @param id por el cual se va a eliminar el usuario.
     */
    void eliminar(Long id);

    /**
     * Registra un nuevo usuario en el sistema (lo inserta en la base de datos.)
     *
     * @param usuario a registrar en el sistema.
     */
    void registrar(Usuario usuario);

    /**
     * Obtiene un usuario por las credenciales de acceso (id, email y contraseña).
     *
     * @param usuario a validar para obtener.
     * @return usuario encontrado.
     */
    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);

}
