package com.tiendatenco.tienda.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
public class Usuario
{
    @Id
    @Getter @Setter @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // o GenerationType.AUTO
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String apellido;
    
    @Getter @Setter @Column(name = "email")
    private String email;
    
    @Getter @Setter @Column(name = "telefono")
    private String telefono;

    @Getter @Setter @Column(name = "password")
    private String password;
}