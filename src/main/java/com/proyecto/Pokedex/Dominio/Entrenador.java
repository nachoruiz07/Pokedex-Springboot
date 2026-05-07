package com.proyecto.Pokedex.Dominio;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @Column(nullable = false)
    @Min(0)
    @NotBlank(message = "La edad es obligatoria")
    private Integer edad;
    @Column(nullable = false)
    @NotBlank(message = "La ciudad es obligatoria")
    private String ciudad;

    // POKEMON FAVORITO ENTRENADOR - POKEMON 1:1
    @OneToOne
    @JoinColumn(name = "pokemon_favorito_id")
    private Pokemon pokemon_favorito;

    // EQUIPO DE POKEMONS ENTRENADOR - EQUIPO 1:1
    @OneToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    // MEDALLAS QUE POSEE EL ENTRENADOR ENTRENADOR - MEDALLAS 1:M
    @Column(nullable = true)
    @OneToMany
    @JoinColumn(name = "medallas_id")
    private List<Medalla> medallas;
}
