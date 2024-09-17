package com.prova.prova.computador.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ComputadorUpdateDTO(

        @NotBlank(message = "O nome do PC não pode ser vazio.")
        @Size(max = 255, message = "O nome do PC não pode ter mais que 255 caracteres.")
        String nome,

        @NotBlank(message = "A cor do PC não pode ser vazia.")
        @Size(max = 255, message = "A cor do PC não pode ter mais que 255 caracteres.")
        String cor
) {
}
