package com.example.messageapp.controller;

import com.example.messageapp.entity.Message;
import com.example.messageapp.repository.MessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    private final MessageRepository messageRepository;

    public MainController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        var allMessages = messageRepository.findAll();
         return ResponseEntity.ok(allMessages);
    }

    @PostMapping
    public ResponseEntity<?> createMessage(@RequestBody Message message) {

        message.setCreatedAt(LocalDateTime.now());

        try {
            messageRepository.save(message);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(
                    """
                            ERROR: Message title has to be UNIQUE and values cannot be NULL or BLANK.
                            
                            title max lenght is 50.
                            content max lenght is 400.
                            """
            );
        }
    }
}
