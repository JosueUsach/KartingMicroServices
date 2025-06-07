package com.josue.KartingDescuentoFrecuencia.services;

import com.josue.KartingDescuentoFrecuencia.entities.DescuentoFrecuenciaEntity;
import org.springframework.stereotype.Service;

@Service
public class DescuentoFrecuenciaService {

	public DescuentoFrecuenciaEntity calcularDescuentoFrecuencia(int frecuencia) {
		DescuentoFrecuenciaEntity descuentoFrecuencia = new DescuentoFrecuenciaEntity();
		descuentoFrecuencia.setFrecuencia(frecuencia);

		if (frecuencia >=2 && frecuencia <=4)
			descuentoFrecuencia.setDescuento(0.1); // 10% off
		else if (frecuencia >= 5 && frecuencia <=6)
			descuentoFrecuencia.setDescuento(0.2); // 20% off
		else if (frecuencia >= 7)
			descuentoFrecuencia.setDescuento(0.3); // 30% off
		else
			descuentoFrecuencia.setDescuento(0.0);
		return descuentoFrecuencia;
	}
}
