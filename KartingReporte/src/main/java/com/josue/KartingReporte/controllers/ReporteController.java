package com.josue.KartingReporte.controllers;

import com.josue.KartingReporte.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/reporte")
public class ReporteController {
	@Autowired
	private ReporteService reporteService;

	@GetMapping("/reporteVueltas")
	public ResponseEntity<List<Map<String, Object>>> getReporteVueltas() {
		List<Map<String, Object>> reporte = reporteService.generarReporteVueltas();
		return ResponseEntity.ok(reporte);
	}

	@GetMapping("/reporteGrupo")
	public ResponseEntity<List<Map<String, Object>>> getReporteGrupo() {
		List<Map<String, Object>> reporte = reporteService.generateRiderGroupReport();
		return ResponseEntity.ok(reporte);
	}

}
