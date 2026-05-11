package com.proyecto.Pokedex.Servicio;

import com.proyecto.Pokedex.Dominio.Medalla;
import com.proyecto.Pokedex.Repositorio.MedallaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedallaServicio {
    @Autowired
    private MedallaRepositorio medallaRepositorio;

    // CREAR MEDALLA
    public Medalla crear (Medalla medalla){
        return medallaRepositorio.save(medalla);
    }

    // LISTAR MEDALLAS
    public List<Medalla> listar(){
        return medallaRepositorio.findAll();
    }

    // BUSCAR MEDALLA
    public Medalla buscar(Long id){
        return medallaRepositorio.findById(id).orElse(null);
    }

    // BORRAR MEDALLA
    public void borrar(Long id){
        if(medallaRepositorio.existsById(id)){
            medallaRepositorio.deleteById(id);
        }else {
            System.out.println("No se encontró el registro");
        }
    }

    // MODIFICAR UNA MEDALLA
    public Medalla modificar(Long id, Medalla medallaModificada){
        Medalla medallaVieja = medallaRepositorio.findById(id).orElse(null);
        // COMPRUEBO QUE EXISTE
        if(medallaVieja!=null) {
            // COMPRUEBO QUE LOS NUEVOS CAMPOS NO SEAN NULL, Y SI LO SON MANTENGO LOS DATOS ANTERIORES
            if(medallaModificada.getNombre()!=null){
                medallaVieja.setNombre(medallaModificada.getNombre());
            }
            if(medallaModificada.getEntrenador()!=null){
                medallaVieja.setEntrenador(medallaModificada.getEntrenador());
            }
            if(medallaModificada.getGimnasio()!=null){
                medallaVieja.setGimnasio(medallaModificada.getGimnasio());
            }
        }
        return medallaRepositorio.save(medallaVieja);
    }

}
