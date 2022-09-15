package com.code.app.singup.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDTO {
    int accuracy;
    int power;
    PokemonTypeDTO pokemonTypeDTO;
}
