package com.muebleria.muebleria_devhive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muebleria.muebleria_devhive.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
