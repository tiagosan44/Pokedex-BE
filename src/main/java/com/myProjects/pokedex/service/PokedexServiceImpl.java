package com.myProjects.pokedex.service;

import com.jayway.jsonpath.JsonPath;
import com.myProjects.pokedex.data.PokedexWebClient;
import com.myProjects.pokedex.model.Page;
import com.myProjects.pokedex.model.Pokemon;
import com.myProjects.pokedex.utils.Mapper;
import com.myProjects.pokedex.utils.TextUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PokedexServiceImpl implements PokedexService {

    PokedexWebClient pokedexWebClient;

    TextUtils textUtils;

    @Override
    public Page getPokemons(final Short offSet, final Short limit) {
        final Mapper<Page> mapperPage = new Mapper<>();
        final String response = pokedexWebClient
                                    .getPokemons(offSet, limit).block();
        final Page page = mapperPage.mapResponse(response, Page.class);
        textUtils.replacePageURLS(page);
        return page;
    }

    @Override
    public Pokemon getPokemonById(final Short pokemonId) {
        final Mapper<Pokemon> mapperPokemon = new Mapper<>();
        final String response = pokedexWebClient.getPokemonById(pokemonId).block();
        final Pokemon pokemon = mapperPokemon.mapResponse(response, Pokemon.class);
        textUtils.formatPokemonData(pokemon);
        getPokemonDescription(pokemon);
        return pokemon;
    }

    private void getPokemonDescription(final Pokemon pokemon) {
        final String response = pokedexWebClient.getPokemonCharacteristics(pokemon.getId()).block();
        Optional.ofNullable(response)
                .filter(r -> !r.isEmpty())
                .ifPresent(r -> {
                    final JSONArray descriptionJson = JsonPath.read(response,
                        "$.descriptions[?(@.language.name == 'en')].description");
                    final String description = (String) descriptionJson.stream().findFirst().orElse(null);
                    pokemon.setDescription(description);
                });

    }
}
