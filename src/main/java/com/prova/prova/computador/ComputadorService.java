package com.prova.prova.computador;

import com.prova.prova.computador.dto.ComputadorRequestDTO;
import com.prova.prova.computador.dto.ComputadorResponseDTO;
import com.prova.prova.computador.dto.ComputadorUpdateDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComputadorService {

    private final ComputadorRepository repository;

    @Transactional
    public ComputadorResponseDTO create(ComputadorRequestDTO computadorRequest) {
        Computador novoComputador = computadorRequest.toEntity();
        Computador salvo = repository.save(novoComputador);
        return new ComputadorResponseDTO(salvo.getId(), salvo.getNome(), salvo.getCor(), salvo.getDataFabricacao(), salvo.getPerifericos());
    }

    @Transactional
    public ComputadorResponseDTO findById(UUID id) {
        Computador computador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Computador não encontrado!"));
        return new ComputadorResponseDTO(computador.getId(), computador.getNome(), computador.getCor(), computador.getDataFabricacao(), computador.getPerifericos());
    }

    @Transactional
    public List<ComputadorResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(computador -> new ComputadorResponseDTO(computador.getId(), computador.getNome(), computador.getCor(), computador.getDataFabricacao(), computador.getPerifericos()))
                .collect(Collectors.toList());
    }

    @Transactional
    public ComputadorResponseDTO update(UUID id, ComputadorUpdateDTO computadorUpdate) {
        Computador computadorExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Computador não encontrado!"));

        computadorExistente.setNome(computadorUpdate.nome());
        computadorExistente.setCor(computadorUpdate.cor());

        Computador atualizado = repository.save(computadorExistente);
        return new ComputadorResponseDTO(atualizado.getId(), atualizado.getNome(), atualizado.getCor(), atualizado.getDataFabricacao(), atualizado.getPerifericos());
    }

    @Transactional
    public void delete(UUID id) {
        Computador computador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Computador não encontrado!"));
        repository.delete(computador);
    }
}
