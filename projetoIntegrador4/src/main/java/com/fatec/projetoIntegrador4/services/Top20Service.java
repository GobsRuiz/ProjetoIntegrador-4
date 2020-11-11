package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Top20;

public interface Top20Service {
    
    List<Top20> findAll();

    Top20 findById(Long id);

    Top20 save(Top20 top20);

    void delete(Long id);
}
