package com.josue.KartingDescuentoFrecuencia.controllers;

import com.josue.KartingDescuentoFrecuencia.services.DescuentoFrecuenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/descuento-frecuencia")
@CrossOrigin(origins = "*")
public class DescuentoFrecuenciaController {
	@Autowired
	private DescuentoFrecuenciaService descuentoFrecuenciaService;

	@GetMapping("/{frecuencia}")
	public ResponseEntity<Double> getDescuentoFrecuencia(@PathVariable int frecuencia){
		double descuento = descuentoFrecuenciaService.calcularDescuentoFrecuencia(frecuencia);
		return ResponseEntity.ok(descuento);
	}
}
