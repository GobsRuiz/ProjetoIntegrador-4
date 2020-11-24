package com.fatec.projetoIntegrador4.services.servicesImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Administrador;
import com.fatec.projetoIntegrador4.repositorys.AdministradorRepository;
import com.fatec.projetoIntegrador4.services.AdministradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorImplementsService implements AdministradorService{
    
    @Autowired
    private AdministradorRepository repository;

    @Override
    public List<Administrador> findAll(){
        return repository.findAll();
    }

    @Override
    public Administrador findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public Administrador save(Administrador administrador) {
        
        return repository.save(administrador);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
    }
}
