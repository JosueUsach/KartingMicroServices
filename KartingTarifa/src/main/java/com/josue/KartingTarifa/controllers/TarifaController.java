package com.josue.KartingTarifa.controllers;

import com.josue.KartingTarifa.services.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tarifa")
public class TarifaController {
	@Autowired
	TarifaService tarifaService;

	@GetMapping("/{tipo}")
	public ResponseEntity<Double> getTarifaByTipo(@PathVariable int tipo){
		double tarifa = tarifaService.getTarifaByTipo(tipo);
		return ResponseEntity.ok(tarifa);
	}
}
