package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.entity.Event;
import com.example.ScheduleMate.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
@RequiredArgsConstructor
public class EventController {
    private EventService eventService;

    @PostMapping("/{providerId}/availability")
    public ResponseEntity<Event> postAvailability(@PathVariable Long providerId, @RequestBody Event event) {
//        event.setProviderId(providerId);
        return ResponseEntity.ok(eventService.postAvailabilityy(event));
    }

    @GetMapping("/availability")
    public ResponseEntity<List<Event>> getAvailability() {
        return ResponseEntity.ok(eventService.getAvailability());
    }
}
