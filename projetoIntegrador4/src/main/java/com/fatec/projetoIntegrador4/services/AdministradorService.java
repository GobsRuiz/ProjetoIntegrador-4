package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Administrador;

public interface AdministradorService {
    
    List<Administrador> findAll();

    Administrador findById(Long id);

    Administrador save(Administrador administrador);

    void delete(Long id);
}
