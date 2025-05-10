package com.tiendatenco.tienda.controladores;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendatenco.tienda.data.UsuarioData;
import com.tiendatenco.tienda.modelos.Usuario;

@RestController
public class UsuarioControlador
{
    @Autowired
    private UsuarioData userData;

    @RequestMapping("usuarios")
    public List<Usuario> getUsuarios()
    {
        return userData.getUsuarios(); 
    }

    
    @DeleteMapping("usuarios/{id}")
    public void eliminarUsuarios(@PathVariable Long id)
    {
        userData.eliminarUsuario(id);
    }
}