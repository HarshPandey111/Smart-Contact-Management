package com.example.smartcontactmanager.repository;

import com.example.smartcontactmanager.entity.Contact;
import com.example.smartcontactmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByUser(User user);
}
