package com.example.smartcontactmanager.controller;

import com.example.smartcontactmanager.entity.Contact;
import com.example.smartcontactmanager.entity.User;
import com.example.smartcontactmanager.repository.ContactRepository;
import com.example.smartcontactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    // Get All Contacts - अब सिर्फ जिनका token भेजा है, उनके
    @GetMapping("/search")
    public List<Contact> searchContacts(
            @RequestParam("q") String keyword,
            Authentication authentication) {

        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        return contactRepository.searchByKeyword(user, keyword);
    }

    // बाकी CRUD (example: create)
    @PostMapping
    public Contact createContact(@RequestBody Contact contact, Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        contact.setUser(user); // SET OWNER!
        return contactRepository.save(contact);
    }

    // किसी भी contact को id से लाओ, लेकिन user check करो
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id, Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found id: " + id));
        if (!contact.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Not allowed! Not your contact.");
        }
        return contact;
    }

    // Delete contact - केवल owner delete कर सकता है
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id, Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found id: " + id));
        if (!contact.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Not allowed! Not your contact.");
        }
        contactRepository.delete(contact);
    }

    // Update contact भी इसी pattern पर कर सकते हो (user check करके)!
}
