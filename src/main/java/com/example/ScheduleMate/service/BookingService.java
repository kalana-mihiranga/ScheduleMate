package com.example.ScheduleMate.service;

import com.example.ScheduleMate.entity.Booking;
import com.example.ScheduleMate.entity.BookingStatus;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking approveOrRejectBooking(Long bookingId, BookingStatus status, String providerNotes);
    List<Booking> getBookingsByClientId(Long clientId);

}
