package com.prova.prova.periferico;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record PerifericoDTO(
        UUID id,

        @NotBlank(message = "O nome do periférico não pode ser vazio.")
        String nome
) {
}