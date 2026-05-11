package com.proyecto.Pokedex.Servicio;

import com.proyecto.Pokedex.Dominio.Gimnasio;
import com.proyecto.Pokedex.Repositorio.GimnasioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GimnasioServicio {

    @Autowired
    private GimnasioRepositorio gimnasioRepositorio;

    // CREAR UN GIMNASIO
    public Gimnasio crear (Gimnasio gimnasio){
        return gimnasioRepositorio.save(gimnasio);
    }

    // LISTAR GIMNASIOS
    public List<Gimnasio> listar(){
        return gimnasioRepositorio.findAll();
    }

    // BUSCAR UN GIMNASIO
    public Gimnasio buscar(Long id){
        return gimnasioRepositorio.findById(id).orElse(null);
    }

    // BORRAR UN GIMNASIO
    public void borrar(Long id){
        if(gimnasioRepositorio.existsById(id)) {
            gimnasioRepositorio.deleteById(id);
        }else {
            System.out.println("No se encontro el registro");
        }
    }

    // MODIFICAR UN GIMNASIO
    public Gimnasio modificar(Long id, Gimnasio gimnasioModificado){
        Gimnasio gimnasioViejo = gimnasioRepositorio.findById(id).orElse(null);
        // COMPRUEBO QUE EXISTE
        if(gimnasioViejo!=null){
            // COMPRUEBO QUE LOS NUEVOS CAMPOS NO SEAN NULL, Y SI LO SON MANTENGO LOS DATOS ANTERIORES
            if(gimnasioModificado.getNombre()!=null){
                gimnasioViejo.setNombre(gimnasioModificado.getNombre());
            }
            if(gimnasioModificado.getCiudad()!=null){
                gimnasioViejo.setCiudad(gimnasioModificado.getCiudad());
            }
            if(gimnasioModificado.getTipo()!=null){
                gimnasioViejo.setTipo(gimnasioModificado.getTipo());
            }
            if(gimnasioModificado.getEntrenador()!=null){
                gimnasioViejo.setEntrenador(gimnasioModificado.getEntrenador());
            }
        }
        return gimnasioRepositorio.save(gimnasioModificado);
    }
}
