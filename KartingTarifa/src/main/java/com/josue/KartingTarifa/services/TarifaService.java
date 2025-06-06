package com.josue.KartingTarifa.services;

import com.josue.KartingTarifa.entities.TarifaEntity;
import com.josue.KartingTarifa.repositories.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TarifaService {
	@Autowired
	private TarifaRepository tarifaRepository;

	// Input: Un entero indicando el tipo de reserva
	// Description: Devuelve detalles de la reserva segun el tipo
	// Output: Un objeto tarifa con el costo, la duracion o vueltas de la reserva y la duracion total de la reserva
	public TarifaEntity getTarifaByTipo(int tipo) {
		TarifaEntity tarifa = new TarifaEntity();

		switch (tipo) {
			case 0:
				tarifa.setCosto(10000.0);
				tarifa.setVueltas("10 vueltas, Maximo de 10 minutos");
				tarifa.setDuracionTotal(15.0); // 30 minutos
				break;
			case 1: // Tarifa Intermedia
				tarifa.setCosto(15000.0);
				tarifa.setVueltas("15 vueltas, Maximo de 15 minutos");
				tarifa.setDuracionTotal(25.0); // 35 minutos
				break;
			case 2: // Tarifa Premium
				tarifa.setCosto(20000.0);
				tarifa.setVueltas("20 vueltas, Maximo de 20 minutos");
				tarifa.setDuracionTotal(35.0); // 40 minutos
				break;
			default:
				throw new IllegalArgumentException("Tipo de tarifa inválido. Debe ser 0, 1 o 2.");
		}

		return tarifa;
	}
}