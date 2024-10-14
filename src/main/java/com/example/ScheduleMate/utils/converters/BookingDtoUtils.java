package com.example.ScheduleMate.utils.converters;

import com.example.ScheduleMate.dto.BookingDto;
import com.example.ScheduleMate.entity.Booking;
import com.example.ScheduleMate.entity.BookingStatus;

import java.util.function.Function;

public class BookingDtoUtils {

    public static final Function<Booking, BookingDto> BOOKING_TO_BOOKING_DTO_FUNCTION = booking -> {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingId(booking.getId());
//        bookingDto.setClientId(booking.getClientId());
//        bookingDto.setEventId(booking.getEventId());
//        bookingDto.setSlotId(booking.getSlotId());
        bookingDto.setNotes(booking.getNotes());
        bookingDto.setStatus(booking.getStatus().name()); // Convert Enum to String
        bookingDto.setProviderNotes(booking.getProviderNotes());
        bookingDto.setBookingTime(booking.getBookingTime());
        return bookingDto;
    };

    public static final Function<BookingDto, Booking> BOOKING_DTO_TO_BOOKING_FUNCTION = bookingDto -> {
        Booking booking = new Booking();
        booking.setId(bookingDto.getBookingId());
//        booking.setClientId(bookingDto.getClientId());
//        booking.setEventId(bookingDto.getEventId());
//        booking.setSlotId(bookingDto.getSlotId());
        booking.setNotes(bookingDto.getNotes());
        booking.setStatus(BookingStatus.valueOf(bookingDto.getStatus())); // Convert String to Enum
        booking.setProviderNotes(bookingDto.getProviderNotes());
        booking.setBookingTime(bookingDto.getBookingTime());
        return booking;
    };


}
