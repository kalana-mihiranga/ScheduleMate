package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.dto.BookingDto;
import com.example.ScheduleMate.entity.Booking;
import com.example.ScheduleMate.entity.BookingStatus;
import com.example.ScheduleMate.repository.BookingRepository;
import com.example.ScheduleMate.repository.ServicesRepository;
import com.example.ScheduleMate.service.BookingService;
import com.example.ScheduleMate.utils.converters.BookingDtoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ServicesRepository servicesRepository;
    @Override
    public void createBooking(BookingDto booking) {
        Booking bookingDetails = BookingDtoUtils.BOOKING_DTO_TO_BOOKING_FUNCTION.apply(booking);

        bookingDetails.setStatus(BookingStatus.PENDING);
        bookingDetails.setBookingTime(java.time.LocalDateTime.now());

        bookingDetails.setServices(servicesRepository.findById(booking.getServiceId()).get());

        bookingRepository.save(bookingDetails);

    }

    @Override
    public BookingDto approveOrRejectBooking(Long bookingId, BookingStatus status, String providerNotes) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new IllegalArgumentException("Invalid booking Id"));
        booking.setStatus(status);
        booking.setProviderNotes(providerNotes);
        bookingRepository.save(booking);
        BookingDto bookingResponse = BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(booking);
        return bookingResponse;
    }

    @Override
    public List<BookingDto> getBookingsByClientId(Long clientId) {
        return bookingRepository.findByClientId(clientId).
                stream().map(e->BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
    }
}
