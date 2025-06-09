package com.josue.KartingReserva.services;

import com.josue.KartingReserva.entities.ClienteEntity;
import com.josue.KartingReserva.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	// Input: Un objeto cliente
	// Description: Guarda al cliente en la DB
	// Output: Un cliente registrado
	public ClienteEntity registerCliente(ClienteEntity clienteNuevo) {
		if ((clienteRepository.existsByMailCliente(clienteNuevo.getMailCliente())) || (clienteRepository.existsByRutCliente(clienteNuevo.getRutCliente()))) {
			System.out.printf("Cliente %s already exists\n", clienteNuevo.getRutCliente());
			return null;
		}
		else
			return clienteRepository.save(clienteNuevo);
	}

	// Input: Un objeto cliente
	// Description: Modifica los parametros deseados del cliente
	// Output: Un cliente modificado
	public ClienteEntity updateCliente(ClienteEntity clienteNuevo) {
		if (clienteRepository.existsById(clienteNuevo.getId())) {
			return clienteRepository.save(clienteNuevo);
		}
		else {
			System.out.printf("Cliente %s not found\n", clienteNuevo.getRutCliente());
			return null;
		}
	}

	// Description: Encuentra a todos los clientes guardados y los deja en un array
	// Output: Un array de clientes
	public List<ClienteEntity> getAllClients() {
		return clienteRepository.findAll();
	}

	// Input: La ID de un cliente
	// Description: Busca al cliente con esa ID, si lo encuentra, lo elimina
	public void borrarCliente(Long id){
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
		}
		else {
			System.out.println("Error al borrar cliente");
		}
	}
}
