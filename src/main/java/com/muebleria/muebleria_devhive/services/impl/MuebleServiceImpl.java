package com.muebleria.muebleria_devhive.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.muebleria.muebleria_devhive.entities.Mueble;
import com.muebleria.muebleria_devhive.models.MuebleDTO;
import com.muebleria.muebleria_devhive.models.MuebleLigero;
import com.muebleria.muebleria_devhive.repositories.MuebleRepository;
import com.muebleria.muebleria_devhive.services.MuebleService;

@Service
public class MuebleServiceImpl implements MuebleService {

	private final MuebleRepository repository;
	private final ModelMapper mapper;

	public MuebleServiceImpl(MuebleRepository repository, ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<MuebleLigero> getMuebles() {
		List<Mueble> muebles = repository.findAll();
		return mapper.map(muebles, new TypeToken<List<MuebleLigero>>() {
		}.getType());
	}

	@Override
	public MuebleDTO getMueble(Integer id) {
		Mueble mueble = repository.findById(id).orElse(null);
		if (mueble == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found");
		else
			return mapper.map(mueble, MuebleDTO.class);
	}

	@Override
	public MuebleDTO postMueble(MuebleDTO mueble) {
		if (mueble != null) {
			Mueble mAux = mapper.map(mueble, Mueble.class);
			Mueble muebleNuevo = repository.save(mAux);

			return mapper.map(muebleNuevo, MuebleDTO.class);
		} else
			throw new ResponseStatusException(HttpStatus.CONFLICT, "No data");
	}

	@Override
	public MuebleDTO putMueble(Integer id, MuebleDTO mueble) {
		Mueble muebleObsoleto = repository.findById(id).orElse(null);
		if (muebleObsoleto == null)
			throw new ResponseStatusException(HttpStatus.CONFLICT, "No data");
		else
		{
			Mueble nuevo = mapper.map(mueble, Mueble.class);
			nuevo.setId(id);
			Mueble nuevoGuardado = repository.save(nuevo);
			return mapper.map(nuevoGuardado, MuebleDTO.class);
		}
	}

	@Override
	public void deleteMueble(Integer id) {
		repository.deleteById(id);
	}
	
	@Override
	public void deleteMueble2(Integer id) {
		repository.eliminarMueble(id);
	}

}
