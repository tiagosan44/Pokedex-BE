package com.myProjects.pokedex.service.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PokemonDTO {

    Short id;

    String name;

    String imgURL;

    Short weight;

    Short height;

    List<String> types;

    List<String> abilities;

    List<StatDTO> statDTOS;

//    List<Pokemon> evolutions;
}
