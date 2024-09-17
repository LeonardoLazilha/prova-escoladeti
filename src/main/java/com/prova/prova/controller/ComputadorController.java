package com.prova.prova.controller;

import com.prova.prova.computador.Computador;
import com.prova.prova.computador.ComputadorService;
import com.prova.prova.computador.dto.ComputadorRequestDTO;
import com.prova.prova.computador.dto.ComputadorResponseDTO;
import com.prova.prova.computador.dto.ComputadorUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/computador")
@RequiredArgsConstructor
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class ComputadorController {

    private final ComputadorService service;

    @PostMapping
    public ResponseEntity<ComputadorResponseDTO> create(@RequestBody @Validated ComputadorRequestDTO computadorRequest) {
        ComputadorResponseDTO response = service.create(computadorRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ComputadorResponseDTO>> findAll() {
        List<ComputadorResponseDTO> computadores = service.findAll();
        return ResponseEntity.ok(computadores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComputadorResponseDTO> update(@PathVariable UUID id, @RequestBody @Validated ComputadorUpdateDTO computadorUpdate) {
        ComputadorResponseDTO response = service.update(id, computadorUpdate);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
