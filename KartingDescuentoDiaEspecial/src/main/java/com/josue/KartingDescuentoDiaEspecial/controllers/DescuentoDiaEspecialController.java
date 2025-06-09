package com.josue.KartingDescuentoDiaEspecial.controllers;

import com.josue.KartingDescuentoDiaEspecial.services.DescuentoDiaEspecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/api/descuento-dia-especial")
public class DescuentoDiaEspecialController {
	@Autowired
	private DescuentoDiaEspecialService descuentoDiaEspecialService;

	@GetMapping("/{fecha}")
	public ResponseEntity<Double> getDiaEspecial(@PathVariable LocalDateTime fecha) {
		try {
			double descuento = descuentoDiaEspecialService.esDiaEspecial(fecha);
			return ResponseEntity.ok(descuento);
		} catch (DateTimeParseException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}