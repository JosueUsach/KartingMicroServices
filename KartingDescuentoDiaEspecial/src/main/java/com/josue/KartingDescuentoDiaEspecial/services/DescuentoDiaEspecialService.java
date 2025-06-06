package com.josue.KartingDescuentoDiaEspecial.services;

import com.josue.KartingDescuentoDiaEspecial.entities.DescuentoDiaEspecialEntity;
import com.josue.KartingDescuentoDiaEspecial.repositories.DescuentoDiaEspecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class DescuentoDiaEspecialService {
	@Autowired
	private DescuentoDiaEspecialRepository descuentoDiaEspecialRepository;

	private static final Set<String> holidays = new HashSet<>();

	static {
		holidays.add("01-01"); // Año nuevo
		holidays.add("12-25"); // Navidad
		holidays.add("09-18"); // Fiestas patrias
	}

	public DescuentoDiaEspecialEntity esDiaEspecial(LocalDate date) {
		DescuentoDiaEspecialEntity descuentoDiaEspecial = new DescuentoDiaEspecialEntity();

		DayOfWeek dayOfWeek = date.getDayOfWeek();
		String monthDay = String.format("%02d-%02d", date.getMonthValue(), date.getDayOfMonth());
		if  (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY || holidays.contains(monthDay)){
			descuentoDiaEspecial.setEsEspecial(true);
			descuentoDiaEspecial.setDescuento(0.1);
		}
		else{
			descuentoDiaEspecial.setEsEspecial(false);
			descuentoDiaEspecial.setDescuento(0.0);
		}
		return descuentoDiaEspecial;
	}

}
