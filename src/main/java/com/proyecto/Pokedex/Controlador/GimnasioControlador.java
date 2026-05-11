package com.proyecto.Pokedex.Controlador;

import com.proyecto.Pokedex.Dominio.Gimnasio;
import com.proyecto.Pokedex.Servicio.GimnasioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gimnasio")
public class GimnasioControlador {
    @Autowired
    private GimnasioServicio gimnasioServicio;

    @PostMapping("/crear")
        public Gimnasio equipo(@RequestBody Gimnasio gimnasio) {
        return gimnasioServicio.crear(gimnasio);
    }

    @GetMapping("/listar")
    public List<Gimnasio> listar() {
        return gimnasioServicio.listar();
    }

    @GetMapping("/buscar/{id}")
    public Gimnasio buscar(@PathVariable Long id) {
        return gimnasioServicio.buscar(id);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable Long id) {
        gimnasioServicio.borrar(id);
    }

    @PutMapping("/modificar/{id}")
    public Gimnasio modificar(@PathVariable Long id, @RequestBody Gimnasio gimnasio) {
        return gimnasioServicio.modificar(id, gimnasio);
    }
}
