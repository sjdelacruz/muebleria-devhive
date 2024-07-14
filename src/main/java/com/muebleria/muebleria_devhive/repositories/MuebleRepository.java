package com.muebleria.muebleria_devhive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.muebleria.muebleria_devhive.entities.Mueble;

@Repository
public interface MuebleRepository extends JpaRepository<Mueble, Integer>{
	
	@Procedure(value = "eliminarMueble")
	public void eliminarMueble(@Param("id") Integer id);
	
	

}
