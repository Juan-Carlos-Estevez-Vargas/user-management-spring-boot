package com.juanestevez.usermanagement.controllers;

import com.juanestevez.usermanagement.dao.IUsuarioDao;
import com.juanestevez.usermanagement.models.Usuario;
import com.juanestevez.usermanagement.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de tipo REST, el cual se encarga de autenticar el inicio de sesión del usuario en cuestión.
 *
 * @author Juan Carlos Estevez Vargas.
 */
@RestController
public class AuthController {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * Realiza el logueo a la aplicación mediante la validación del token JWT.
     *
     * @param usuario con los datos del email y el password a verificar.
     * @return token JWT o "fail" en caso de fallar.
     */
    @PostMapping("/api/login")
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);

        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return tokenJwt;
        } else {
            return "fail";
        }

    }

}
