package com.pdp.gateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/check-gateway")
    public ResponseEntity<String> doCheck() {
        return ResponseEntity.ok("gateway works!");
    }
}
