package com.proyecto.Pokedex.Config;

import com.proyecto.Pokedex.Dominio.*;
import com.proyecto.Pokedex.Repositorio.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PokemonRepositorio pokemonRepositorio;
    private final EntrenadorRepositorio entrenadorRepositorio;
    private final EquipoRepositorio equipoRepositorio;
    private final GimnasioRepositorio gimnasioRepositorio;
    private final MedallaRepositorio medallaRepositorio;

    public DataLoader(PokemonRepositorio pokemonRepositorio,
                      EntrenadorRepositorio entrenadorRepositorio,
                      EquipoRepositorio equipoRepositorio,
                      GimnasioRepositorio gimnasioRepositorio,
                      MedallaRepositorio medallaRepositorio) {

        this.pokemonRepositorio = pokemonRepositorio;
        this.entrenadorRepositorio = entrenadorRepositorio;
        this.equipoRepositorio = equipoRepositorio;
        this.gimnasioRepositorio = gimnasioRepositorio;
        this.medallaRepositorio = medallaRepositorio;
    }

    @Override
    public void run(String... args) {

        if (pokemonRepositorio.count() == 0) {

            Equipo equipo1 = equipoRepositorio.save(new Equipo());
            Equipo equipo2 = equipoRepositorio.save(new Equipo());

            Pokemon pikachu = pokemonRepositorio.save(new Pokemon(null, "Pikachu", "Electrico", 25, null, equipo1));
            Pokemon charizard = pokemonRepositorio.save(new Pokemon(null, "Charizard", "Fuego", 36, null, equipo1));

            Pokemon staryu = pokemonRepositorio.save(new Pokemon(null, "Staryu", "Agua", 22, null, equipo2));
            Pokemon psyduck = pokemonRepositorio.save(new Pokemon(null, "Psyduck", "Agua", 18, null, equipo2));

            Entrenador ash = entrenadorRepositorio.save(new Entrenador(null, "Ash", 15, "Pueblo Paleta", pikachu, equipo1, null, null));
            Entrenador misty = entrenadorRepositorio.save(new Entrenador(null, "Misty", 16, "Ciudad Celeste", staryu, equipo2, null, null));

            Gimnasio gimnasio = gimnasioRepositorio.save(new Gimnasio(null, "Gimnasio Celeste", "Ciudad Celeste", "Agua", null, misty));

            medallaRepositorio.save(new Medalla(null, "Medalla Cascada", ash, gimnasio));
        }
    }
}