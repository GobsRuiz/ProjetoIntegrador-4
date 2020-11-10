package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Noticia;

import org.springframework.web.multipart.MultipartFile;

public interface NoticiaService {
    
    List<Noticia> findAll();

    Noticia findById(Long id);

    Noticia save(Noticia noticia);

    void delete(Long id);

    // Save image
    void saveImage(MultipartFile imageFile) throws Exception;
}
