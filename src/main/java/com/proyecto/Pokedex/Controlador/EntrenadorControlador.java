package com.proyecto.Pokedex.Controlador;

import com.proyecto.Pokedex.Dominio.Entrenador;
import com.proyecto.Pokedex.Servicio.EntrenadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorControlador {

    @Autowired
    private EntrenadorServicio entrenadorServicio;

    @PostMapping("/crear")
    public Entrenador entrenador(@RequestBody Entrenador entrenador) {
        return entrenadorServicio.crear(entrenador);
    }

    @GetMapping("/listar")
    public List<Entrenador> listar() {
        return entrenadorServicio.listar();
    }

    @GetMapping("/buscar/{id}")
    public Entrenador buscar(@PathVariable Long id) {
        return entrenadorServicio.buscar(id);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable Long id) {
        entrenadorServicio.borrar(id);
    }

    @PutMapping("/modificar/{id}")
    public Entrenador modificar(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        return entrenadorServicio.modificar(id, entrenador);
    }
}
