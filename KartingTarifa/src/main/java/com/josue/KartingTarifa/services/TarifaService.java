package com.josue.KartingTarifa.services;

import org.springframework.stereotype.Service;


@Service
public class TarifaService {

	// Input: Un entero indicando el tipo de reserva
	// Description: Devuelve detalles de la reserva segun el tipo
	// Output: El costo inicial de una reserva
	public Double getTarifaByTipo(int tipo) {
		double tarifa;

		if (tipo == 0)
			tarifa = 15000;
		else if (tipo == 1)
			tarifa = 20000;
		else if (tipo == 2)
			tarifa = 25000;
		else
			throw new IllegalArgumentException("Tipo de tarifa inválido. Debe ser 0, 1 o 2.");

		return tarifa;
	}
}