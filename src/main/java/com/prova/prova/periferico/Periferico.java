package com.prova.prova.periferico;

import com.prova.prova.computador.Computador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "Periferico")
@Table(name = "perifericos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Periferico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;


    @ManyToOne
    @JoinColumn(name = "computador_id")
    private Computador computador;

    public void setComputador(Computador computador) {
        this.computador = computador;
    }
}
