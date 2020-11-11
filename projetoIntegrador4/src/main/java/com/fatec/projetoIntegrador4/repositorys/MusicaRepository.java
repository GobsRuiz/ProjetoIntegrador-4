package com.fatec.projetoIntegrador4.repositorys;

import com.fatec.projetoIntegrador4.models.Musica;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Long>{
    
}
