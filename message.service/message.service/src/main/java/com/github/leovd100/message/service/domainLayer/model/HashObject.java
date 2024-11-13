package com.github.leovd100.message.service.domainLayer.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HashObject {
    private String name;
    private String email;
    private String hash;
    private String hashInfo;
}
