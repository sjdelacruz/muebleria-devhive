package com.muebleria.muebleria_devhive.services;

import java.util.List;

import com.muebleria.muebleria_devhive.models.MuebleDTO;
import com.muebleria.muebleria_devhive.models.MuebleLigero;

public interface MuebleService {

	List<MuebleLigero> getMuebles();
	
	MuebleLigero getMueble(Integer id);
	
	MuebleDTO postMueble(MuebleDTO mueble);
	
	MuebleDTO putMueble(Integer id, MuebleDTO mueble);
	
	void deleteMueble(Integer id);
	
	void deleteMueble2(Integer id);
}
