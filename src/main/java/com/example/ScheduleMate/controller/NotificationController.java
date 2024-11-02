package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.BookingDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.entity.Notification;
import com.example.ScheduleMate.service.NotificationViewService;
import com.example.ScheduleMate.utils.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationViewService notificationViewService;


    @GetMapping("/clients/{clientId}")
    public ResponseEntity<APIResponse<List<Notification>>> getNotificationForClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,notificationViewService.getAlLNotificationsForClient(clientId)));
    }

    @GetMapping("/business/{clientId}")
    public ResponseEntity<APIResponse<List<Notification>>> getNotificationForBooking(@PathVariable Long clientId) {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,notificationViewService.getAlLNotificationsForBusiness(clientId)));
    }
}
