package com.josue.KartingDescuentoDiaEspecial.controllers;

import com.josue.KartingDescuentoDiaEspecial.services.DescuentoDiaEspecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/api/descuento-dia-especial")
@CrossOrigin(origins = "*")
public class DescuentoDiaEspecialController {
	@Autowired
	private DescuentoDiaEspecialService descuentoDiaEspecialService;

	@GetMapping("/{fecha}")
	public ResponseEntity<Double> getDiaEspecial(@PathVariable String fecha) {
		try {
			LocalDate date = LocalDate.parse(fecha); // Expects format: yyyy-MM-dd
			double descuento = descuentoDiaEspecialService.esDiaEspecial(date);
			return ResponseEntity.ok(descuento);
		} catch (DateTimeParseException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}