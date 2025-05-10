package com.tiendatenco.tienda.data;
import java.util.List;

import com.tiendatenco.tienda.modelos.Usuario;

public interface  UsuarioInterfaceData 
{

    List<Usuario> getUsuarios();
    void eliminarUsuario(Long id);
    void crearUsuario(Usuario user);

}
