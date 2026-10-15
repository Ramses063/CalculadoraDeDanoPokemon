package com.Ramses063.calculadoradedaopokemon.logica

import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Campos
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Climas
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Movimiento
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Pokemon
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Tipo

fun ModificadorCampo(campos: Campos, movimiento: Movimiento, pokemonAtacante: Pokemon, pokemonDefensor: Pokemon): Double{

    var modificadorCampo: Double = 1.0
    val tipoMovimiento = movimiento.tipo


    when{
        campos == Campos.Electrico && tipoMovimiento == Tipo.ELECTRICO && pokemonAtacante.tipo1 != Tipo.VOLADOR && pokemonAtacante.tipo2 != Tipo.VOLADOR -> modificadorCampo = 1.3
        campos == Campos.Hierba && tipoMovimiento == Tipo.PLANTA && pokemonAtacante.tipo1 != Tipo.VOLADOR && pokemonAtacante.tipo2 != Tipo.VOLADOR -> modificadorCampo = 1.3
        campos == Campos.Niebla && tipoMovimiento == Tipo.DRAGON && pokemonDefensor.tipo1 != Tipo.VOLADOR && pokemonDefensor.tipo2 != Tipo.VOLADOR -> modificadorCampo = 0.5
        campos == Campos.Psiquico && tipoMovimiento == Tipo.PSIQUICO && pokemonAtacante.tipo1 != Tipo.VOLADOR && pokemonAtacante.tipo2 != Tipo.VOLADOR -> modificadorCampo = 1.3
    }

    return modificadorCampo

}