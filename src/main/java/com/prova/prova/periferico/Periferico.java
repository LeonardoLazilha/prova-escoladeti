package com.prova.prova.periferico;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prova.prova.computador.Computador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


    @Setter
    @ManyToOne
    @JoinColumn(name = "computador_id")
    @JsonBackReference
    private Computador computador;

}
