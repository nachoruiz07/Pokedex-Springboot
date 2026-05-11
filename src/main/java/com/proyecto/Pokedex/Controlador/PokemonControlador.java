package com.proyecto.Pokedex.Controlador;

import com.proyecto.Pokedex.Dominio.Pokemon;
import com.proyecto.Pokedex.Servicio.PokemonServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonControlador {
    @Autowired
    private PokemonServicio pokemonServicio;

    @PostMapping("/crear")
    public Pokemon equipo(@RequestBody Pokemon pokemon) {
        return pokemonServicio.crear(pokemon);
    }

    @GetMapping("/listar")
    public List<Pokemon> listar() {
        return pokemonServicio.listar();
    }

    @GetMapping("/buscar/{id}")
    public Pokemon buscar(@PathVariable Long id) {
        return pokemonServicio.buscar(id);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable Long id) {
        pokemonServicio.borrar(id);
    }

    @PutMapping("/modificar/{id}")
    public Pokemon modificar(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonServicio.modificar(id, pokemon);
    }
}
