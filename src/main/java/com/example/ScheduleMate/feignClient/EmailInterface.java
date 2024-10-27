package com.example.ScheduleMate.feignClient;


import com.example.ScheduleMate.dto.EmailDto;
import com.example.ScheduleMate.dto.EmailResponseDto;
import com.example.ScheduleMate.endpoints.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "EMAIL-SERVICE",url = "http://localhost:5001/api/send/mail")
public interface EmailInterface {

    @PostMapping()
    EmailResponseDto postMail(@RequestBody EmailDto emailDto);
}
