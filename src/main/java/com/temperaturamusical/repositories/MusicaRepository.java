package com.temperaturamusical.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.temperaturamusical.repositories.entities.MusicaEntity;
import com.temperaturamusical.services.models.GeneroEnumType;

@Component
public class MusicaRepository {

    public List<MusicaEntity> findByType(GeneroEnumType type) {

        
        throw new UnsupportedOperationException("Unimplemented method 'findByType'");
    }

}
