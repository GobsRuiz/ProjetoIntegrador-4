package com.fatec.projetoIntegrador4.repositorys;

import com.fatec.projetoIntegrador4.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
    
}
