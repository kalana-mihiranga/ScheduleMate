package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.config.exception.CommonException;
import com.example.ScheduleMate.dto.BookingDto;

import com.example.ScheduleMate.entity.Booking;
import com.example.ScheduleMate.entity.BookingStatus;
import com.example.ScheduleMate.notification.events.BookingNotificationEvent;

import com.example.ScheduleMate.entity.*;

import com.example.ScheduleMate.repository.BookingRepository;
import com.example.ScheduleMate.repository.ClientRepository;
import com.example.ScheduleMate.repository.PackagesRepository;
import com.example.ScheduleMate.repository.ServicesRepository;
import com.example.ScheduleMate.service.BookingService;
import com.example.ScheduleMate.utils.ResponseCode;
import com.example.ScheduleMate.utils.converters.BookingDtoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ServicesRepository servicesRepository;


    private final ApplicationEventPublisher eventPublisher;

    private final ClientRepository clientRepository;
    private final PackagesRepository packagesRepository;

    @Override
    @Transactional
    public void createBooking(BookingDto booking) {

        Booking bookingDetails = BookingDtoUtils.BOOKING_DTO_TO_BOOKING_FUNCTION.apply(booking);
        bookingDetails.setStatus(BookingStatus.PENDING);
        bookingDetails.setBookingTime(java.time.LocalDateTime.now());
        bookingDetails.setServices(servicesRepository.findById(booking.getServiceId()).orElse(null));
=======

        Optional<Client> clientResult = Optional.of(clientRepository.getById(booking.getClientId()));
        Optional<Services> serviceResult = Optional.of(servicesRepository.getById(booking.getServiceId()));
        Optional<Packages> packageResult = Optional.of(packagesRepository.getById(booking.getPackageId()));

        if (!clientResult.isPresent() || !serviceResult.isPresent() || !packageResult.isPresent()) {
            throw new CommonException(ResponseCode.RESOURCE_NOT_FOUND);
        } else {

            System.out.println( serviceResult.get().getServiceFrom().isBefore(booking.getStartingTime()) || serviceResult.get().getServiceFrom().equals(booking.getStartingTime()));
            System.out.println( booking.getStartingTime().plusMinutes(packageResult.get().getDuration()).isBefore(serviceResult.get().getServiceTo()) || booking.getStartingTime().plusMinutes(packageResult.get().getDuration()).equals(serviceResult.get().getServiceTo()) );
            if ( ( serviceResult.get().getServiceFrom().isBefore(booking.getStartingTime()) || serviceResult.get().getServiceFrom().equals(booking.getStartingTime())) && ( booking.getStartingTime().plusMinutes(packageResult.get().getDuration()).isBefore(serviceResult.get().getServiceTo()) || booking.getStartingTime().plusMinutes(packageResult.get().getDuration()).equals(serviceResult.get().getServiceTo()) ) ) {

                List<Booking> bookingResult = bookingRepository.findByStartingTime(booking.getStartingTime());

                if (bookingResult.isEmpty()) {
                    Booking bookingInstance = new Booking();

                    bookingInstance.setClientNote(booking.getClientNote());
                    bookingInstance.setBusinessNote(booking.getBusinessNote());
                    bookingInstance.setIsPaid(booking.getIsPaid());
                    bookingInstance.setStartingTime(booking.getStartingTime());
                    bookingInstance.setBookingDate(booking.getBookingDate());
                    bookingInstance.setStatus(BookingStatus.INCOMING);
                    bookingInstance.setServices(serviceResult.get());
                    bookingInstance.setPackages(packageResult.get());
                    bookingInstance.setClient(clientResult.get());

                    bookingRepository.save(bookingInstance);
                } else {
                    throw new CommonException(ResponseCode.BOOKING_TIME_OVERLAP);
                }

            } else {
                throw new CommonException(ResponseCode.NOT_SERVICE_TIME);
            }

        }

        eventPublisher.publishEvent(new BookingNotificationEvent(this, "client", "New booking confirmed!", "push"));
//        eventPublisher.publishEvent(new BookingNotificationEvent(this, "business", "Your booking has been approved.", "inapp"));
    }

    @Override
    public BookingDto approveOrRejectBooking(Long bookingId, BookingStatus status, String providerNotes) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new IllegalArgumentException("Invalid booking Id"));
        booking.setStatus(status);
        booking.setBusinessNote(providerNotes);
        bookingRepository.save(booking);
        BookingDto bookingResponse = BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(booking);
        return bookingResponse;

    }

    @Override
    public List<BookingDto> getBookingsByClientId(Long clientId) {
        return bookingRepository.findByClientId(clientId).
                stream().map(e->BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(e)).collect(Collectors.toList());

    }

    @Override
    public List<BookingDto> findBookingByClientView() {
        return bookingRepository.findAll().stream()
                .filter(e->e.getClient().getRole().toString().equals("CLIENT"))
                .map(e->BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> findBookingByClientViewANDINCOMING(Long clientId) {
        return bookingRepository.findByClientId(clientId).stream()
                .filter(e->e.getClient().getRole().toString().equals("CLIENT")).filter(e->e.getStatus().toString().equals("INCOMING"))
                .map(e->BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> findBookingByClientViewANDCANCELLED(Long clientId) {
        return bookingRepository.findByClientId(clientId).stream()
                .filter(e->e.getClient().getRole().toString().equals("CLIENT")).filter(e->e.getStatus().toString().equals("CANCELLED"))
                .map(e->BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> findBookingByClientViewANDCOMPLETED(Long clientId) {
        return bookingRepository.findByClientId(clientId).stream()
                .filter(e->e.getClient().getRole().toString().equals("CLIENT")).filter(e->e.getStatus().toString().equals("COMPLETED"))
                .map(e->BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> findBookingByBusinessView() {
        return bookingRepository.findAll().stream()
                .filter(e->e.getClient().getRole().toString().equals("BUSINESS"))
                .map(e->BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> findBookingByBusinessViewANDINCOMING(Long clientId) {
        return bookingRepository.findByClientId(clientId).stream()
                .filter(e->e.getClient().getRole().toString().equals("BUSINESS")).filter(e->e.getStatus().toString().equals("INCOMING"))
                .map(e->BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> findBookingByBusinessViewANDCANCELLED(Long clientId) {
        return bookingRepository.findByClientId(clientId).stream()
                .filter(e->e.getClient().getRole().toString().equals("BUSINESS")).filter(e->e.getStatus().toString().equals("CANCELLED"))
                .map(e->BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> findBookingByBusinessViewANDCOMPLETED(Long clientId) {
        return bookingRepository.findByClientId(clientId).stream()
                .filter(e->e.getClient().getRole().toString().equals("BUSINESS")).filter(e->e.getStatus().toString().equals("COMPLETED"))
                .map(e->BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }
}
