package com.nerdy.timeapp.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "time-generator")
public interface TimeGeneratorFeign {

    @GetMapping("/get-time")
    String getEstimation();
}
