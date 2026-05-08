package com.proyecto.Pokedex.Repositorio;

import com.proyecto.Pokedex.Dominio.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepositorio extends JpaRepository<Pokemon, Long> {
}
