package com.prova.prova.computador;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputadorRepository extends JpaRepository<Computador, UUID> {
}
