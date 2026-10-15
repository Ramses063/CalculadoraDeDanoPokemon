package com.Ramses063.calculadoradedaopokemon.logica

import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Climas
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Pokemon
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Tipo


fun CalcularHP(pokemon: Pokemon): Int {
    return (((((2 * pokemon.hp) + pokemon.IVsHP + (pokemon.EvsHp/4)) * pokemon.nivel)/100) + pokemon.nivel + 10).toInt()
}
fun CalcularAtaque(pokemon: Pokemon): Int{
    return ((((((2* pokemon.ataque) + pokemon.IVsAtaque+ (pokemon.EvsAtaque/4))* pokemon.nivel)/100)+5)* CalculoNaturalezas(pokemon).ataque).toInt()
}

fun CalcularDefensa(pokemon: Pokemon, clima: Climas): Int{

    val tipoPokemon1 = pokemon.tipo1
    val tipoPokemon2 = pokemon.tipo2
    val defensa = (((((2* pokemon.defensa) + pokemon.IVsDefensa + (pokemon.EvsDefensa/4)) * pokemon.nivel)/100)+5) * CalculoNaturalezas(pokemon).defensa

    if(clima == Climas.Nieve && (tipoPokemon1 == Tipo.HIELO || tipoPokemon2 == Tipo.HIELO)){
        return pokeRound(defensa * 1.5)
    } else{
    return defensa.toInt()
    }
}

fun CalcularAtaqueEspecial(pokemon: Pokemon): Int{
    return ((((((2* pokemon.ataqueEspecial) + pokemon.IVsAtaqueE+ (pokemon.EvsAtaqueE/4))* pokemon.nivel)/100)+5)* CalculoNaturalezas(pokemon).ataqueE).toInt()
}

fun CalcularDefensaEspecial(pokemon: Pokemon, clima: Climas): Int{
    val tipoPokemon1 = pokemon.tipo1
    val tipoPokemon2 = pokemon.tipo2
    val defensaEspecial = (((((2* pokemon.defensaEspecial) + pokemon.IVsDefensaE+ (pokemon.EvsDefensaE/4))* pokemon.nivel)/100)+5)* CalculoNaturalezas(pokemon).defensaE


    if(clima == Climas.TormentaDeArena && (tipoPokemon1 == Tipo.ROCA || tipoPokemon2 == Tipo.ROCA)){
    return pokeRound(defensaEspecial * 1.5)}
    else{
        return defensaEspecial.toInt()
    }


}
fun CalcularVelocidad(pokemon: Pokemon): Int{
    return ((((((2* pokemon.velocidad) + pokemon.IVsVelocidad+ (pokemon.EvsVelocidad/4))* pokemon.nivel)/100)+5)* CalculoNaturalezas(pokemon).velocidad).toInt()
}
