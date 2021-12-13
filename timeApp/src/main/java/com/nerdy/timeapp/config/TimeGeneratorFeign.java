package com.nerdy.timeapp.config;

import com.nerdy.timeapp.controller.Time;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("time-generator")
public interface TimeGeneratorFeign extends Time {
}
