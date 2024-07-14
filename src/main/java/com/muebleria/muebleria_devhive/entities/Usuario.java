package com.muebleria.muebleria_devhive.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Usuario")
public class Usuario{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idusuario")
    private Integer idusuario;
    
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "contrasenia")
    private String contrasenia;
    
    @OneToOne
    private Persona persona;
}
