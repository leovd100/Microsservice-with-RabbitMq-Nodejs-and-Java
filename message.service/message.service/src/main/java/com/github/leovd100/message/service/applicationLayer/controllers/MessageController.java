package com.github.leovd100.message.service.applicationLayer.controllers;

import com.github.leovd100.message.service.applicationLayer.components.ProcessData;
import com.github.leovd100.message.service.domainLayer.dto.LeadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send-message")
public class MessageController {

    private final ProcessData processData;

    @Autowired
    public MessageController(ProcessData processData) {
        this.processData = processData;

    }

    @PostMapping
    public ResponseEntity<Void> registrationNewUsers(@RequestBody LeadDto leadDto){
        processData.sendDto(leadDto);
        return ResponseEntity.ok().build();
    }

}
