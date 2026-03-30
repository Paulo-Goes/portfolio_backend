package com.paulo.portfolio.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "contact_message")
public class ContactMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @Size(max=100)
    private String name;

    @Column(length = 100, nullable = false)
    @Size(max=100)
    private String email;

    @Column(length = 1000, nullable = false)
    @Size(max=1000)
    private String message;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    @PrePersist
    public void PrePersist() {
        sentAt = LocalDateTime.now();
    }
}
