package com.example.smartcontactmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.smartcontactmanager.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
