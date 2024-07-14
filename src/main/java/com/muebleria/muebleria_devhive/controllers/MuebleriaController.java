package com.muebleria.muebleria_devhive.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/muebleria_devhive")
public class MuebleriaController {
	
	public MuebleriaController() {
		
	}
	
	@GetMapping("/inmuebles/{id}")
	public ResponseEntity<String> getInmueble(@PathVariable Integer id) {

		return ResponseEntity.ok("");
	}
}
