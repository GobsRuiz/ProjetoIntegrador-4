package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Contato;

public interface ContatoService {
    
    List<Contato> findAll();

    Contato findById(Long id);

    Contato save(Contato contato);

    void delete(Long id);
}
