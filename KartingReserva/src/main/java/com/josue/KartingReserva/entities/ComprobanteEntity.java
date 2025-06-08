package com.josue.KartingReserva.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ComprobanteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	private String rutCliente;
	private String nombreCliente;
	private String mailCliente;

	private int visitasMensuales;
	private boolean checkCumple;

	private double costoInicial;
	private double descuentoGrupo;
	private double descuentoDiaEspecial;
	private double descuentoFrecuencia;
	private double descuentoCumple;
	private double costoFinal;

	private LocalDateTime fechaReserva;

	private Long idReserva;
}
