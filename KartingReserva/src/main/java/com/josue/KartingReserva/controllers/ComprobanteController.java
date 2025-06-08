package com.josue.KartingReserva.controllers;

import com.josue.KartingReserva.entities.ComprobanteEntity;
import com.josue.KartingReserva.repositories.ComprobanteRepository;
import com.josue.KartingReserva.services.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comprobante")
@CrossOrigin(origins = "*")
public class ComprobanteController {
	@Autowired
	private ComprobanteRepository comprobanteRepository;
	@Autowired
	private ComprobanteService comprobanteService;

	@GetMapping("/")
	public ResponseEntity<List<ComprobanteEntity>> getAllComprobantes(){
		List<ComprobanteEntity> comprobantes = comprobanteRepository.findAll();
		return ResponseEntity.ok(comprobantes);
	}

	@PostMapping("/")
	public ResponseEntity<ComprobanteEntity> registerComprobante(@RequestBody ComprobanteEntity comprobante){
		ComprobanteEntity comprobanteGuardado = comprobanteService.crearComprobante(comprobante);
		return ResponseEntity.ok(comprobanteGuardado);
	}
}
