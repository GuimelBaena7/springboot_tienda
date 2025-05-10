package com.tiendatenco.tienda.data;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiendatenco.tienda.modelos.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class UsuarioData implements UsuarioInterfaceData
{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() 
    {
        String query = "FROM Usuario";  // Se pone el nombre de la clase Usuario que mapeamos

        return em.createQuery(query).getResultList();
        
    }

    @Override
    @Transactional
    public void eliminarUsuario(Long id) 
    {
        Usuario user = em.find(Usuario.class, id);
        em.remove(user);
    }

    @Override
    public void crearUsuario(Usuario user) {
    }
    
}
