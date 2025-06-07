package com.josue.KartingDescuentoFrecuencia.repositories;

import com.josue.KartingDescuentoFrecuencia.entities.DescuentoFrecuenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoFrecuenciaRepository extends JpaRepository<DescuentoFrecuenciaEntity, Long> {
}
