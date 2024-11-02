package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.BookingDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.entity.Booking;
import com.example.ScheduleMate.entity.BookingStatus;
import com.example.ScheduleMate.service.BookingService;
import com.example.ScheduleMate.utils.ResponseCode;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<?>> createBooking(@RequestBody BookingDto bookingDto) {
        bookingService.createBooking(bookingDto);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, bookingDto));
    }

    @PutMapping("/providers/{providerId}/{bookingId}")
    public ResponseEntity<APIResponse<BookingDto>> approveOrRejectBooking(@PathVariable Long providerId,
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



    @GetMapping("/clients")
    public ResponseEntity<APIResponse<List<BookingDto>>> getAllClientBooking() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByClientView()));
    }
    @GetMapping("/clients/incoming")
    public ResponseEntity<APIResponse<List<BookingDto>>> geClienttBookingIncoming() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByClientViewANDINCOMING()));
    }
    @GetMapping("/clients/cancelled")
    public ResponseEntity<APIResponse<List<BookingDto>>> getClientBookingCancelled() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByClientViewANDCANCELLED()));
    }
    @GetMapping("/clients/completed")
    public ResponseEntity<APIResponse<List<BookingDto>>> getClientBookingCompleted() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByClientViewANDCOMPLETED()));
    }
    @GetMapping("/business")
    public ResponseEntity<APIResponse<List<BookingDto>>> getBusinessBookings() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByBusinessView()));
    }
    @GetMapping("/business/incoming")
    public ResponseEntity<APIResponse<List<BookingDto>>> getBusinessBokokingIncoming() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByBusinessViewANDINCOMING()));
    }
    @GetMapping("/business/cancelled")
    public ResponseEntity<APIResponse<List<BookingDto>>> getBusinessBookingCancelled() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByBusinessViewANDCANCELLED()));
    }
    @GetMapping("/business/completed")
    public ResponseEntity<APIResponse<List<BookingDto>>> getBusinessBookingCompleted() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByBusinessViewANDCOMPLETED()));
    }

}
