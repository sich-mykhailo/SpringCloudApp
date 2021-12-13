package com.nerdy.timegenerator;

import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class TimeGeneratorApplication {
    @GetMapping("/get-time")
    public String getTime() {
        LocalDate currentTime = LocalDate.now();
        return currentTime.toString();
    }


    public static void main(String[] args) {
        SpringApplication.run(TimeGeneratorApplication.class, args);
    }

}
