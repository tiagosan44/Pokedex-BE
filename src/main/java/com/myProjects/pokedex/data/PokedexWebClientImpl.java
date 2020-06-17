package com.myProjects.pokedex.data;

import com.myProjects.pokedex.configuration.PokedexProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PokedexWebClientImpl implements PokedexWebClient{

    @Qualifier("pokedexWebClient")
    WebClient webClient;

    PokedexProperties pokedexProperties;

    @Override
    public Mono<String> getPokemons(final Short offSet, final Short limit) {
        return webClient
                .get()
                .uri(ub -> ub.path(pokedexProperties.getPokemonPath())
                            .queryParam("offset", offSet)
                            .queryParam("limit", limit)
                            .build())
                .retrieve()
                .bodyToMono(String.class);
    }

    @Override
    public Mono<String> getPokemonById(final Short pokemonId) {
        return webClient
                .get()
                .uri(ub -> ub.path(pokedexProperties.getPokemonPath()
                        + "/" + pokemonId).build())
                .retrieve()
                .bodyToMono(String.class);
    }

    @Override
    public Mono<String> getPokemonCharacteristics(final Short pokemonId) {
        return webClient
                .get()
                .uri(ub -> ub.path(pokedexProperties.getCharacteristicPath()
                        + "/" + pokemonId).build())
                .retrieve()
                .bodyToMono(String.class)
                .onErrorReturn("");
    }
}
