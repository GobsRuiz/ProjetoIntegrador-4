package com.fatec.projetoIntegrador4.services.servicesImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Contato;
import com.fatec.projetoIntegrador4.repositorys.ContatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoServiceImplement implements ContatoService{
    
    @Autowired
    private ContatoRepository repository;

    @Override
    public List<Contato> findAll(){
        return repository.findAll();
    }

    @Override
    public Contato findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public Contato save(Contato contato) {
        
        return repository.save(contato);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
	}
}
