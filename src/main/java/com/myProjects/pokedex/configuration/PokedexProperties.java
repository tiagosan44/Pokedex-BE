package com.myProjects.pokedex.configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pokedex-config")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PokedexProperties {

    String apiURL;

    String localURL;

    String pokemonPath;

    String characteristicPath;
}