package com.prova.prova.computador.dto;

import com.prova.prova.computador.Computador;
import com.prova.prova.periferico.Periferico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ComputadorRequestDTO(

        @NotBlank(message = "O nome do PC não pode ser vazio.")
        @Size(max = 255, message = "O nome do PC não pode ter mais que 255 caracteres")
        String nome,

        @NotBlank(message = "A cor do PC não pode ser vazia.")
        @Size(max = 255, message = "A cor do PC não pode ter mais que 255 caracteres")
        String cor,

        @NotNull(message = "A data de fabricação não pode ser nula.")
        @Pattern(regexp = "^(19|20)\\d{2}$", message = "A data de fabricação deve ser um ano válido (entre 1900 e 2099).")
        Integer dataFabricacao,

        @NotNull(message = "A lista de periféricos não pode ser nula.")
        List<Periferico> perifericos
) {

    public Computador toEntity() {
        return new Computador(null,
                this.nome,
                this.cor,
                this.dataFabricacao,
                this.perifericos);
    }
}
