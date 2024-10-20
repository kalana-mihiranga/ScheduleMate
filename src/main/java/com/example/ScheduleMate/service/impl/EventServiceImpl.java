package com.example.ScheduleMate.service.impl;

import com.amazonaws.services.chimesdkmeetings.model.UnauthorizedException;
import com.example.ScheduleMate.config.exception.CommonException;
import com.example.ScheduleMate.config.exception.GlobalExceptionHandler;
import com.example.ScheduleMate.dto.EventDto;
import com.example.ScheduleMate.entity.Client;
import com.example.ScheduleMate.entity.Event;
import com.example.ScheduleMate.entity.Role;
import com.example.ScheduleMate.repository.ClientRepository;
import com.example.ScheduleMate.repository.EventRepository;
import com.example.ScheduleMate.service.EventService;
import com.example.ScheduleMate.utils.ResponseCode;
import com.example.ScheduleMate.utils.converters.EventDtoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ClientRepository clientRepository;

    @Override
    public void postAvailabilityy(EventDto event) {

        Optional<Client> client = clientRepository.findById(event.getProviderId());
        if(client.isPresent()){
                    if (client.get().getRole() != Role.BUSINESS_OWNER) {
            throw new UnauthorizedException("Only business owners can create events");
                    }
        }else{
            throw new CommonException(ResponseCode.NOT_FOUND);
        }


        Event events = EventDtoUtils.EVENT_DTO_TO_EVENT_FUNCTION.apply(event);
        events.setProviderId(client.get());

         eventRepository.save(events);
    }

    @Override
    public List<EventDto> getAvailability() {

        return eventRepository.findAll().stream().
                map(e->EventDtoUtils.EVENT_TO_EVENT_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }
}
