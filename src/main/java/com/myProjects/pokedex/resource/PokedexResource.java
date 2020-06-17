package com.myProjects.pokedex.resource;

import com.myProjects.pokedex.model.Page;
import com.myProjects.pokedex.model.Pokemon;
import com.myProjects.pokedex.service.PokedexService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PokedexResource {

    PokedexService pokedexService;

    @GetMapping(value = "/pokemon")
    public ResponseEntity<Page> getPokemons(
            @RequestParam(value = "offset") @Nullable final Short offSet,
            @RequestParam @Nullable final Short limit) {
        return ResponseEntity.ok(pokedexService.getPokemons(offSet, limit));
    }

    @GetMapping(value = "/pokemon/{pokemonId}")
    public ResponseEntity<Pokemon> getEmployeeById(@PathVariable final short pokemonId) {
        return ResponseEntity.ok(pokedexService.getPokemonById(pokemonId));
    }
}
