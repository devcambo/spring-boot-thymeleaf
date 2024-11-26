package com.devcambo.springbootthymeleaf.repo;

import com.devcambo.springbootthymeleaf.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
}
