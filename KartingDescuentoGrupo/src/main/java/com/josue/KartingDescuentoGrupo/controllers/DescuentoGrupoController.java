package com.josue.KartingDescuentoGrupo.controllers;

import com.josue.KartingDescuentoGrupo.services.DescuentoGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/descuento-grupo")
public class DescuentoGrupoController {
	@Autowired
	private DescuentoGrupoService descuentoGrupoService;

	@GetMapping("/{cantidadClientes}")
	public ResponseEntity<Double> getDescuentoGrupo(@PathVariable int cantidadClientes) {
		double descuento = descuentoGrupoService.calcularDescuentoGrupo(cantidadClientes);
		return ResponseEntity.ok(descuento);
	}
}
