package com.proyecto.Pokedex.Repositorio;

import com.proyecto.Pokedex.Dominio.Entrenador;
import com.proyecto.Pokedex.Dominio.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepositorio extends JpaRepository<Equipo, Long> {
}
