package com.github.leovd100.capture.system.domainLayer.entities;

import com.github.leovd100.capture.system.domainLayer.dto.LeadDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tb_lead")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    @Column(unique = true)
    private String email;

    private String phone;

    public Lead(LeadDto leadDto){
        this.name = leadDto.getName();
        this.email = leadDto.getEmail();
        this.phone = leadDto.getPhone();
    }

}
