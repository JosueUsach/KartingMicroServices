package com.josue.KartingReserva.services;

import com.josue.KartingReserva.entities.ClienteEntity;
import com.josue.KartingReserva.entities.ReservaEntity;
import com.josue.KartingReserva.repositories.ClienteRepository;
import com.josue.KartingReserva.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class ReservaService {
	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	// Input: Un objeto reserva
	// Description: Guarda la reserva a la DB
	// Output: Una reserva guardada
	public ReservaEntity registerReserva(ReservaEntity reserva) {
		for (String rut : reserva.getRutClientes()) {
			clienteRepository.findByRutCliente(rut)
					.orElseThrow(() -> new RuntimeException("Client with RUT " + rut + " not found"));
		}
		return reservaRepository.save(reserva);
	}

	// Input: Una ID
	// Description: Consigue la reserva con la ID introducida
	// Output: Una reserva
	public ReservaEntity getReservaById(Long id) {
		return reservaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Reserva with ID " + id + " not found"));
	}

	// Description: Encuentra a todas las reservas guardadas y las pone en un array
	// Output: Un array de reservas
	public ArrayList<ReservaEntity> getAllReservas() {
		return (ArrayList<ReservaEntity>) reservaRepository.findAll();
	}
}
