package com.myProjects.pokedex.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ability",
        "is_hidden",
        "slot"
})
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ability {

    @JsonProperty("ability")
    Ability_ ability;

    @JsonProperty("is_hidden")
    Boolean isHidden;

    @JsonProperty("slot")
    Long slot;
}