package com.fatec.projetoIntegrador4.services.servicesImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Artista;
import com.fatec.projetoIntegrador4.repositorys.ArtistaRepository;
import com.fatec.projetoIntegrador4.services.ArtistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaServiceImplements implements ArtistaService{
    
    @Autowired
    private ArtistaRepository repository;

    @Override
    public List<Artista> findAll(){
        return repository.findAll();
    }

    @Override
    public Artista findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public Artista save(Artista artista) {
        
        return repository.save(artista);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
	}
}
