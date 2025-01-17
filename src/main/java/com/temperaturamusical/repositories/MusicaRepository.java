package com.temperaturamusical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.temperaturamusical.repositories.entities.MusicaEntity;
import com.temperaturamusical.services.models.GeneroEnumType;
import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<MusicaEntity, Long> {
    public List<MusicaEntity> findByGenero(GeneroEnumType genero);
}
