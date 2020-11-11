package com.fatec.projetoIntegrador4.repositorys;

import com.fatec.projetoIntegrador4.models.Artista;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long>{
    
}
