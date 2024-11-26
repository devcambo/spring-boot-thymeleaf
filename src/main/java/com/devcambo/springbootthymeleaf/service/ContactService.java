package com.devcambo.springbootthymeleaf.service;

import com.devcambo.springbootthymeleaf.model.Contact;
import com.devcambo.springbootthymeleaf.repo.ContactRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;

    public void save(Contact contact) {
        contactRepo.save(contact);
    }

}
