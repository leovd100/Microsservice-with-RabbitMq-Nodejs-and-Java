package com.github.leovd100.message.service.applicationLayer.controllers;

import com.github.leovd100.message.service.applicationLayer.services.SendMessageService;
import com.github.leovd100.message.service.applicationLayer.services.impl.SendMessegeServiceImpl;
import com.github.leovd100.message.service.domainLayer.model.Lead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send-message")
public class MessageController {

    private final SendMessageService service;

    @Autowired
    public MessageController(SendMessegeServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> receiveMessageForNewUsers(@RequestBody Lead lead){
        service.sendMessages(lead);
        return ResponseEntity.ok().build();
    }

}
