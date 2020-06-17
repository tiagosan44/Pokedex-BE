package com.myProjects.pokedex.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "next",
        "previous",
        "results"
})
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Page {

    @JsonProperty("count")
    Long count;

    @JsonProperty("next")
    String next;

    @JsonProperty("previous")
    String previous;

    @JsonProperty("results")
    List<Result> results = new ArrayList<>();
}