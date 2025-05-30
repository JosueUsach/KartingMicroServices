package com.josue.KartingTarifa.repositories;

import com.josue.KartingTarifa.entities.TarifaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<TarifaEntity, Long> {
}
