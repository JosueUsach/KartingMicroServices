package com.josue.KartingReserva.services;

import com.josue.KartingReserva.entities.ClienteEntity;
import com.josue.KartingReserva.entities.ComprobanteEntity;
import com.josue.KartingReserva.entities.ReservaEntity;
import com.josue.KartingReserva.repositories.ClienteRepository;
import com.josue.KartingReserva.repositories.ComprobanteRepository;
import com.josue.KartingReserva.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class ComprobanteService {
	@Autowired
	private ComprobanteRepository comprobanteRepository;
	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	RestTemplate restTemplate;

	// Input: Un objeto de comprobante
	// Description: Calcula el costo final de la reserva para cada integrante de esta, aplicando descuentos y guarda el comprobante
	// Output: Un comprobante guardado en la DB
	public ComprobanteEntity crearComprobante(ComprobanteEntity comprobante) {
		ClienteEntity cliente = clienteRepository.findByRutCliente(comprobante.getRutCliente())
				.orElseThrow(() -> new RuntimeException("Client with RUT " + comprobante.getRutCliente() + " not found"));

		ReservaEntity reserva = reservaRepository.findById(comprobante.getIdReserva())
				.orElseThrow(() -> new RuntimeException("Reserva with ID " + comprobante.getIdReserva() + " not found"));

		// Costo inicial depende de el numero de vueltas / tiempo maximo
		Double costoInicial = restTemplate.getForEntity("http://KartingTarifa/api/tarifa/" + reserva.getTipoReserva(), Double.class).getBody();

		// Calculo descuento grupo
		Double descuentoGrupo = restTemplate.getForEntity("http://KartingDescuentoGrupo/api/descuento-grupo/"+ reserva.getCantidadClientes(), Double.class).getBody();

		// Calculo descuento frecuencia
		Double descuentoFrecuencia = restTemplate.getForEntity("http://KartingDescuentoFrecuencia/api/descuento-frecuencia/"+ comprobante.getVisitasMensuales(), Double.class).getBody();

		// Calculo decuento cumpleaños
		double descuentoCumple = 0.0;
		boolean isBirthday = (cliente.getFechaNacimiento().getDayOfMonth() == reserva.getTiempoInicio().getDayOfMonth()
				&& cliente.getFechaNacimiento().getMonthValue() == reserva.getTiempoInicio().getMonthValue());

		if (isBirthday)
			descuentoCumple = 0.5;

		// Calculo descuento dia especial
		Double descuentoDiaEspecial = restTemplate.getForEntity("http://KartingDescuentoDiaEspecial/api/descuento-dia-especial/"+ reserva.getTiempoInicio(), Double.class).getBody();

		// Calculo de cada descuento sobre el costo inicial
		if (costoInicial == null || descuentoGrupo == null || descuentoFrecuencia == null || descuentoDiaEspecial == null){
			throw new RuntimeException("Error al calcular el costo inicial");
		}
		else {
			descuentoGrupo = -(descuentoGrupo * costoInicial);
			descuentoFrecuencia = -(descuentoFrecuencia * costoInicial);
			descuentoCumple = -(descuentoCumple * costoInicial);
			descuentoDiaEspecial = -(descuentoDiaEspecial * costoInicial);

			double costoFinal = costoInicial + descuentoGrupo + descuentoFrecuencia + descuentoCumple + descuentoDiaEspecial;


			// Se guardan todos los datos del cliente y su comprobante
			comprobante.setNombreCliente(cliente.getNombreCliente());
			comprobante.setMailCliente(cliente.getMailCliente());
			comprobante.setCheckCumple(isBirthday);
			comprobante.setCostoInicial(costoInicial);
			comprobante.setDescuentoGrupo(descuentoGrupo);
			comprobante.setDescuentoFrecuencia(descuentoFrecuencia);
			comprobante.setDescuentoCumple(descuentoCumple);
			comprobante.setDescuentoDiaEspecial(descuentoDiaEspecial);
			comprobante.setCostoFinal(costoFinal);
			comprobante.setFechaReserva(reserva.getTiempoInicio());

			return comprobanteRepository.save(comprobante);
		}
	}

	public ComprobanteEntity findByRutClienteAndIdReserva(String rutCliente, Long idReserva) {
		ComprobanteEntity comprobante = comprobanteRepository.findByRutClienteAndIdReserva(rutCliente, idReserva);
		if (comprobante != null)
			return comprobante;
		return null;
	}

	public List<ComprobanteEntity> findAll(){
		return comprobanteRepository.findAll();
	}

	public List<Object[]> getReservationSummaryReport(){
		return comprobanteRepository.getReservationSummaryReport();
	}

	public List<Object[]> getRiderGroupSizeReport(){
		return comprobanteRepository.getRiderGroupSizeReport();
	}
}
