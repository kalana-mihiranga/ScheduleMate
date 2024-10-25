package com.example.ScheduleMate.service;

import com.example.ScheduleMate.dto.FeedbackDto;

import java.util.List;

public interface FeedbackService {

    void createFeedback(FeedbackDto feedbackDto);

    List<FeedbackDto> getAllFeedbacks();

    FeedbackDto getFeedbackById(Long id);

    void updateFeedback(Long id, FeedbackDto feedbackDto);

    void deleteFeedback(Long id);
}
