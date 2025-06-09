package com.josue.KartingRack.entities;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RackEntity {
	private Long id;
	private String title;
	private LocalDateTime start;
	private LocalDateTime end;
}
