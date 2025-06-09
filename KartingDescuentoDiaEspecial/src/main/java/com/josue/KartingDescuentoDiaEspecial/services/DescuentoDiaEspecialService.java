package com.josue.KartingDescuentoDiaEspecial.services;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class DescuentoDiaEspecialService {

	private static final Set<String> holidays = new HashSet<>();
	// Feriados de ejemplo
	static {
		holidays.add("01-01"); // Año nuevo
		holidays.add("12-25"); // Navidad
		holidays.add("09-18"); // Fiestas patrias
	}

	// Input: Una fecha
	// Description: Calcula el descuento que se aplica si el dia introducido es un fin de semana o un feriado
	// Output: El porcentaje de descuento para la reserva
	public Double esDiaEspecial(LocalDateTime date) {
		double descuentoDiaEspecial = 0.0;

		DayOfWeek dayOfWeek = date.getDayOfWeek();
		String monthDay = String.format("%02d-%02d", date.getMonthValue(), date.getDayOfMonth());
		if  (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY || holidays.contains(monthDay))
			descuentoDiaEspecial = 0.1;

		return descuentoDiaEspecial;
	}

}
