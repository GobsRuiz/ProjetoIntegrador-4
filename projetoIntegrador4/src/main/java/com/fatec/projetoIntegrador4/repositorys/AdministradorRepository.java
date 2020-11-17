package com.fatec.projetoIntegrador4.repositorys;

import com.fatec.projetoIntegrador4.models.Administrador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
    
}
