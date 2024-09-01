package com.example.messageapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false, unique = true, length = 50, name = "title")
    private String title;

    @NotNull
    @NotBlank
    @Column(nullable = false, length = 400, name = "content")
    private String content;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getTitle() {
        return title;
    }

    public void setTitle(@NotNull @NotBlank String title) {
        this.title = title;
    }

    public @NotNull @NotBlank String getContent() {
        return content;
    }

    public void setContent(@NotNull @NotBlank String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
