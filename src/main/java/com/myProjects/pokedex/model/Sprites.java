package com.myProjects.pokedex.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "back_default",
        "back_female",
        "back_shiny",
        "back_shiny_female",
        "front_default",
        "front_female",
        "front_shiny",
        "front_shiny_female"
})
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sprites {

    @JsonProperty("back_default")
    String backDefault;

    @JsonProperty("back_female")
    Object backFemale;

    @JsonProperty("back_shiny")
    String backShiny;

    @JsonProperty("back_shiny_female")
    Object backShinyFemale;

    @JsonProperty("front_default")
    String frontDefault;

    @JsonProperty("front_female")
    Object frontFemale;

    @JsonProperty("front_shiny")
    String frontShiny;

    @JsonProperty("front_shiny_female")
    Object frontShinyFemale;
}