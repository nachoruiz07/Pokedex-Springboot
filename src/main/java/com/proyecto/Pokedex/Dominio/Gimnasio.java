package com.proyecto.Pokedex.Dominio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Gimnasio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @Column(nullable = false)
    @NotBlank(message = "La ciudad es la obligatoria")
    private String ciudad;
    @Column(nullable = false)
    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;

    // ENTREGA DE MEDALLAS EN UN GIMNASIO GIMNASIO - MEDALLAS 1:M
    @OneToMany(mappedBy = "gimnasio")
    private List<Medalla> medallas;

    // EL LIDER DEL GIMNASIO GIMNASIO - ENTRENADOR 1:1
    @OneToOne
    @JoinColumn(name = "lider_id")
    private Entrenador entrenador;

}
