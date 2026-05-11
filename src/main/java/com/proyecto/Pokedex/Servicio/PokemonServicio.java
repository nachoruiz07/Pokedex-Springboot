package com.proyecto.Pokedex.Servicio;

import com.proyecto.Pokedex.Dominio.Pokemon;
import com.proyecto.Pokedex.Repositorio.PokemonRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServicio {

    @Autowired
    private PokemonRepositorio  pokemonRepositorio;

    // CREAR POKEMON
    public Pokemon crear(Pokemon pokemon){
        return pokemonRepositorio.save(pokemon);
    }

    // LISTAR POKEMONS
    public List<Pokemon> listar(){
        return pokemonRepositorio.findAll();
    }

    // BUSCAR UN POKEMON
    public Pokemon buscar(Long id){
        return pokemonRepositorio.findById(id).orElse(null);
    }

    // BORRAR UN POKEMON
    public void borrar(Long id){
        if(pokemonRepositorio.existsById(id)){
            pokemonRepositorio.deleteById(id);
        }else{
            System.out.println("No se encontró el registro");
        }
    }

    // MODIFICAR UN POKEMON
    public Pokemon modificar(Long id, Pokemon pokemonModificado){
        Pokemon pokemonViejo = pokemonRepositorio.findById(id).orElse(null);
        // COMPRUEBO QUE EXISTE
        if(pokemonViejo != null){
            // COMPRUEBO QUE LOS NUEVOS CAMPOS NO SEAN NULL, Y SI LO SON MANTENGO LOS DATOS ANTERIORES
            if(pokemonModificado.getNombre()!=null){
                pokemonViejo.setNombre(pokemonModificado.getNombre());
            }
            if(pokemonModificado.getTipo()!=null){
                pokemonViejo.setTipo(pokemonModificado.getTipo());
            }
            if(pokemonModificado.getNivel()!=null){
                pokemonViejo.setNivel(pokemonModificado.getNivel());
            }
            if(pokemonModificado.getEquipo()!=null){
                pokemonViejo.setEquipo(pokemonModificado.getEquipo());
            }
        }
        return pokemonRepositorio.save(pokemonViejo);
    }
}
