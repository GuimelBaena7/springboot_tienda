package com.tiendatenco.tienda.data;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiendatenco.tienda.modelos.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class UsuarioData implements UsuarioInterfaceData {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";  
        return em.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public void eliminarUsuario(Long id) {
        Usuario user = em.find(Usuario.class, id);
        em.remove(user);
    }

    @Override
    @Transactional
    public void crearUsuario(Usuario user) {
        em.persist(user); // Save the new user to the database
    }

    @Override
    @Transactional
    public Usuario findByEmail(String email) {
        String query = "FROM Usuario WHERE email = :email";
        try {
            return em.createQuery(query, Usuario.class)
                    .setParameter("email", email)
                    .getSingleResult(); // Cambiado a getSingleResult()
        } catch (NoResultException e) {
            return null; // Retorna null si no se encuentra el usuario
        }
    }
}
