package com.fatec.projetoIntegrador4.repositorys;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Noticia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, Long>{

}
