package com.myProjects.pokedex.utils;

import com.myProjects.pokedex.configuration.PokedexProperties;
import com.myProjects.pokedex.model.Page;
import com.myProjects.pokedex.model.Pokemon;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TextUtils {

    PokedexProperties pokedexProperties;

    public void formatPokemonData(final Pokemon pokemon) {
        pokemon.setName(capitalize(pokemon.getName()));
        pokemon.getAbilities().forEach(a -> a.getAbility().setName(capitalize(a.getAbility().getName())));
        pokemon.getTypes().forEach(t -> t.getType().setName(capitalize(t.getType().getName())));
        pokemon.getStats().forEach(s -> s.getStat().setName(capitalize(s.getStat().getName())));
    }

    public void replacePageURLS(final Page page) {
        page.getResults().forEach(r -> r.setUrl(this.replaceURL(r.getUrl())));
        page.setNext(this.replaceURL(page.getNext()));
        page.setPrevious(page.getPrevious() != null ? this.replaceURL(page.getPrevious()) : null);
    }

    private String capitalize(final String text) {
        return text == null || text.isEmpty() ? text
            : text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    private String replaceURL(final String url) {
        return url.replace(pokedexProperties.getApiURL(), pokedexProperties.getLocalURL());
    }
}
