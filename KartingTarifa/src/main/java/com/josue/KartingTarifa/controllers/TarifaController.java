package com.josue.KartingTarifa.controllers;

import com.josue.KartingTarifa.entities.TarifaEntity;
import com.josue.KartingTarifa.services.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tarifa")
@CrossOrigin(origins = "*")
public class TarifaController {
	@Autowired
	TarifaService tarifaService;

	@GetMapping("/{tipo}")
	public ResponseEntity<TarifaEntity> getTarifaByTipo(@PathVariable int tipo){
		TarifaEntity tarifa = tarifaService.getTarifaByTipo(tipo);
		return ResponseEntity.ok(tarifa);
	}
}
