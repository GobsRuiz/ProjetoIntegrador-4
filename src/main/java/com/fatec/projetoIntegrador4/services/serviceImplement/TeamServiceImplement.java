package com.fatec.projetoIntegrador4.services.serviceImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Team;
import com.fatec.projetoIntegrador4.repository.TeamRepository;
import com.fatec.projetoIntegrador4.services.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImplement implements TeamService{
    
    @Autowired
    private TeamRepository repository;

    @Override
    public List<Team> findAll() {
        
        return repository.findAll();
    }

    @Override
    public Team findById(Long id) {
        
        return repository.findById(id).get();
    }

    @Override
    public Team save(Team team) {
        
        return repository.save(team);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
	}
}
