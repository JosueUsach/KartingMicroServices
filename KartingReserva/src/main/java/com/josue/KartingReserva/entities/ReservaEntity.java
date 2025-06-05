package com.josue.KartingReserva.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class ReservaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int reservationType;	// 0. 10 laps or 10 min / 1. 15 laps or 15 min / 2. 20 laps or 20 min
	private int riderAmount;
	private String mainClientRut;

	private List<String> clientRuts;
}
