package com.proyecto.Pokedex.Servicio;

import com.proyecto.Pokedex.Dominio.Entrenador;
import com.proyecto.Pokedex.Repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServicio {
    @Autowired
    private EntrenadorRepositorio  entrenadorRepositorio;

    // CREAR UN ENTRENADOR
    public Entrenador crear(Entrenador entrenador) {
        return entrenadorRepositorio.save(entrenador);
    }

    // LISTAR ENTRENADORES
    public List<Entrenador> listar() {
        return entrenadorRepositorio.findAll();
    }

    // BUSCAR UN ENTRENADOR
    public Entrenador buscar(Long id){
        return entrenadorRepositorio.findById(id).orElse(null);
    }

    // BORRAR UN ENTRENADOR
    public void borrar(Long id){
        if(entrenadorRepositorio.existsById(id)) {
            entrenadorRepositorio.deleteById(id);
        }else {
            System.out.println("No existe el entrenador con el id: " + id);
        }
    }

    // MODIFICAR UN ENTRENADOR
    public Entrenador modificar(Long id, Entrenador entrenador_modificado) {
    Entrenador entrenador_viejo = entrenadorRepositorio.findById(id).orElse(null);
    // COMPRUEBO QUE EXISTE
    if(entrenador_viejo != null){
        // COMPRUEBO QUE LOS NUEVOS CAMPOS NO SEAN NULL, Y SI LO SON MANTENGO LOS DATOS ANTERIORES
        if(!(entrenador_modificado.getCiudad()== null)){
            entrenador_viejo.setCiudad(entrenador_modificado.getCiudad());
        }
        if(!(entrenador_modificado.getNombre()== null)){
            entrenador_viejo.setNombre(entrenador_modificado.getNombre());
        }
        if(!(entrenador_modificado.getEdad()== null)){
            entrenador_viejo.setEdad(entrenador_modificado.getEdad());
        }
        if(!(entrenador_modificado.getEquipo()== null)){
            entrenador_viejo.setEquipo(entrenador_modificado.getEquipo());
        }
        if(!(entrenador_modificado.getPokemon_favorito()== null)){
            entrenador_viejo.setPokemon_favorito(entrenador_modificado.getPokemon_favorito());
        }
        if(!(entrenador_modificado.getEquipo()== null)){
            entrenador_viejo.setEquipo(entrenador_modificado.getEquipo());
        }

    }
    return entrenadorRepositorio.save(entrenador_viejo);
    }
}
