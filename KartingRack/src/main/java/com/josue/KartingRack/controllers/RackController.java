package com.josue.KartingRack.controllers;

import com.josue.KartingRack.model.Reserva;
import com.josue.KartingRack.services.RackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rack")
public class RackController {
	@Autowired
	RackService rackService;

	@GetMapping("/")
	public List<Map<String, Object>> getRack() {
		List<Reserva> reservas = rackService.conseguirReservas();

		return reservas.stream().map(res -> {
			Map<String, Object> event = new HashMap<>();
			event.put("id", res.getId());
			event.put("title", "Reserva de " + res.getRutClientePrincipal());
			event.put("start", res.getTiempoInicio());
			event.put("end", res.getTiempoTermino());
			return event;
		}).collect(Collectors.toList());
	}

}
