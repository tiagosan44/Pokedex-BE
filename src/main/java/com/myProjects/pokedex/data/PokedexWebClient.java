package com.myProjects.pokedex.data;

import reactor.core.publisher.Mono;

public interface PokedexWebClient {

    Mono<String> getPokemons(Short offSet, Short limit);

    Mono<String> getPokemonById(Short pokemonId);

    Mono<String> getPokemonCharacteristics(Short pokemonId);
}
