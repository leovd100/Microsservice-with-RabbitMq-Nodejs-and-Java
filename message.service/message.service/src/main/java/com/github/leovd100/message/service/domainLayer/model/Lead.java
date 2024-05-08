package com.github.leovd100.message.service.domainLayer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lead {

    private UUID id;

    private String name;

    private String email;

    private String phone;
}
