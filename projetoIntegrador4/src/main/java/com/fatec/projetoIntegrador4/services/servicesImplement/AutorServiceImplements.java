package com.fatec.projetoIntegrador4.services.servicesImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Autor;
import com.fatec.projetoIntegrador4.repositorys.AutorRepository;
import com.fatec.projetoIntegrador4.services.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImplements implements AutorService{
    
    @Autowired
    private AutorRepository repository;

    @Override
    public List<Autor> findAll(){
        return repository.findAll();
    }

    @Override
    public Autor findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public Autor save(Autor autor) {
        
        return repository.save(autor);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
	}
}
