package com.josue.KartingReporte.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ReporteService {
    @Autowired
    private RestTemplate restTemplate;

	// Description: Usa una consulta SQL en otro microservicio y coloca los datos en un formato listo para generar una tabla
	// Output: Datos mapeados para una tabla basada en vueltas
    public List<Map<String, Object>> generarReporteVueltas() {
        List<List<Object>> reporte = restTemplate.getForEntity("http://KartingReserva/api/comprobante/reporteVueltas", List.class).getBody();
        List<Map<String, Object>> reporteMap = new ArrayList<>();

        if (reporte != null) {
            for (List<Object> row : reporte) {
                Map<String, Object> rowMap = new LinkedHashMap<>();
                rowMap.put("Número de vueltas o tiempo máximo permitido", row.get(0));
                rowMap.put("Cantidad de reservas", row.get(1));
                rowMap.put("Suma inicial", row.get(2));
                rowMap.put("Descuento cumpleaños", row.get(3));
                rowMap.put("Descuento cliente frecuente", row.get(4));
                rowMap.put("Descuento festivo", row.get(5));
                rowMap.put("Total", row.get(6));
                reporteMap.add(rowMap);
            }
        }
        return reporteMap;
    }

	// Description: Usa una consulta SQL en otro microservicio y coloca los datos en un formato listo para generar una tabla
	// Output: Datos mapeados para una tabla basada en cantidad de clientes
	public List<Map<String, Object>> generateRiderGroupReport() {
		List<List<Object>> reporte = restTemplate.getForEntity("http://KartingReserva/api/comprobante/reporteGrupo", List.class).getBody();
		List<Map<String, Object>> reporteMap = new ArrayList<>();

		if (reporte != null) {
			for (List<Object> row : reporte) {
				Map<String, Object> rowMap = new LinkedHashMap<>();
				rowMap.put("Tamaño del grupo", row.get(0));
				rowMap.put("Cantidad de reservas", row.get(1));
				rowMap.put("Suma inicial", row.get(2));
				rowMap.put("Descuento cumpleaños", row.get(3));
				rowMap.put("Descuento cliente frecuente", row.get(4));
				rowMap.put("Descuento festivo", row.get(5));
				rowMap.put("Descuento por grupo", row.get(6));
				rowMap.put("Total", row.get(7));
				reporteMap.add(rowMap);
			}
		}
		return reporteMap;
	}
}