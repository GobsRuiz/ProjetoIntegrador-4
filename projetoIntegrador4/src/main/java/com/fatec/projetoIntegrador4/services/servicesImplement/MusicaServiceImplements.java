package com.fatec.projetoIntegrador4.services.servicesImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Musica;
import com.fatec.projetoIntegrador4.repositorys.MusicaRepository;
import com.fatec.projetoIntegrador4.services.MusicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImplements implements MusicaService{
    
    @Autowired
    private MusicaRepository repository;

    @Override
    public List<Musica> findAll(){
        return repository.findAll();
    }

    @Override
    public Musica findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public Musica save(Musica musica) {
        
        return repository.save(musica);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
	}
}
