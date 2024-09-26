package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.entity.Event;
import com.example.ScheduleMate.repository.EventRepository;
import com.example.ScheduleMate.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public Event postAvailabilityy(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAvailability() {
        return eventRepository.findAll();
    }
}
