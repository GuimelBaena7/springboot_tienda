package com.tiendatenco.tienda.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendatenco.tienda.data.UsuarioData;
import com.tiendatenco.tienda.modelos.Usuario;

@RestController
public class UsuarioControlador {

    @Autowired
    private UsuarioData userData;

    @RequestMapping("usuarios")
    public List<Usuario> getUsuarios() {
        return userData.getUsuarios(); 
    }

    @DeleteMapping("usuarios/{id}")
    public void eliminarUsuarios(@PathVariable Long id) {
        userData.eliminarUsuario(id);
    }

    @PostMapping("register")
    public void crearUsuario(@RequestBody Usuario usuario) {
        userData.crearUsuario(usuario);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        // Verifica que el correo electrónico y la contraseña no estén vacíos
        if (usuario.getEmail() == null || usuario.getPassword() == null) {
            return ResponseEntity.badRequest().body("Email and password must not be empty.");
        }

        // Busca el usuario en la base de datos
        Usuario foundUser  = userData.findByEmail(usuario.getEmail());

        // Verifica si el usuario existe
        if (foundUser  == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }

        // Verifica si la contraseña es correcta
        if (!foundUser .getPassword().equals(usuario.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }

        // Si las credenciales son correctas, devuelve una respuesta exitosa
        return ResponseEntity.ok().body("Login successful.");
    }

}
