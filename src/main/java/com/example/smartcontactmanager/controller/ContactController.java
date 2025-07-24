package com.example.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartcontactmanager.entity.Contact;
import com.example.smartcontactmanager.service.ContactService;
import java.util.List;

//import com.smartcontact.smartcontactmanager.entity.Contact;
//import com.smartcontact.smartcontactmanager.service.ContactService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/contacts")
public class ContactController {
	 @Autowired
	    private ContactService contactService;
	 
	 @PostMapping
	    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
	        Contact savedContact = contactService.saveContact(contact);
	        return ResponseEntity.ok(savedContact);
	    }
	    @GetMapping
	    public List<Contact>getAllContacts() {
	        return contactService.findAll();
     }
      
	    @GetMapping("/{id}")
	    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
	        return contactService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
	        contactService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
