package com.josue.KartingTarifa.services;

import com.josue.KartingTarifa.entities.TarifaEntity;
import com.josue.KartingTarifa.repositories.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifaService {
	@Autowired
	private TarifaRepository tarifaRepository;

	// Description: Finds all tariffs and puts them in an array
	// Output: An array of tariffs
	public List<TarifaEntity> getAllTarifas(){
		return tarifaRepository.findAll();
	}
}
