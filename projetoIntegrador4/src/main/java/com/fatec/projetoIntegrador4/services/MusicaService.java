package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Musica;

public interface MusicaService {
    
    List<Musica> findAll();

    Musica findById(Long id);

    Musica save(Musica musica);

    void delete(Long id);
}
