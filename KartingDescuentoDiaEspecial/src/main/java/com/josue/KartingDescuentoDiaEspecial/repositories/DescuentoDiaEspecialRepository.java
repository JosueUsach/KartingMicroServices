package com.josue.KartingDescuentoDiaEspecial.repositories;

import com.josue.KartingDescuentoDiaEspecial.entities.DescuentoDiaEspecialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoDiaEspecialRepository extends JpaRepository<DescuentoDiaEspecialEntity, Long> {
}
