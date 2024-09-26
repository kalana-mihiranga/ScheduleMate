package com.example.ScheduleMate.service.impl;

import com.example.ScheduleMate.entity.Booking;
import com.example.ScheduleMate.entity.BookingStatus;
import com.example.ScheduleMate.repository.BookingRepository;
import com.example.ScheduleMate.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    @Override
    public Booking createBooking(Booking booking) {
        booking.setStatus(BookingStatus.PENDING);
        booking.setBookingTime(java.time.LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    @Override
    public Booking approveOrRejectBooking(Long bookingId, BookingStatus status, String providerNotes) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new IllegalArgumentException("Invalid booking Id"));
        booking.setStatus(status);
        booking.setProviderNotes(providerNotes);
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByClientId(Long clientId) {
        return bookingRepository.findByClientId(clientId);
    }
}
