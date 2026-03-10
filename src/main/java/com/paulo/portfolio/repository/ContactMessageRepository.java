package com.paulo.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.portfolio.model.ContactMessage;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long>{
}