package com.github.leovd100.capture.system.applicationLayer.controller;


import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.builder.LeadResponseDto;
import com.github.leovd100.capture.system.applicationLayer.resources.LeadService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/event-lead")
public class LeadController {

    Logger logger = LogManager.getLogger(LeadController.class);
    @Autowired
    private LeadService leadService;

    @PostMapping
    @Operation(summary = "Send a customer for the service message")
    public ResponseEntity<LeadResponseDto> customerCapture(@RequestBody @Valid LeadDto leadDto) {
        logger.info("Receiving information from a new customer");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/")
                .buildAndExpand(leadDto).toUri();
        return ResponseEntity.created(uri).body(leadService.sendData(leadDto));
    }

}
