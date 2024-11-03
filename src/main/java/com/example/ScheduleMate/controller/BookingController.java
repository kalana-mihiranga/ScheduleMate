package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.BookingDto;
import com.example.ScheduleMate.endpoints.APIResponse;
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
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/{clientId}")
    public ResponseEntity<APIResponse<Null>> createBooking(@Valid  @PathVariable Long clientId, @RequestBody BookingDto booking) {


    @PostMapping("/create")
    public ResponseEntity<APIResponse<?>> createBooking(@RequestBody BookingDto bookingDto) {
        bookingService.createBooking(bookingDto);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, bookingDto));
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



    @GetMapping("/clients")
    public ResponseEntity<APIResponse<List<BookingDto>>> getAllClientBooking() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByClientView()));
    }
    @GetMapping("/clients/incoming/{clientId}")
    public ResponseEntity<APIResponse<List<BookingDto>>> geClienttBookingIncoming(@PathVariable Long clientId) {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByClientViewANDINCOMING(clientId)));
    }
    @GetMapping("/clients/cancelled/{clientId}")
    public ResponseEntity<APIResponse<List<BookingDto>>> getClientBookingCancelled(@PathVariable Long clientId) {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByClientViewANDCANCELLED(clientId)));
    }
    @GetMapping("/clients/completed/{clientId}")
    public ResponseEntity<APIResponse<List<BookingDto>>> getClientBookingCompleted(@PathVariable Long clientId) {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByClientViewANDCOMPLETED(clientId)));
    }
    @GetMapping("/business")
    public ResponseEntity<APIResponse<List<BookingDto>>> getBusinessBookings() {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByBusinessView()));
    }
    @GetMapping("/business/incoming/{clientId}")
    public ResponseEntity<APIResponse<List<BookingDto>>> getBusinessBookingIncoming(@PathVariable Long clientId) {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByBusinessViewANDINCOMING(clientId)));
    }
    @GetMapping("/business/cancelled/{clientId}")
    public ResponseEntity<APIResponse<List<BookingDto>>> getBusinessBookingCancelled(@PathVariable Long clientId) {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByBusinessViewANDCANCELLED(clientId)));
    }
    @GetMapping("/business/completed/{clientId}")
    public ResponseEntity<APIResponse<List<BookingDto>>> getBusinessBookingCompleted(@PathVariable Long clientId) {
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,bookingService.findBookingByBusinessViewANDCOMPLETED(clientId)));
    }

}
