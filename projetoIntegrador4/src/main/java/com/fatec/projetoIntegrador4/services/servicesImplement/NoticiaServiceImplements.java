package com.fatec.projetoIntegrador4.services.servicesImplement;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.fatec.projetoIntegrador4.models.Noticia;
import com.fatec.projetoIntegrador4.repositorys.NoticiaRepository;
import com.fatec.projetoIntegrador4.services.NoticiaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NoticiaServiceImplements implements NoticiaService{
    
    @Autowired
    private NoticiaRepository repository;

    @Override
    public List<Noticia> findAll(){
        return repository.findAll();
    }

    @Override
    public Noticia findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public Noticia save(Noticia noticia) {
        
        return repository.save(noticia);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
    }
    
    @Override
    public void saveImage(MultipartFile imageFile) throws Exception{
        String folder = "D:/Programming/Git-Repositories/ProjetoIntegrador-4/projetoIntegrador4/src/main/resources/static/img/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }
}
