package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Artista;

public interface ArtistaService {
    
    List<Artista> findAll();

    Artista findById(Long id);

    Artista save(Artista artista);

    void delete(Long id);
}
