package com.example.phonebook.service;

import java.util.List;
import java.util.UUID;

import com.example.phonebook.exception.UserNotFoundException;
import com.example.phonebook.model.Contact;
import com.example.phonebook.repo.ContactRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class ContactService {
    private final ContactRepo contactRepo;

    @Autowired
    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public Contact addContact(Contact contact) {
        contact.setEmplyeeCode(UUID.randomUUID().toString());
        return contactRepo.save(contact);
    }

    public List<Contact> findAllContacts() {
        return contactRepo.findAll();
    }

    public Contact updateContact(Contact contact) {
        return contactRepo.save(contact);
    }

    public Contact findContactById(Long id) {
        return contactRepo.findContactById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    public void deleteContact(Long id) {
        contactRepo.deleteContactById(id);
    }
}
