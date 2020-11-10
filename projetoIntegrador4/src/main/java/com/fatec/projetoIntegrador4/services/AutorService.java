package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Autor;

public interface AutorService {
    
    List<Autor> findAll();

    Autor findById(Long id);

    Autor save(Autor autor);

    void delete(Long id);
}
