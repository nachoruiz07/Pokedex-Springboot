package com.proyecto.Pokedex.Controlador;

import com.proyecto.Pokedex.Dominio.Equipo;
import com.proyecto.Pokedex.Servicio.EquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipo")
public class EquipoControlador {

    @Autowired
    private EquipoServicio equipoServicio;

    @PostMapping("/crear")
    public Equipo equipo(@RequestBody Equipo equipo) {
        return equipoServicio.crear(equipo);
    }

    @GetMapping("/listar")
    public List<Equipo> listar() {
        return equipoServicio.listar();
    }

    @GetMapping("/buscar/{id}")
    public Equipo buscar(@PathVariable Long id) {
        return equipoServicio.buscar(id);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable Long id) {
        equipoServicio.borrar(id);
    }

    @PutMapping("/modificar/{id}")
    public Equipo modificar(@PathVariable Long id, @RequestBody Equipo equipo) {
        return equipoServicio.modificar(id, equipo);
    }
}
