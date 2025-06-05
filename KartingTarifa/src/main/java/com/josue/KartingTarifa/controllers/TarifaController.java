package com.josue.KartingTarifa.controllers;

import com.josue.KartingTarifa.entities.TarifaEntity;
import com.josue.KartingTarifa.services.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarifa")
@CrossOrigin(origins = "*")
public class TarifaController {
	@Autowired
	TarifaService tarifaService;

	@GetMapping()
	public ResponseEntity<List<TarifaEntity>> getAllTarifas(){
		List<TarifaEntity> tarifas = tarifaService.getAllTarifas();
		return ResponseEntity.ok(tarifas);
	}
}
