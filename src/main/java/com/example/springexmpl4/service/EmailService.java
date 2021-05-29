package com.example.springexmpl4.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class EmailService {

    private static final String EMAIL = "test";

    private final JavaMailSender javaMailSender;

    public void sendEmail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(EMAIL);
        simpleMailMessage.setTo(EMAIL);
        simpleMailMessage.setSubject("Subject");
        simpleMailMessage.setText("This is sent message");

        javaMailSender.send(simpleMailMessage);
        log.info("Email sent to" + EMAIL);
    }


}
