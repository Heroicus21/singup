package com.code.app.singup.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonDTO {
    int accuracy;
    int power;
    PokemonTypeDTO pokemonTypeDTO;
}
