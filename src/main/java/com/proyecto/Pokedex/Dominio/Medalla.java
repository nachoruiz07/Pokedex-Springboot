package com.proyecto.Pokedex.Dominio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medalla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    // MEDALLAS QUE POSEE EL ENTRENADOR ENTRENADOR - MEDALLAS M:1
    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    // ENTREGA DE MEDALLAS EN UN GIMNASIO GIMNASIO - MEDALLAS 1:M
    @ManyToOne
    @JoinColumn(name = "gimnasio_id")
    private Gimnasio gimnasio;
}
