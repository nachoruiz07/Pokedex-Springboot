package com.proyecto.Pokedex.Controlador;

import com.proyecto.Pokedex.Dominio.Medalla;
import com.proyecto.Pokedex.Servicio.MedallaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medalla")
public class MedallaControlador {
    @Autowired
    private MedallaServicio medallaServicio;

    @PostMapping("/crear")
    public Medalla equipo(@RequestBody Medalla medalla) {
        return medallaServicio.crear(medalla);
    }

    @GetMapping("/listar")
    public List<Medalla> listar() {
        return medallaServicio.listar();
    }

    @GetMapping("/buscar/{id}")
    public Medalla buscar(@PathVariable Long id) {
        return medallaServicio.buscar(id);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrar(@PathVariable Long id) {
        medallaServicio.borrar(id);
    }

    @PutMapping("/modificar/{id}")
    public Medalla modificar(@PathVariable Long id, @RequestBody Medalla medalla) {
        return medallaServicio.modificar(id, medalla);
    }
}
