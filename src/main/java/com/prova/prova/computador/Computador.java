package com.prova.prova.computador;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prova.prova.periferico.Periferico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity(name = "Computador")
@Table(name = "computadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Computador {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String cor;
    @Column(name = "data_fabricacao")
    private Integer dataFabricacao;

    @OneToMany(mappedBy = "computador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Periferico> perifericos;

}
