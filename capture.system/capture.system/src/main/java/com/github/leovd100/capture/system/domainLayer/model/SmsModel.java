package com.github.leovd100.capture.system.domainLayer.model;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsModel {
    private String phoneNumber;
    private String name;
    private String message;
}
