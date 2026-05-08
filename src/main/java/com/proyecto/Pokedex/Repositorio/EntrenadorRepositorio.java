package com.proyecto.Pokedex.Repositorio;

import com.proyecto.Pokedex.Dominio.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepositorio extends JpaRepository<Entrenador, Long> {
}
