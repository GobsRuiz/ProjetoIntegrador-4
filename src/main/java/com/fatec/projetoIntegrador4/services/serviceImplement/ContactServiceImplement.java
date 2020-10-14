package com.fatec.projetoIntegrador4.services.serviceImplement;

import java.util.List;

import com.fatec.projetoIntegrador4.models.Contact;
import com.fatec.projetoIntegrador4.repository.ContactRepository;
import com.fatec.projetoIntegrador4.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImplement implements ContactService{

    @Autowired
    private ContactRepository repository;

    @Override
    public List<Contact> findAll() {
        
        return repository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        
        return repository.findById(id).get();
    }

    @Override
    public Contact save(Contact contact) {
        
        return repository.save(contact);
    }

    @Override
    public void delete(Long id) {
		repository.deleteById(id);
	}
}
