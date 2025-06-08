package com.josue.KartingReserva.repositories;

import com.josue.KartingReserva.entities.ComprobanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepository extends JpaRepository<ComprobanteEntity, Long> {
}
