package com.nerdy.timeapp.controller;

import com.nerdy.timeapp.config.TimeGeneratorCaller;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableHystrix
public class TimeController implements Time {
    private final TimeGeneratorCaller timeGeneratorCaller;

    public TimeController(TimeGeneratorCaller timeGeneratorCaller) {
        this.timeGeneratorCaller = timeGeneratorCaller;
    }

    @GetMapping("/estimation")
    @Override
    public String getEstimation() {
        return timeGeneratorCaller.get();
    }
}
