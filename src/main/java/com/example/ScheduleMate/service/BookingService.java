package com.example.ScheduleMate.service;

import com.example.ScheduleMate.dto.BookingDto;
import com.example.ScheduleMate.entity.Booking;
import com.example.ScheduleMate.entity.BookingStatus;

import java.util.List;

public interface BookingService {
    void createBooking(BookingDto bookingDto);
    BookingDto approveOrRejectBooking(Long bookingId, BookingStatus status, String providerNotes);
    List<BookingDto> getBookingsByClientId(Long clientId);

    List<BookingDto>findBookingByClientView();
    List<BookingDto>findBookingByClientViewANDINCOMING();
    List<BookingDto>findBookingByClientViewANDCANCELLED();
    List<BookingDto>findBookingByClientViewANDCOMPLETED();

    List<BookingDto>findBookingByBusinessView();
    List<BookingDto>findBookingByBusinessViewANDINCOMING();
    List<BookingDto>findBookingByBusinessViewANDCANCELLED();
    List<BookingDto>findBookingByBusinessViewANDCOMPLETED();

}
