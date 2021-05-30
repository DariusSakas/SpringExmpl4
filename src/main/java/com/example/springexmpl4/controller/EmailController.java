package com.example.springexmpl4.controller;

import com.example.springexmpl4.model.Email;
import com.example.springexmpl4.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email")
@AllArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/")
    public void sendEmail(@RequestBody Email email){
        emailService.sendEmail(email);
    }
    @GetMapping("/")
    public List<Email> getAllEmails(){
        return emailService.getAllEmails();
    }
}
