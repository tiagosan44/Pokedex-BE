package com.myProjects.pokedex.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "base_stat",
        "effort",
        "stat"
})
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stat {

    @JsonProperty("base_stat")
    Long baseStat;

    @JsonProperty("effort")
    Long effort;

    @JsonProperty("stat")
    Stat_ stat;
}