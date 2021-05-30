package com.example.springexmpl4.service;

import com.example.springexmpl4.model.Email;
import com.example.springexmpl4.repository.EmailRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EmailService {

    private static final String EMAIL = "email@email.com";

    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;

    public void sendEmail(Email email){
        saveEmailToDB(email);

        javaMailSender.send(generateSimpleMailMessage(email));
        log.info("Email was sent to " + email.getSendTo());
    }
    public List<Email> getAllEmails(){
        return emailRepository.findAll();
    }
    public void saveEmailToDB(Email email){
        emailRepository.save(email);
    }
    public SimpleMailMessage generateSimpleMailMessage (Email email){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(email.getSendTo());
        simpleMailMessage.setSubject(email.getMailSubject());
        simpleMailMessage.setText(email.getMailText() + "\n" + email.getSentBy());

        return simpleMailMessage;
    }

    public void sendEmailWithAttachment(Email email) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setSubject(email.getMailSubject());
        messageHelper.setTo(email.getSendTo());
        messageHelper.setText(email.getMailText() + "\n" + email.getSentBy());

        File file = new File(PdfService.PDF_FILE_PATH);
        messageHelper.addAttachment("virus_" + file.getName(), file);

        javaMailSender.send(message);
        log.info("Email was send with and attachment");
    }
}
