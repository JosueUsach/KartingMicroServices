package com.josue.KartingReserva.repositories;

import com.josue.KartingReserva.entities.ComprobanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComprobanteRepository extends JpaRepository<ComprobanteEntity, Long> {

	public ComprobanteEntity findByRutClienteAndIdReserva(String rutCliente, Long idReserva);

	@Query(value = "SELECT " +
			"CASE " +
			"   WHEN costo_inicial = 15000 THEN '10 vueltas o máx 10 min' " +
			"   WHEN costo_inicial = 20000 THEN '15 vueltas o máx 15 min' " +
			"   WHEN costo_inicial = 25000 THEN '20 vueltas o máx 20 min' " +
			"END AS reservationType, " +
			"COUNT(*) AS reservationCount, " +
			"SUM(costo_inicial) AS initialSum, " +
			"SUM(descuento_cumple) AS birthdayDiscountSum, " +
			"SUM(descuento_frecuencia) AS frequentClientDiscountSum, " +
			"SUM(descuento_dia_especial) AS holidayDiscountSum, " +
			"SUM(costo_final) AS totalSum " +
			"FROM comprobante_entity " +
			"GROUP BY costo_inicial " +
			"UNION ALL " +
			"SELECT " +
			"'TOTAL' AS reservationType, " +
			"COUNT(*) AS reservationCount, " +
			"SUM(costo_inicial) AS initialSum, " +
			"SUM(descuento_cumple) AS birthdayDiscountSum, " +
			"SUM(descuento_frecuencia) AS frequentClientDiscountSum, " +
			"SUM(descuento_dia_especial) AS holidayDiscountSum, " +
			"SUM(costo_final) AS totalSum " +
			"FROM comprobante_entity", nativeQuery = true)
	List<Object[]> getReservationSummaryReport();


	@Query(value = "SELECT " +
			"CASE " +
			"   WHEN descuento_grupo = 0 THEN '1 - 2 participantes' " +
			"   WHEN descuento_grupo IN (-1500, -2000, -2500) THEN '3 - 5 participantes' " +
			"   WHEN descuento_grupo IN (-3000, -4000, -5000) THEN '6 - 10 participantes' " +
			"   WHEN descuento_grupo IN (-4500, -6000, -7500) THEN '11 - 15 participantes' " +
			"   ELSE 'Other group size' " +
			"END AS riderSegment, " +
			"COUNT(*) AS reservationCount, " +
			"SUM(costo_inicial) AS initialSum, " +
			"SUM(descuento_cumple) AS birthdayDiscountSum, " +
			"SUM(descuento_frecuencia) AS frequentClientDiscountSum, " +
			"SUM(descuento_dia_especial) AS holidayDiscountSum, " +
			"SUM(descuento_grupo) AS groupDiscountSum, " +
			"SUM(costo_final) AS totalSum " +
			"FROM comprobante_entity " +
			"GROUP BY riderSegment " +
			"UNION ALL " +
			"SELECT " +
			"'TOTAL' AS riderSegment, " +
			"COUNT(*) AS reservationCount, " +
			"SUM(costo_inicial) AS initialSum, " +
			"SUM(descuento_cumple) AS birthdayDiscountSum, " +
			"SUM(descuento_frecuencia) AS frequentClientDiscountSum, " +
			"SUM(descuento_dia_especial) AS holidayDiscountSum, " +
			"SUM(descuento_grupo) AS groupDiscountSum, " +
			"SUM(costo_final) AS totalSum " +
			"FROM comprobante_entity", nativeQuery = true)
	List<Object[]> getRiderGroupSizeReport();

}
