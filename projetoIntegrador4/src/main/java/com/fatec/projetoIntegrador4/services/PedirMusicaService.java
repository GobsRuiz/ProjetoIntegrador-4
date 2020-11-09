package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.PedirMusica;

public interface PedirMusicaService {
    
    List<PedirMusica> findAll();

    PedirMusica findById(Long id);

    PedirMusica save(PedirMusica pedirMusica);

    void delete(Long id);
}
