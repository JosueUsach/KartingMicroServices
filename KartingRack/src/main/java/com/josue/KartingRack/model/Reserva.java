package com.josue.KartingRack.model;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
	private Long id;

	private LocalDateTime tiempoInicio;
	private LocalDateTime tiempoTermino;
	private int tipoReserva;
	private int cantidadClientes;
	private String rutClientePrincipal;

	private List<String> rutClientes;
}
