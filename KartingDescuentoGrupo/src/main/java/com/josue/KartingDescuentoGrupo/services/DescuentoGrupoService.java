package com.josue.KartingDescuentoGrupo.services;

import org.springframework.stereotype.Service;

@Service
public class DescuentoGrupoService {

	// Input: Un entero indicando la cantidad de clientes en una reseva
	// Description: Calcula el descuento que se aplica por la cantidad de clientes
	// Output: El porcentaje de descuento para la reserva
	public Double calcularDescuentoGrupo(int cantidadClientes){
		double descuentoGrupo = 0.0;

		if (cantidadClientes >= 3 && cantidadClientes <= 5)
			descuentoGrupo = 0.1; // 10% off
		else if (cantidadClientes >= 6 && cantidadClientes <= 10)
			descuentoGrupo = 0.2; // 20% off
		else if (cantidadClientes >= 11)
			descuentoGrupo = 0.3; // 30% off

		return descuentoGrupo;
	}
}
