package com.myProjects.pokedex.service;

import com.myProjects.pokedex.model.Page;
import com.myProjects.pokedex.model.Pokemon;

public interface PokedexService {

    Page getPokemons(Short offSet, Short limit);

    Pokemon getPokemonById(Short pokemonId);
}
