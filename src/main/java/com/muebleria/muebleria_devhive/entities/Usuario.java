package com.muebleria.muebleria_devhive.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Usuario")
public class Usuario extends Persona{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idusuario")
    private int idusuario;
    
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "contrasenia")
    private String contrasenia;
}
