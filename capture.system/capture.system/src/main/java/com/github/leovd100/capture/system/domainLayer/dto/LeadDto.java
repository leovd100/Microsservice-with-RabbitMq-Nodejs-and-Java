package com.github.leovd100.capture.system.domainLayer.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeadDto {

    @NotEmpty(message = "Nome é obrigatório")
    private String name;
    @NotEmpty(message = "E-mail é obrigatório")
    private String email;
    @NotEmpty(message = "Telefone é obrigatório")
    private String phone;
}
