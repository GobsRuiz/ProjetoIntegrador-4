package com.fatec.projetoIntegrador4.repositorys;

import com.fatec.projetoIntegrador4.models.PedirMusica;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedirMusicaRepository extends JpaRepository<PedirMusica, Long>{
    
}
