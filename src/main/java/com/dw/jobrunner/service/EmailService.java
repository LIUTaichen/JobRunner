package com.dw.jobrunner.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    public JavaMailSender emailSender;


    public void sendDailyArchivalEmail(){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("jason.liu@dempseywood.co.nz");
        message.setTo("jason.liu@dempseywood.co.nz");
        message.setSubject("Daily Archival of Project Cost");
        message.setText("Daily archival of project cost has been completed successfully");
        emailSender.send(message);
        log.info("Archival notification email sent. ");
    }
}
