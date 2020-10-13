package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.MusicRequest;

public interface MusicRequestService {
    
    // Get all data from the database
    List<MusicRequest> findAll();

    // Get the data from the table using the id field.
    MusicRequest findById(Long id);

    // Register
    MusicRequest save(MusicRequest musicRequest);

    // Delete
    void delete(Long id);
}
