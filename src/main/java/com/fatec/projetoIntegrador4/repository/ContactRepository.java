package com.fatec.projetoIntegrador4.repository;

import com.fatec.projetoIntegrador4.models.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long>{
}
