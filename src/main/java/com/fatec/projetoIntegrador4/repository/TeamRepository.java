package com.fatec.projetoIntegrador4.repository;

import com.fatec.projetoIntegrador4.models.Team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long>{
    
}
