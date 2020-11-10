package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Programacao;

public interface ProgramacaoService {
    
    List<Programacao> findAll();

    Programacao findById(Long id);

    Programacao save(Programacao programacao);

    void delete(Long id);
}
