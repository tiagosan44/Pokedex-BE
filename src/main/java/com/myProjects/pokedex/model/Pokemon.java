package com.myProjects.pokedex.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "abilities",
        "base_experience",
        "height",
        "id",
        "is_default",
        "location_area_encounters",
        "name",
        "order",
        "sprites",
        "stats",
        "types",
        "weight"
})
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pokemon {

    @JsonProperty("abilities")
    List<Ability> abilities = null;

    @JsonProperty("base_experience")
    Short baseExperience;

    @JsonProperty("height")
    Short height;

    @JsonProperty("id")
    Short id;

    @JsonProperty("location_area_encounters")
    String locationAreaEncounters;

    @JsonProperty("name")
    String name;

    @JsonProperty("order")
    Short order;

    @JsonProperty("sprites")
    Sprites sprites;

    @JsonProperty("stats")
    List<Stat> stats = null;

    @JsonProperty("types")
    List<Type> types = null;

    @JsonProperty("weight")
    Short weight;

    @JsonProperty("description")
    String description;
}