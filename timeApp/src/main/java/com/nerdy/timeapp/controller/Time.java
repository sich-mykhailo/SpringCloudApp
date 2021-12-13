package com.nerdy.timeapp.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface Time {
    @GetMapping("/estimation")
    String getEstimation();
}
