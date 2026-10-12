package com.Ramses063.calculadoradedaopokemon.logica

import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Pokemon
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Movimiento
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.CategoriaDeMovimiento
import com.Ramses063.calculadoradedaopokemon.logica.CalcularHP
import com.Ramses063.calculadoradedaopokemon.logica.CalcularAtaque
import com.Ramses063.calculadoradedaopokemon.logica.CalcularDefensa
import com.Ramses063.calculadoradedaopokemon.logica.CalcularAtaqueEspecial
import com.Ramses063.calculadoradedaopokemon.logica.CalcularDefensaEspecial
import com.Ramses063.calculadoradedaopokemon.logica.CalcularVelocidad
import kotlin.math.ceil
import kotlin.math.floor

fun pokeRound(num: Double): Int {
    return if (num % 1 > 0.5) {
        ceil(num).toInt()
    } else {
        floor(num).toInt()
    }
}
fun CalcularDano (pokemonAtacante: Pokemon, pokemonDefensor: Pokemon, movimiento: Movimiento): ResultadoDano {

    pokemonAtacante.hpFinal = CalcularHP(pokemonAtacante)
    pokemonAtacante.ataqueFinal = CalcularAtaque(pokemonAtacante)
    pokemonAtacante.defensaFinal = CalcularDefensa(pokemonAtacante)
    pokemonAtacante.ataqueEspecialFinal = CalcularAtaqueEspecial(pokemonAtacante)
    pokemonAtacante.defensaEspecialFinal = CalcularDefensaEspecial(pokemonAtacante)
    pokemonAtacante.velocidadFinal = CalcularVelocidad(pokemonAtacante)

    pokemonDefensor.hpFinal = CalcularHP(pokemonDefensor)
    pokemonDefensor.ataqueFinal = CalcularAtaque(pokemonDefensor)
    pokemonDefensor.defensaFinal = CalcularDefensa(pokemonDefensor)
    pokemonDefensor.ataqueEspecialFinal = CalcularAtaqueEspecial(pokemonDefensor)
    pokemonDefensor.defensaEspecialFinal = CalcularDefensaEspecial(pokemonDefensor)
    pokemonDefensor.velocidadFinal = CalcularVelocidad(pokemonDefensor)


    val ataqueEfectivo: Int
    val defensaEfectiva: Int
    val STAB: Double

    val efectividad1 = calcularEfectividad(movimiento.tipo, pokemonDefensor.tipo1)
    val efectividad2 = if (pokemonDefensor.tipo2 != null){
        calcularEfectividad(movimiento.tipo, pokemonDefensor.tipo2!!)
    } else{
        1.0
    }
    val efectividadTotal = efectividad1 * efectividad2


    when (movimiento.categoria){
        CategoriaDeMovimiento.FISICO -> {
            ataqueEfectivo = pokemonAtacante.ataqueFinal
            defensaEfectiva = pokemonDefensor.defensaFinal
        }

        CategoriaDeMovimiento.ESPECIAL -> {
            ataqueEfectivo = pokemonAtacante.ataqueEspecialFinal
            defensaEfectiva = pokemonDefensor.defensaEspecialFinal
        }
        CategoriaDeMovimiento.ESTADO -> {
            return ResultadoDano(0, 0,0,0,0.0,0.0,0.0,0.0)
        }
    }

    println("Tipo del movimiento: ${movimiento.tipo}")
    println("Tipo 1 del atacante: ${pokemonAtacante.tipo1}")
    println("Tipo 2 del atacante: ${pokemonAtacante.tipo2}")

    if (movimiento.tipo == pokemonAtacante.tipo1 || movimiento.tipo == pokemonAtacante.tipo2){
        STAB = 1.5
    } else { STAB = 1.0 }

    val paso1 = floor((2.0 * pokemonAtacante.nivel / 5.0) + 2.0).toInt()
    val paso2 = (paso1 * movimiento.potencia * ataqueEfectivo).toInt()  // OF32
    val paso3 = (paso2.toDouble() / defensaEfectiva).toInt()  // OF32
    val base = floor(paso3 / 50.0 + 2.0).toInt()

    val conRollMin = floor(base * 85.0 / 100.0).toInt()
    val conStabMin = (conRollMin * STAB).toInt()  // STAB
    val danoMinimo = floor(pokeRound(conStabMin.toDouble()) * efectividadTotal).toInt()

    val conRollMax = floor(base * 100.0 / 100.0).toInt()
    val conStabMax = (conRollMax * STAB).toInt()
    val danoMaximo = floor(pokeRound(conStabMax.toDouble()) * efectividadTotal).toInt()

    val porcentajeMinimo = (danoMinimo.toDouble() / pokemonDefensor.hpFinal) * 100
    val porcentajeMaximo = (danoMaximo.toDouble() / pokemonDefensor.hpFinal) * 100

    val baseCritica = (base *1.5).toInt()

    val conRollMinCritico = floor(base * 85.0 / 100.0).toInt()
    val conCriticoMin = floor(conRollMinCritico * 1.5).toInt()
    val danoCriticoMinimo = floor(pokeRound(conCriticoMin.toDouble()) * STAB * efectividadTotal).toInt()

    val conRollMaxCritico = floor(base * 100.0 / 100.0).toInt()
    val conCriticoMax = floor(conRollMax * 1.5).toInt()
    val danoCriticoMaximo = floor(pokeRound(conCriticoMax.toDouble()) * STAB * efectividadTotal).toInt()

    val porcentajeCriticoMinimo = (danoCriticoMinimo.toDouble() / pokemonDefensor.hpFinal) * 100
    val porcentajeCriticoMaximo = (danoCriticoMaximo.toDouble() / pokemonDefensor.hpFinal) * 100

    val porcentajeMinimoRedondeado = String.format(java.util.Locale.US,"%.1f", porcentajeMinimo).toDouble()
    val porcentajeMaximoRedondeado = String.format(java.util.Locale.US,"%.1f", porcentajeMaximo).toDouble()

    val porcentajeCriticoMinimoRedondeado = String.format(java.util.Locale.US,"%.1f", porcentajeCriticoMinimo).toDouble()
    val porcentajeCriticoMaximoRedondeado = String.format(java.util.Locale.US,"%.1f", porcentajeCriticoMaximo).toDouble()

    return ResultadoDano(danoMinimo, danoMaximo,danoCriticoMinimo,danoCriticoMaximo,  porcentajeMinimoRedondeado, porcentajeMaximoRedondeado,porcentajeCriticoMinimoRedondeado,porcentajeCriticoMaximoRedondeado)
}




