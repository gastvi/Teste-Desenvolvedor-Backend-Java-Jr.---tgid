package com.br.BackendJavaJr.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JavaMailApp {
	//String to, String subject, String bod
    @Autowired
    private JavaMailSender mailSender;

    public void sendNewMail(String praQuem, String assunto, String texto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(praQuem);
        message.setSubject(assunto);
        message.setText(texto);
        mailSender.send(message);
    }
}