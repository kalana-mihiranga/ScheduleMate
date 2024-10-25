package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.dto.FeedbackDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.service.FeedbackService;
import com.example.ScheduleMate.utils.ResponseCode;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    public ResponseEntity<APIResponse<List<FeedbackDto>>> listAllFeedbacks() {
        List<FeedbackDto> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, feedbacks));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<FeedbackDto>> getFeedbackById(@PathVariable Long id) {
        FeedbackDto feedback = feedbackService.getFeedbackById(id);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS, feedback));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<APIResponse<Null>> updateFeedback(
            @PathVariable Long id,
            @RequestBody FeedbackDto feedbackDto) {
        feedbackService.updateFeedback(id, feedbackDto);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<Null>> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS));
    }
}
