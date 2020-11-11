package com.fatec.projetoIntegrador4.services.servicesImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Top20;
import com.fatec.projetoIntegrador4.repositorys.Top20Repository;
import com.fatec.projetoIntegrador4.services.Top20Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Top20ServiceImplements implements Top20Service{
    
    @Autowired
    private Top20Repository repository;

    @Override
    public List<Top20> findAll(){
        return repository.findAll();
    }

    @Override
    public Top20 findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public Top20 save(Top20 top20) {
        
        return repository.save(top20);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
	}
}
