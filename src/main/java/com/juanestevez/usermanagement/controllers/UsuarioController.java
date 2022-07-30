package com.juanestevez.usermanagement.controllers;

import com.juanestevez.usermanagement.dao.IUsuarioDao;
import com.juanestevez.usermanagement.models.Usuario;
import com.juanestevez.usermanagement.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador del Entity Usuario, mediante el cuál se expone el API con los servicios.
 *
 * @author Juan Carlos Estevez Vargas.
 */
@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * valida el token JWT presente en la aplicación.
     *
     * @param token a validar.
     * @return que la llave ID esté presente el el token.
     */
    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    /**
     * Obtiene una lista con los usuarios registrados en el sistema, esto lo hace si y
     * solo si el token JWT es correcto.
     *
     * @param token a validar.
     * @return listado de usuarios encontrado.
     */
    @GetMapping("/api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {
        if (!validarToken(token)) {
            return null;
        }
        return usuarioDao.getUsuarios();
    }

    /**
     * Registra un nuevo usuario en el sistema y encripta la contraseña utilizando la
     * librería Argon2.
     *
     * @param usuario a registrar.
     */
    @PostMapping("/api/usuarios")
    public void registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

    /**
     * Elimina un usuario del sistema siempre y cuando exista un token JWT(sesión de usuario).
     *
     * @param token a validar la sesión.
     * @param id    por el cual se eliminará el usuario.
     */
    @DeleteMapping("/api/usuario/{id}")
    public void eliminar(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if (!validarToken(token)) {
            return;
        }
        usuarioDao.eliminar(id);
    }

}
