package com.nerdy.timeapp.controller;

import com.nerdy.timeapp.config.TimeGeneratorCaller;
import com.nerdy.timeapp.config.TimeGeneratorFeign;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableHystrix
public class TimeController {
    private final TimeGeneratorCaller timeGeneratorCaller;
    private final TimeGeneratorFeign timeGeneratorFeign;

    public TimeController(TimeGeneratorCaller timeGeneratorCaller, TimeGeneratorFeign timeGeneratorFeign) {
        this.timeGeneratorCaller = timeGeneratorCaller;
        this.timeGeneratorFeign = timeGeneratorFeign;
    }

    @GetMapping("/estimation")
    public String getEstimation() {
        return timeGeneratorCaller.get();
    }

    @GetMapping("/estimation-with-feign")
    public String getFeignEstimation() {
        return timeGeneratorFeign.getEstimation();
    }
}
