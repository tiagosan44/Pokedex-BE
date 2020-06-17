package com.myProjects.pokedex.service;

import com.myProjects.pokedex.data.PokedexWebClient;
import com.myProjects.pokedex.utils.TextUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.anyShort;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
class PokedexServiceImplTest {

    @Mock
    PokedexWebClient pokedexWebClient;

    @Mock
    TextUtils textUtils;

    @InjectMocks
    PokedexServiceImpl pokedexService;

    @BeforeEach
    void setUp() {
        pokedexService = new PokedexServiceImpl(pokedexWebClient, textUtils);
    }

    @Test
    void shouldGetPokemons() {
        given(pokedexWebClient.getPokemons(anyShort(), anyShort())).willReturn(Mono.just(""));

        pokedexService.getPokemons(anyShort(), anyShort());

        then(pokedexWebClient).should(times(1)).getPokemons(anyShort(), anyShort());
    }
}
