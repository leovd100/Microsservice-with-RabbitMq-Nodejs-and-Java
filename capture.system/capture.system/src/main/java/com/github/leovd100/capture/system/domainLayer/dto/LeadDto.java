package com.github.leovd100.capture.system.domainLayer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeadDto {

    @NotEmpty(message = "Nome é obrigatório")
    @Schema(example = "Nome")
    private String name;
    @NotEmpty(message = "E-mail é obrigatório")
    @Schema(example = "email@youremail.com")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email cannot valid format")
    private String email;
    @NotEmpty(message = "Telefone é obrigatório")
    @Schema(example = "Telefone")
    private String phone;
}
