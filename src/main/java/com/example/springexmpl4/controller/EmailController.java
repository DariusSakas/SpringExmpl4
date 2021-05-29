package com.example.springexmpl4.controller;

import com.example.springexmpl4.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@AllArgsConstructor
public class EmailController extends BaseController {
    private final EmailService emailService;

    @PostMapping("/")
    public void sendEmail(){
        emailService.sendEmail();
    }
}
