package com.josue.KartingReserva.controllers;

import com.josue.KartingReserva.entities.ClienteEntity;
import com.josue.KartingReserva.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/")
	public ResponseEntity<List<ClienteEntity>> getAllClients() {
		List<ClienteEntity> clientes = clienteService.getAllClients();
		return ResponseEntity.ok(clientes);
	}

	@PostMapping("/")
	public ResponseEntity<ClienteEntity> registerCliente(@RequestBody ClienteEntity clienteNuevo) {
		ClienteEntity cliente = clienteService.registerCliente(clienteNuevo);
		return ResponseEntity.ok(cliente);
	}

	@PutMapping("/")
	public ResponseEntity<ClienteEntity> updateCliente(@RequestBody ClienteEntity clienteNuevo) {
		ClienteEntity cliente = clienteService.updateCliente(clienteNuevo);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	public void borrarCliente(@PathVariable Long id){
		clienteService.borrarCliente(id);
	}

}
