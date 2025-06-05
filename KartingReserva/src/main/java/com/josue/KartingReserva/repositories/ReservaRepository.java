package com.josue.KartingReserva.repositories;

import com.josue.KartingReserva.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository <ReservaEntity, Long>{
}
