package com.josue.KartingReserva.controllers;

import com.josue.KartingReserva.entities.ReservaEntity;
import com.josue.KartingReserva.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin(origins = "*")
public class ReservaController {
	@Autowired
	private ReservaService reservaService;

	@GetMapping("/")
	public ResponseEntity<List<ReservaEntity>> getAllReservas(){
		List<ReservaEntity> reservas = reservaService.getAllReservas();
		return ResponseEntity.ok(reservas);
	}

	@PostMapping("/")
	public ResponseEntity<ReservaEntity> registerReserva(@RequestBody ReservaEntity reserva){
		ReservaEntity reservaGuardada = reservaService.registerReserva(reserva);
		return ResponseEntity.ok(reservaGuardada);
	}
}
