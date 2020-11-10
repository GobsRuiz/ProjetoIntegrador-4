package com.fatec.projetoIntegrador4.services.servicesImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Programacao;
import com.fatec.projetoIntegrador4.repositorys.ProgramacaoRepository;
import com.fatec.projetoIntegrador4.services.ProgramacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramacaoServiceImplement implements ProgramacaoService{
    
    @Autowired
    private ProgramacaoRepository repository;
    @Override
    public List<Programacao> findAll(){
        return repository.findAll();
    }

    @Override
    public Programacao findById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public Programacao save(Programacao equipe) {
        
        return repository.save(equipe);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
	}
}
