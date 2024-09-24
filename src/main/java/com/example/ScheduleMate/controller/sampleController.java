package com.example.ScheduleMate.controller;

import com.example.ScheduleMate.config.exception.ResourceNotFoundException;
import com.example.ScheduleMate.endpoints.APIResponse;
import com.example.ScheduleMate.service.SampleService;
import com.example.ScheduleMate.utils.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Null;

@RequestMapping("/sample")
@RestController
@RequiredArgsConstructor

public class sampleController {
    private final SampleService sampleService;

    @GetMapping("/sample")
    public ResponseEntity<APIResponse<String>> getSample(  @RequestParam("id") String id){
        String sample = sampleService.findSample(id);

        return ResponseEntity.ok(new APIResponse<>(ResponseCode.SUCCESS,sample));
    }
}
