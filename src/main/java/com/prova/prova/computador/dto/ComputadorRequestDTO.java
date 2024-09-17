package com.prova.prova.computador.dto;

import com.prova.prova.computador.Computador;
import com.prova.prova.periferico.Periferico;
import jakarta.validation.constraints.*;

import java.util.List;

public record ComputadorRequestDTO(

        @NotBlank(message = "O nome do PC não pode ser vazio.")
        @Size(max = 255, message = "O nome do PC não pode ter mais que 255 caracteres")
        String nome,

        @NotBlank(message = "A cor do PC não pode ser vazia.")
        @Size(max = 255, message = "A cor do PC não pode ter mais que 255 caracteres")
        String cor,

        @NotNull(message = "A data de fabricação não pode ser nula.")
        @Min(value = 1900, message = "A data de fabricação deve ser maior ou igual a 1900.")
        @Max(value = 2099, message = "A data de fabricação deve ser menor ou igual a 2099.")
        Integer dataFabricacao,

        @NotNull(message = "A lista de periféricos não pode ser nula.")
        List<Periferico> perifericos
) {

    public Computador toEntity() {
        Computador computador = new Computador(null,
                this.nome,
                this.cor,
                this.dataFabricacao,
                this.perifericos);

        for (Periferico periferico : this.perifericos) {
            periferico.setComputador(computador);
        }

        return computador;
    }
}