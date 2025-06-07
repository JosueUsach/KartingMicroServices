package com.josue.KartingDescuentoGrupo.controllers;

import com.josue.KartingDescuentoGrupo.entities.DescuentoGrupoEntity;
import com.josue.KartingDescuentoGrupo.services.DescuentoGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/descuento-grupo")
@CrossOrigin(origins = "*")
public class DescuentoGrupoController {
	@Autowired
	private DescuentoGrupoService descuentoGrupoService;

	@GetMapping("/{cantidadClientes}")
	public ResponseEntity<Double> getDescuentoGrupo(@PathVariable int cantidadClientes) {
		DescuentoGrupoEntity descuento = descuentoGrupoService.calcularDescuentoGrupo(cantidadClientes);
		return ResponseEntity.ok(descuento.getDescuento());
	}
}
