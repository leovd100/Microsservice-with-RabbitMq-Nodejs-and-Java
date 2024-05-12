package com.github.leovd100.message.service.domainLayer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record LeadDto(@NotEmpty(message = "Nome é obrigatório")
                      @Schema(example = "Nome") String name, @NotEmpty(message = "E-mail é obrigatório")
                      @Schema(example = "email@youremail.com")
                      @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email cannot valid format")
                      String email, @NotEmpty(message = "Telefone é obrigatório")
                      @Schema(example = "Telefone")String phone) {
}
