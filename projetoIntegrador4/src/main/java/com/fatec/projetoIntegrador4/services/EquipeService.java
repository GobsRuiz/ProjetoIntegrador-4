package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Equipe;

import org.springframework.web.multipart.MultipartFile;

public interface EquipeService {
    
    List<Equipe> findAll();

    Equipe findById(Long id);

    Equipe save(Equipe equipe);

    void delete(Long id);

    // Save image
    void saveImage(MultipartFile imageFile) throws Exception;
}
