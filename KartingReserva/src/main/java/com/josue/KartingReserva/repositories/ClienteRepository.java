package com.josue.KartingReserva.repositories;

import com.josue.KartingReserva.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	Optional<ClienteEntity> findByRutCliente(String rut); // Se usa al crear comprobantes

	boolean existsByMailCliente(String email);

	boolean existsByRutCliente(String rut);
}
