package com.github.leovd100.capture.system.applicationLayer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class CheckServerController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping
    public ResponseEntity<String> serverUp() {
            return ResponseEntity.ok("Server up in " + serverPort);
    }
}
