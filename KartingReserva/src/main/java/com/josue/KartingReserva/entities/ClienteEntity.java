package com.josue.KartingReserva.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	private String rutCliente;
	private String nombreCliente;
	private String mailCliente;
	private String telefonoCliente;
	private LocalDate fechaNacimiento;

}
