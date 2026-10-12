package com.Ramses063.calculadoradedaopokemon.logica

import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Pokemon
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Tipo


fun CalcularHP(pokemon: Pokemon): Int {
    return (((((2 * pokemon.hp) + pokemon.IVsHP + (pokemon.EvsHp/4)) * pokemon.nivel)/100) + pokemon.nivel + 10).toInt()
}
fun CalcularAtaque(pokemon: Pokemon): Int{
    return ((((((2* pokemon.ataque) + pokemon.IVsAtaque+ (pokemon.EvsAtaque/4))* pokemon.nivel)/100)+5)* CalculoNaturalezas(pokemon).ataque).toInt()
}

fun CalcularDefensa(pokemon: Pokemon): Int{
    return ((((((2* pokemon.defensa) + pokemon.IVsDefensa+ (pokemon.EvsDefensa/4))* pokemon.nivel)/100)+5)* CalculoNaturalezas(pokemon).defensa).toInt()
}

fun CalcularAtaqueEspecial(pokemon: Pokemon): Int{
    return ((((((2* pokemon.ataqueEspecial) + pokemon.IVsAtaqueE+ (pokemon.EvsAtaqueE/4))* pokemon.nivel)/100)+5)* CalculoNaturalezas(pokemon).ataqueE).toInt()
}

fun CalcularDefensaEspecial(pokemon: Pokemon): Int{
    return ((((((2* pokemon.defensaEspecial) + pokemon.IVsDefensaE+ (pokemon.EvsDefensaE/4))* pokemon.nivel)/100)+5)* CalculoNaturalezas(pokemon).defensaE).toInt()
}
fun CalcularVelocidad(pokemon: Pokemon): Int{
    return ((((((2* pokemon.velocidad) + pokemon.IVsVelocidad+ (pokemon.EvsVelocidad/4))* pokemon.nivel)/100)+5)* CalculoNaturalezas(pokemon).velocidad).toInt()
}
