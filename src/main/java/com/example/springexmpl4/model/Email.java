package com.example.springexmpl4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sendTo;
    private String sentBy;
    private String mailSubject;
    private String mailText;

    public Email(String sendTo, String sentBy, String mailSubject, String mailText) {
        this.sendTo = sendTo;
        this.sentBy = sentBy;
        this.mailSubject = mailSubject;
        this.mailText = mailText;
    }
}
