package com.muebleria.muebleria_devhive.controllers;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.muebleria.muebleria_devhive.models.MuebleDTO;
import com.muebleria.muebleria_devhive.models.MuebleLigero;
import com.muebleria.muebleria_devhive.services.MuebleService;

@RestController
@RequestMapping("inmuebles/")
public class MueblesController {
	Logger logger = LoggerFactory.getLogger(MueblesController.class);
	private final MuebleService muebleService;

	public MueblesController(MuebleService muebleService) {
		this.muebleService = muebleService;
	}

	@GetMapping
	public ResponseEntity<List<MuebleLigero>> getInmueble() {
		return ResponseEntity.ok(muebleService.getMuebles());
	}

	@GetMapping("/{id}")
	public ResponseEntity<MuebleDTO> getInmuebleById(@PathVariable Integer id) {
		return ResponseEntity.ok(muebleService.getMueble(id));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MuebleDTO> postMueble(@RequestBody MuebleDTO mueble) {
		mueble = muebleService.postMueble(mueble);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mueble.getId()).toUri();
		return ResponseEntity.created(uri).body(mueble);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MuebleDTO> updateMueble(@PathVariable Integer id, @RequestBody MuebleDTO mueble) {
				return ResponseEntity.ok(muebleService.putMueble(id,mueble));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMueble(@PathVariable Integer id){
		muebleService.deleteMueble(id);
		
		return ResponseEntity.ok("Data deleted");
	}
	
	@DeleteMapping("procedimiento/{id}")
	public ResponseEntity<String> deleteMueble2(@PathVariable Integer id){
		muebleService.deleteMueble2(id);
		
		return ResponseEntity.ok("Data deleted");
	}
	
}
