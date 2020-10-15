package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Team;

public interface TeamService {
    
    // Get all data from the database
    List<Team> findAll();

    // Get the data from the table using the id field.
    Team findById(Long id);

    // Register
    Team save(Team team);

    // Delete
    void delete(Long id);
}
