package com.prova.prova.computador.dto;

import com.prova.prova.periferico.Periferico;

import java.util.List;
import java.util.UUID;

public record ComputadorResponseDTO(
        UUID id,
        String nome,
        String cor,
        Integer dataFabricacao,
        List<Periferico> perifericos
) {
}
