package com.proyecto.Pokedex.Dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // EQUIPO DE POKEMONS ENTRENADOR - EQUIPO 1:1
    @OneToMany(mappedBy = "equipo")
    @JsonIgnore
    private List<Pokemon> pokemons;


}
