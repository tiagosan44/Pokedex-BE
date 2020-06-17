package com.myProjects.pokedex.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Mapper<T> {

    ObjectMapper objectMapper = new ObjectMapper();

    public T mapResponse(final String response, final Class<T> scopeClass) {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(response, scopeClass);
        } catch (IOException e) {
            log.error("Error obtaining pokemons response {}:", e.getMessage());
        }
        return null;
    }
}