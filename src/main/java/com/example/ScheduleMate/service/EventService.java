package com.example.ScheduleMate.service;

import com.example.ScheduleMate.dto.EventDto;
import com.example.ScheduleMate.entity.Event;

import java.util.List;

public interface EventService {
    void postAvailabilityy(EventDto event);
    List<EventDto> getAvailability();
}
