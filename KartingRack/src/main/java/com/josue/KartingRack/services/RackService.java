package com.josue.KartingRack.services;

import com.josue.KartingRack.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RackService {
	@Autowired
	RestTemplate restTemplate;

	// Description: Consigue las reservas guardadas y las pone en una lista
	// Output: Una lista de reservas
	public List<Reserva> conseguirReservas() {
		ResponseEntity<List<Reserva>> response = restTemplate.exchange(
				"http://KartingReserva/api/reserva/",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<>() {
				}
		);
		return response.getBody();
	}

}
