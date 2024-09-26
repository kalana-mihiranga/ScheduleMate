package com.example.ScheduleMate.service;

import com.example.ScheduleMate.entity.Event;

import java.util.List;

public interface EventService {
    Event postAvailabilityy(Event event);
    List<Event> getAvailability();
}
