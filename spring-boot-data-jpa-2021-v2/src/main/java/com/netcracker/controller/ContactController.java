package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Contact;
import com.netcracker.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/v1")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/contacts")
    public List<Contact> retrieveAllContacts() {
        return contactRepository.findAll();
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> findContactById(
            @PathVariable(value = "id") Integer contactId
    ) throws ResourceNotFoundException {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("contact not found for id: "+contactId));
        return ResponseEntity.ok().body(contact);
    }

    @PostMapping("/contacts")
    public Contact createContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @DeleteMapping("/contacts/{id}")
    public Map<String, Boolean> deleteContact(@PathVariable(value = "id") Integer contactId) throws ResourceNotFoundException {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("contact not found for id: "+contactId));

        contactRepository.delete(contact);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
