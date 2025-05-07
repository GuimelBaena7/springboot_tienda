package com.tiendatenco.tienda.controladores;
import com.tiendatenco.tienda.modelos.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioControlador
{
    @RequestMapping("prueba")
    public Usuario getUsuario()
    {
        Usuario user = new Usuario();
        user.setNombre("Lionel");
        user.setApellido("Messi");
        user.setEmail("ronaldo@gmail.com");
        user.setTelefono("32452672892");
        return user;
    }
}

