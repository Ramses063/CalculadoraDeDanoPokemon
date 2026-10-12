package com.Ramses063.calculadoradedaopokemon.logica

import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Naturalezas
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Pokemon

data class CambioStatsNaturaleza(

    val ataque: Double,
    val defensa: Double,
    val ataqueE: Double,
    val defensaE: Double,
    val velocidad: Double

        )

fun CalculoNaturalezas(pokemon: Pokemon): CambioStatsNaturaleza{

    when (pokemon.naturaleza){
        // Neutras
        Naturalezas.Docil -> return CambioStatsNaturaleza(1.0,1.0,1.0,1.0,1.0)
        Naturalezas.Fuerte -> return CambioStatsNaturaleza(1.0,1.0,1.0,1.0,1.0)
        Naturalezas.Rara -> return CambioStatsNaturaleza(1.0,1.0,1.0,1.0,1.0)
        Naturalezas.Seria -> return CambioStatsNaturaleza(1.0,1.0,1.0,1.0,1.0)
        Naturalezas.Timida -> return CambioStatsNaturaleza(1.0,1.0,1.0,1.0,1.0)

        // Ataque
        Naturalezas.Audaz -> return CambioStatsNaturaleza(1.1,1.0,1.0,1.0,0.9)
        Naturalezas.Firme -> return CambioStatsNaturaleza(1.1,1.0,0.9,1.0,1.0)
        Naturalezas.Hurana -> return CambioStatsNaturaleza(1.1,0.9,1.0,1.0,1.0)
        Naturalezas.Picara -> return CambioStatsNaturaleza(1.1,1.0,1.0,0.9,1.0)

        // Defensa
        Naturalezas.Agitada -> return CambioStatsNaturaleza(1.0,1.1,0.9,1.0,1.0)
        Naturalezas.Floja -> return CambioStatsNaturaleza(1.0,1.1,1.0,0.9,1.0)
        Naturalezas.Osada -> return CambioStatsNaturaleza(0.9,1.1,1.0,1.0,1.0)
        Naturalezas.Placida -> return CambioStatsNaturaleza(1.0,1.1,1.0,1.0,0.9)

        // Ataque Especial
        Naturalezas.Afable -> return CambioStatsNaturaleza(1.0,0.9,1.1,1.0,1.0)
        Naturalezas.Alocada -> return CambioStatsNaturaleza(1.0,1.0,1.1,0.9,1.0)
        Naturalezas.Mansa -> return CambioStatsNaturaleza(1.0,1.0,1.1,1.0,0.9)
        Naturalezas.Modesta -> return CambioStatsNaturaleza(0.9,1.0,1.1,1.0,1.0)

        // Defensa Especial
        Naturalezas.Amable -> return CambioStatsNaturaleza(1.0,0.9,1.0,1.1,1.0)
        Naturalezas.Cauta -> return CambioStatsNaturaleza(1.0,1.0,0.9,1.1,1.0)
        Naturalezas.Grosera -> return CambioStatsNaturaleza(1.0,1.0,1.0,1.1,0.9)
        Naturalezas.Serena -> return CambioStatsNaturaleza(0.9,1.0,1.0,1.1,1.0)

        // Velocidad
        Naturalezas.Activa -> return CambioStatsNaturaleza(1.0,0.9,1.0,1.0,1.1)
        Naturalezas.Alegre -> return CambioStatsNaturaleza(1.0,1.0,0.9,1.0,1.1)
        Naturalezas.Ingenua -> return CambioStatsNaturaleza(1.0,1.0,1.0,0.9,1.1)
        Naturalezas.Miedosa -> return CambioStatsNaturaleza(0.9,1.0,1.0,1.0,1.1)
    }


}