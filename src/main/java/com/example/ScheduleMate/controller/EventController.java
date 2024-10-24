package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.EventDto;
import com.example.ScheduleMate.dto.clientDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.entity.Event;
import com.example.ScheduleMate.service.EventService;
import com.example.ScheduleMate.utils.ResponseCode;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final  EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<Null>> createEvent( @RequestBody EventDto event) {

        eventService.postAvailabilityy(event);

        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }

    //getAllEvents
    @GetMapping("/availability")
    public ResponseEntity<APIResponse<List<EventDto>>> getAvailability() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,eventService.getAvailability()));
    }
}
