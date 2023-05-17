package com.example.demo.service;

import com.example.demo.entity.EmailMessage;
import com.example.demo.repository.SendEmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderService{
//    @Value("{spring.mail.username}")
//    private final String fromEmail;
    private final JavaMailSender javaMailSender;
    private final SendEmailRepository emailRepository;

    public void sendEmail(String to){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("caotuyen1999vp1@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("FB88 kinh chao quy khach");
        simpleMailMessage.setText("abc");

        javaMailSender.send(simpleMailMessage);
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setToEmail(to);
        emailRepository.save(emailMessage);
    }
}
