package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.BookingDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.entity.Booking;
import com.example.ScheduleMate.entity.BookingStatus;
import com.example.ScheduleMate.service.BookingService;
import com.example.ScheduleMate.utils.ResponseCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    @PostMapping("/{clientId}")
    public ResponseEntity<APIResponse<Null>> createBooking(@Valid  @PathVariable Long clientId, @RequestBody BookingDto booking) {

        bookingService.createBooking(booking);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }

    @PutMapping("/providers/{providerId}/{bookingId}")
    public ResponseEntity<APIResponse<BookingDto>> approveOrRejectBooking(@Valid @PathVariable Long providerId,
                                                          @PathVariable Long bookingId,
                                                          @RequestParam("status") BookingStatus status,
                                                          @RequestBody String providerNotes) {
        BookingDto bookingDto = bookingService.approveOrRejectBooking(bookingId, status, providerNotes);

        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingDto));
    }

    @GetMapping("/clients/{clientId}")
    public ResponseEntity<APIResponse<List<BookingDto>>> getClientBookings(@PathVariable Long clientId) {

        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.getBookingsByClientId(clientId)));
    }
}
