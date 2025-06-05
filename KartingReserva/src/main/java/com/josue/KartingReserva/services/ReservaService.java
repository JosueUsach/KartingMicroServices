package com.josue.KartingReserva.services;

import com.josue.KartingReserva.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
	@Autowired
	private ReservaRepository reservaRepository;

	// Input: A reservation object
	// Description: Adds the inputted reservation to the DB and links all clients to it
	// Output: A saved reservation


}
