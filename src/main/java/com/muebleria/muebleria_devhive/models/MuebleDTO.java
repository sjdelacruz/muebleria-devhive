package com.muebleria.muebleria_devhive.models;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class MuebleDTO {

	private Integer id;
	private String nombre;
	private String direccion;
	private String antiguedad;
	private Integer habitaciones;
	private Boolean estufa;
	private Boolean estacionamiento;
	private Integer capacidad;

}
