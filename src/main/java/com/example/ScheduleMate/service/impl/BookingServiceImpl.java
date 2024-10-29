package com.example.ScheduleMate.service.Impl;

import com.example.ScheduleMate.config.exception.CommonException;
import com.example.ScheduleMate.dto.BookingDto;
import com.example.ScheduleMate.entity.*;
import com.example.ScheduleMate.repository.BookingRepository;
import com.example.ScheduleMate.repository.ClientRepository;
import com.example.ScheduleMate.repository.PackagesRepository;
import com.example.ScheduleMate.repository.ServicesRepository;
import com.example.ScheduleMate.service.BookingService;
import com.example.ScheduleMate.utils.ResponseCode;
import com.example.ScheduleMate.utils.converters.BookingDtoUtils;
import lombok.RequiredArgsConstructor;
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
    private final ClientRepository clientRepository;
    private final PackagesRepository packagesRepository;

    @Override
    @Transactional
    public void createBooking(BookingDto booking) {

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

    }

    @Override
    public BookingDto approveOrRejectBooking(Long bookingId, BookingStatus status, String providerNotes) {
//        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new IllegalArgumentException("Invalid booking Id"));
//        booking.setStatus(status);
//        booking.setBusinessNote(providerNotes);
//        bookingRepository.save(booking);
//        BookingDto bookingResponse = BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(booking);
//        return bookingResponse;
        return null;
    }

    @Override
    public List<BookingDto> getBookingsByClientId(Long clientId) {
//        return bookingRepository.findByClientId(clientId).
//                stream().map(e->BookingDtoUtils.BOOKING_TO_BOOKING_DTO_FUNCTION.apply(e)).collect(Collectors.toList());
        return null;
    }
}
