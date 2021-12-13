package com.nerdy.timeapp.config;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TimeGeneratorCaller {
    private final RestTemplate restTemplate;

    public TimeGeneratorCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public String get() {
        return restTemplate.getForObject(
                "http://time-generator/get-time", String.class);
    }

    public String fallback() {
        return " I'm fallback method. The time-generator service is not available";
    }
}
