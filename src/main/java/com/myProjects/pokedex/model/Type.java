package com.myProjects.pokedex.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "slot",
        "type"
})
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Type {

    @JsonProperty("slot")
    Long slot;

    @JsonProperty("type")
    Type_ type;
}