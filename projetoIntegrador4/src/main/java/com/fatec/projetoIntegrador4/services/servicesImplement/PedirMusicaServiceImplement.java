package com.fatec.projetoIntegrador4.services.servicesImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.PedirMusica;
import com.fatec.projetoIntegrador4.repositorys.PedirMusicaRepository;
import com.fatec.projetoIntegrador4.services.PedirMusicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedirMusicaServiceImplement implements PedirMusicaService{
    
    @Autowired
    private PedirMusicaRepository repository;

    @Override
    public List<PedirMusica> findAll(){
        return repository.findAll();
    }

    @Override
    public PedirMusica findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public PedirMusica save(PedirMusica pedirMusica) {
        
        return repository.save(pedirMusica);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
	}
}
