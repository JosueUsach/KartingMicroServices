package com.josue.KartingDescuentoFrecuencia.services;

import org.springframework.stereotype.Service;

@Service
public class DescuentoFrecuenciaService {

	// Input: Un entero indicando la frecuencia con la que el cliente a visitado
	// Description: Calcula el descuento que se aplica por frecuencia
	// Output: El porcentaje de descuento para la reserva
	public Double calcularDescuentoFrecuencia(int frecuencia) {
		double descuentoFrecuencia = 0.0;

		if (frecuencia >=2 && frecuencia <=4)
			descuentoFrecuencia = 0.1; // 10% off
		else if (frecuencia >= 5 && frecuencia <=6)
			descuentoFrecuencia = 0.2; // 20% off
		else if (frecuencia >= 7)
			descuentoFrecuencia = 0.3; // 30% off

		return descuentoFrecuencia;
	}
}
