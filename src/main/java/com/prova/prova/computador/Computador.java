package com.prova.prova.computador;

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

    @OneToMany(mappedBy = "computador", cascade = CascadeType.ALL)
    private List<Periferico> perifericos;

    public void addPeriferico(Periferico periferico) {
        perifericos.add(periferico);
        periferico.setComputador(this);
    }

    public void removePeriferico(Periferico periferico) {
        perifericos.remove(periferico);
        periferico.setComputador(null);
    }


}
