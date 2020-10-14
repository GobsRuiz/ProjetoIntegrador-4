package com.fatec.projetoIntegrador4.services;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Contact;

public interface ContactService {
    
    // Get all data from the database
    List<Contact> findAll();

    // Get the data from the table using the id field.
    Contact findById(Long id);

    // Register
    Contact save(Contact contact);

    // Delete
    void delete(Long id);
}
