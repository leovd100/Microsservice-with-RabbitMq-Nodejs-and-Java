package com.github.leovd100.capture.system.domainLayer.model;

import com.github.leovd100.capture.system.domainLayer.enums.TypeMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageModel {
    private UUID id;
    private TypeMessage typeMessage;
    private String contactValue;
}
