package com.proyecto.Pokedex.Dominio;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @Column(nullable = false)
    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;
    @Column(nullable = false)
    @NotBlank(message = "El nivel es obligatorio")
    @Min(1)
    @Max(100)
    private Integer nivel;

    // POKEMON FAVORITO ENTRENADOR - POKEMON 1:1
    @OneToOne(mappedBy = "pokemonFavorito")
    private Entrenador entrenador;

    // POKEMON EN EQUIPO POKEMON - EQUIPO M:1
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;
}
