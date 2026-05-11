package com.proyecto.Pokedex.Servicio;

import com.proyecto.Pokedex.Dominio.Equipo;
import com.proyecto.Pokedex.Repositorio.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServicio {
    @Autowired
    private EquipoRepositorio equipoRepositorio;

    // CREAR UN EQUIPO
    public Equipo crear(Equipo equipo){
        return equipoRepositorio.save(equipo);
    }

    // LISTAR LOS EQUIPOS
    public List<Equipo> listar(){
        return equipoRepositorio.findAll();
    }

    // BUSCAR UN EQUIPO
    public Equipo buscar(Long id){
        return equipoRepositorio.findById(id).orElse(null);
    }

    // BORRAR UN EQUIPO
    public void borrar(Long id){
        if(equipoRepositorio.existsById(id)){
            equipoRepositorio.deleteById(id);
        }else {
            System.out.println("No se encontro el registro");
        }
    }

    // MODIFICAR UN EQUIPO
    public Equipo modificar(Long id, Equipo equipoModificado){
        Equipo equipoViejo=equipoRepositorio.findById(id).orElse(null);
        // COMPRUEBO QUE EXISTE
        if(equipoViejo!=null){
            // COMPRUEBO QUE LOS NUEVOS CAMPOS NO SEAN NULL, Y SI LO SON MANTENGO LOS DATOS ANTERIORES
            if(!(equipoModificado.getPokemons()==null)){
                equipoViejo.setPokemons(equipoModificado.getPokemons());
            }
        }
        return equipoRepositorio.save(equipoViejo);
    }


}
