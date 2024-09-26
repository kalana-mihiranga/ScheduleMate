package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.entity.Booking;
import com.example.ScheduleMate.entity.BookingStatus;
import com.example.ScheduleMate.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @PostMapping("/clients/{clientId}")
    public ResponseEntity<Booking> createBooking(@PathVariable Long clientId, @RequestBody Booking booking) {
        booking.setClientId(clientId);
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @PutMapping("/providers/{providerId}/{bookingId}")
    public ResponseEntity<Booking> approveOrRejectBooking(@PathVariable Long providerId,
                                                          @PathVariable Long bookingId,
                                                          @RequestParam("status") BookingStatus status,
                                                          @RequestBody String providerNotes) {
        return ResponseEntity.ok(bookingService.approveOrRejectBooking(bookingId, status, providerNotes));
    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity<List<Booking>> getClientBookings(@PathVariable Long clientId) {
        return ResponseEntity.ok(bookingService.getBookingsByClientId(clientId));
    }
}
