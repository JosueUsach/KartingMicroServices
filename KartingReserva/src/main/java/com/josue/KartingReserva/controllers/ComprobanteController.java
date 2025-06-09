package com.josue.KartingReserva.controllers;

import com.josue.KartingReserva.entities.ComprobanteEntity;
import com.josue.KartingReserva.repositories.ComprobanteRepository;
import com.josue.KartingReserva.services.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comprobante")
public class ComprobanteController {
    @Autowired
    private ComprobanteService comprobanteService;

    @GetMapping("/")
    public ResponseEntity<List<ComprobanteEntity>> getAllComprobantes(){
        List<ComprobanteEntity> comprobantes = comprobanteService.findAll();
        return ResponseEntity.ok(comprobantes);
    }

    @PostMapping("/")
    public ResponseEntity<ComprobanteEntity> registerComprobante(@RequestBody ComprobanteEntity comprobante){
        ComprobanteEntity comprobanteGuardado = comprobanteService.crearComprobante(comprobante);
        return ResponseEntity.ok(comprobanteGuardado);
    }

    @GetMapping("/buscar")
    public ResponseEntity<ComprobanteEntity> findComprobanteByRutAndReserva(
            @RequestParam String rutCliente,
            @RequestParam Long idReserva) {
        ComprobanteEntity comprobante = comprobanteService.findByRutClienteAndIdReserva(rutCliente, idReserva);
        if (comprobante != null) {
            return ResponseEntity.ok(comprobante);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/reporteVueltas")
    public ResponseEntity<List<Object[]>> getReservationSummaryReport(){
        List<Object[]> resultado = comprobanteService.getReservationSummaryReport();
        return ResponseEntity.ok(resultado);
    }
    
    @GetMapping("/reporteGrupo")
    public ResponseEntity<List<Object[]>> getReservationGroupReport(){
        List<Object[]> resultado = comprobanteService.getRiderGroupSizeReport();
        return ResponseEntity.ok(resultado);
    }
}