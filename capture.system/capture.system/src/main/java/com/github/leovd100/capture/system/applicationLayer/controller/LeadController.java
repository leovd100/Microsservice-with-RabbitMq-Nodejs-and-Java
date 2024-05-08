package com.github.leovd100.capture.system.applicationLayer.controller;


import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import com.github.leovd100.capture.system.domainLayer.dto.LeadResponseDto;
import com.github.leovd100.capture.system.applicationLayer.resources.LeadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/event-lead")
public class LeadController {
    @Autowired
    private LeadService leadService;


    @PostMapping
    public ResponseEntity<LeadResponseDto> saveLead(@RequestBody @Valid LeadDto leadDto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/")
                .buildAndExpand(leadDto).toUri();
        return ResponseEntity.created(uri).body(leadService.saveLead(leadDto));
    }

}
