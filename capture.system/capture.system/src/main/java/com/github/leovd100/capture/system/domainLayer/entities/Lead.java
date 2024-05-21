package com.github.leovd100.capture.system.domainLayer.entities;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lead implements Serializable {

    private String name;
    private String email;
    private String phone;

    public Lead(LeadDto leadDto){
        this.name = leadDto.getName();
        this.email = leadDto.getEmail();
        this.phone = leadDto.getPhone();
    }

}
