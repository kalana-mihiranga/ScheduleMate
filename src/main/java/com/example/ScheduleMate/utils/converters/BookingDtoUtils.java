package com.example.ScheduleMate.utils.converters;

import com.example.ScheduleMate.dto.BookingDto;
import com.example.ScheduleMate.entity.*;

import java.util.function.Function;

public class BookingDtoUtils {

    public static final Function<Booking, BookingDto> BOOKING_TO_BOOKING_DTO_FUNCTION = booking -> {
        if (booking == null) return null;

        return new BookingDto(
                booking.getId(),
                booking.getClientNote(),
                booking.getBusinessNote(),
                booking.getIsPaid(),
                booking.getStartingTime(),
                booking.getBookingDate(),
                booking.getClient() != null ? booking.getClient().getId() : null,
                booking.getServices() != null ? booking.getServices().getId() : null,
                booking.getPackages() != null ? booking.getPackages().getId() : null,
                booking.getStatus().toString(),
                booking.getClient()!= null ? booking.getClient().getRole().toString() : null
        );
    };

    // Function to convert BookingDto to Booking
    public static final Function<BookingDto, Booking> BOOKING_DTO_TO_BOOKING_FUNCTION = bookingDto -> {
        if (bookingDto == null) return null;

        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setClientNote(bookingDto.getClientNote());
        booking.setBusinessNote(bookingDto.getBusinessNote());
        booking.setIsPaid(bookingDto.getIsPaid());
        booking.setStartingTime(bookingDto.getStartingTime());
        booking.setBookingDate(bookingDto.getBookingDate());

        // Create and set related entities based on IDs from BookingDto
        Client client = new Client();
        client.setId(bookingDto.getClientId());
        booking.setClient(client);

        Services service = new Services();
        service.setId(bookingDto.getServiceId());
        booking.setServices(service);

        Packages packageEntity = new Packages();
        packageEntity.setId(bookingDto.getPackageId());
        booking.setPackages(packageEntity);

        return booking;
    };

}
