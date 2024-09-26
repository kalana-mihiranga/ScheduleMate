package com.example.ScheduleMate.utils.converters;

import com.example.ScheduleMate.dto.EventDto;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Event;

import java.util.List;
import java.util.function.Function;

public class EventDtoUtils {

    public static final Function<Event, EventDto> EVENT_TO_EVENT_DTO_FUNCTION = event -> {
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setProviderId(event.getProviderId() != null ? event.getProviderId().getId() : null);
        eventDto.setEventTitle(event.getEventTitle());
        eventDto.setDescription(event.getDescription());
        eventDto.setPosterUrl(event.getPosterUrl());

        // Convert available time slots to their IDs
//        List<Long> timeSlotIds = event.getAvailableTimeSlots()
//                .stream()
//                .map(TimeSlot::getId)
//                .toList();
//        eventDto.setAvailableTimeSlots(timeSlotIds);

        return eventDto;
    };

    public static final Function<EventDto, Event> EVENT_DTO_TO_EVENT_FUNCTION = eventDto -> {
        Event event = new Event();
        event.setId(eventDto.getId());

        // Assuming a method exists to find Client by ID
//        Client provider = findClientById(eventDto.getProviderId());
//        event.setProviderId(provider);

        event.setEventTitle(eventDto.getEventTitle());
        event.setDescription(eventDto.getDescription());
        event.setPosterUrl(eventDto.getPosterUrl());

        // Convert available time slot IDs back to TimeSlot objects
//        List<TimeSlot> timeSlots = eventDto.getAvailableTimeSlots()
//                .stream()
//                .map(slotId -> {
//                    TimeSlot timeSlot = new TimeSlot();
//                    timeSlot.setId(slotId);
//                    // Optionally, set other properties of TimeSlot if needed
//                    timeSlot.setEvent(event); // Set back reference to the event
//                    return timeSlot;
//                })
//                .toList();
//        event.setAvailableTimeSlots(timeSlots);

        return event;
    };


}
