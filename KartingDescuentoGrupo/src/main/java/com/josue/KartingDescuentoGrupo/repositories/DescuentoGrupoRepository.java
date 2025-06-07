package com.josue.KartingDescuentoGrupo.repositories;

import com.josue.KartingDescuentoGrupo.entities.DescuentoGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoGrupoRepository extends JpaRepository<DescuentoGrupoEntity, Long> {
}
