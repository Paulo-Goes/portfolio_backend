package com.paulo.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.paulo.portfolio.model.ContactMessage;
import com.paulo.portfolio.repository.ContactMessageRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    private ContactMessageRepository contactMessageRepository;

    //CREATE

    @PostMapping
    public ContactMessage sendMessage(@RequestBody ContactMessage message) {
        return contactMessageRepository.save(message);
    }

    //READ

    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return contactMessageRepository.findAll();
    }

    //DELETE

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        contactMessageRepository.deleteById(id);
    }
}
