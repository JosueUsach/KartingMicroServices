package com.josue.KartingDescuentoGrupo.services;

import com.josue.KartingDescuentoGrupo.entities.DescuentoGrupoEntity;
import org.springframework.stereotype.Service;

@Service
public class DescuentoGrupoService {

	public DescuentoGrupoEntity calcularDescuentoGrupo(int cantidadClientes){
		DescuentoGrupoEntity descuentoGrupo = new DescuentoGrupoEntity();
		descuentoGrupo.setCantidad(cantidadClientes);

		if (cantidadClientes >= 3 && cantidadClientes <= 5)
			descuentoGrupo.setDescuento(0.1); // 10% off
		else if (cantidadClientes >= 6 && cantidadClientes <= 10)
			descuentoGrupo.setDescuento(0.2); // 20% off
		else if (cantidadClientes >= 11)
			descuentoGrupo.setDescuento(0.3); // 30% off
		else
			descuentoGrupo.setDescuento(0.0);

		return descuentoGrupo;
	}
}
