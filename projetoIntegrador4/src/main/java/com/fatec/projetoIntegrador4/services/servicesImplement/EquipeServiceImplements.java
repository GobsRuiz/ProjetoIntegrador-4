package com.fatec.projetoIntegrador4.services.servicesImplement;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.fatec.projetoIntegrador4.models.Equipe;
import com.fatec.projetoIntegrador4.repositorys.EquipeRepository;
import com.fatec.projetoIntegrador4.services.EquipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EquipeServiceImplements implements EquipeService{
    
    @Autowired
    private EquipeRepository repository;

    @Override
    public List<Equipe> findAll(){
        return repository.findAll();
    }

    @Override
    public Equipe findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public Equipe save(Equipe equipe) {
        
        return repository.save(equipe);
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
