package com.example.ScheduleMate.Notification;

import com.example.ScheduleMate.dto.EmailDto;
import com.example.ScheduleMate.feignClient.EmailInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmailNotification implements NotificationTask {
    private final EmailInterface emailInterface;


    @Override
    public void send(String type,String message, String role, String email) {

        log.info("Email Notification Sent: " + message);


        EmailDto emailDto = new EmailDto();
        emailDto.setEmail(email); // Set the recipient's email
        emailDto.setSubject("🎉 SheduleMate App Registration Successful! 🎉");
        emailDto.setContent(message);

        try {
            emailInterface.postMail(emailDto);
            log.info("Email Notification Sent: " + message);
        } catch (Exception e) {
            log.error("Failed to send email notification: ", e);
        }

    }
}
