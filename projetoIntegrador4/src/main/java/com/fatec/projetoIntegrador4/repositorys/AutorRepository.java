package com.fatec.projetoIntegrador4.repositorys;

import com.fatec.projetoIntegrador4.models.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    
}
