package com.github.leovd100.capture.system.infraestructureLayer.services;

import com.github.leovd100.capture.system.domainLayer.entities.Lead;

public interface SmsCommunicationService {

    void sendMessage(Lead lead);
}
