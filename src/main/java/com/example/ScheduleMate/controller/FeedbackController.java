package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.FeedbackDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.service.FeedbackService;
import com.example.ScheduleMate.utils.ResponseCode;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;
    @PostMapping("/create")
    public ResponseEntity<APIResponse<Null>> addFeedback(@RequestBody FeedbackDto feedbackDto) {

        feedbackService.createFeedback(feedbackDto);

        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }
}
