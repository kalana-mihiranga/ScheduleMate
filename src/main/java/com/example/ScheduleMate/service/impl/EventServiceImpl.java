package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.dto.EventDto;
import com.example.ScheduleMate.entity.Event;
import com.example.ScheduleMate.repository.EventRepository;
import com.example.ScheduleMate.service.EventService;
import com.example.ScheduleMate.utils.converters.EventDtoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public void postAvailabilityy(EventDto event) {
        Event events = EventDtoUtils.EVENT_DTO_TO_EVENT_FUNCTION.apply(event);

         eventRepository.save(events);
    }

    @Override
    public List<EventDto> getAvailability() {

        return eventRepository.findAll().stream().
                map(e->EventDtoUtils.EVENT_TO_EVENT_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }
}
