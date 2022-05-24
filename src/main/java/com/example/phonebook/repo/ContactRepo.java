package com.example.phonebook.repo;

import java.util.Optional;

import com.example.phonebook.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Long> {
    void deleteContactById(Long id);
    
    Optional<Contact> findContactById(Long id);
}
