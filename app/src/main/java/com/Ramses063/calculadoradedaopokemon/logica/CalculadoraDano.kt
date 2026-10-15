package com.Ramses063.calculadoradedaopokemon.logica

import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Campos
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Pokemon
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Movimiento
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.CategoriaDeMovimiento
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Climas
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Tipo
import kotlin.math.ceil
import kotlin.math.floor

fun pokeRound(num: Double): Int {
    return if (num % 1 > 0.5) {
        ceil(num).toInt()
    } else {
        floor(num).toInt()
    }
}
fun CalcularDano (pokemonAtacante: Pokemon, pokemonDefensor: Pokemon, movimiento: Movimiento, clima: Climas, campos: Campos): ResultadoDano {

    pokemonAtacante.hpFinal = CalcularHP(pokemonAtacante)
    pokemonAtacante.ataqueFinal = CalcularAtaque(pokemonAtacante)
    pokemonAtacante.defensaFinal = CalcularDefensa(pokemonAtacante, clima)
    pokemonAtacante.ataqueEspecialFinal = CalcularAtaqueEspecial(pokemonAtacante)
    pokemonAtacante.defensaEspecialFinal = CalcularDefensaEspecial(pokemonAtacante, clima)
    pokemonAtacante.velocidadFinal = CalcularVelocidad(pokemonAtacante)

    pokemonDefensor.hpFinal = CalcularHP(pokemonDefensor)
    pokemonDefensor.ataqueFinal = CalcularAtaque(pokemonDefensor)
    pokemonDefensor.defensaFinal = CalcularDefensa(pokemonDefensor, clima)
    pokemonDefensor.ataqueEspecialFinal = CalcularAtaqueEspecial(pokemonDefensor)
    pokemonDefensor.defensaEspecialFinal = CalcularDefensaEspecial(pokemonDefensor, clima)
    pokemonDefensor.velocidadFinal = CalcularVelocidad(pokemonDefensor)


    val ataqueEfectivo: Int
    val defensaEfectiva: Int
    val STAB: Double
    val modificadorCampo: Double = ModificadorCampo(campos, movimiento, pokemonAtacante, pokemonDefensor)
    val modificadorClima: Double = ModificadorClima(clima, movimiento)



    val efectividad1 = calcularEfectividad(movimiento.tipo, pokemonDefensor.tipo1, clima)
    val efectividad2 = if (pokemonDefensor.tipo2 != Tipo.VACIO){
        calcularEfectividad(movimiento.tipo, pokemonDefensor.tipo2!!, clima)
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


    if (movimiento.tipo == pokemonAtacante.tipo1 || movimiento.tipo == pokemonAtacante.tipo2){
        STAB = 1.5
    } else { STAB = 1.0 }



    val paso1 = floor((2.0 * pokemonAtacante.nivel / 5.0) + 2.0).toInt()
    val paso2 = (paso1 * (movimiento.potencia) * ataqueEfectivo).toDouble()
    val paso3 = paso2/ defensaEfectiva
    val base = floor(paso3 / 50.0 + 2.0).toInt()

    val conRollMin = floor(base * 85.0 / 100.0 * modificadorClima).toInt()
    val conStabMin = (conRollMin * STAB).toInt()
    val conEfectividadMin = floor(pokeRound(conStabMin.toDouble()) * efectividadTotal).toInt()

    val danoMinimo = Math.round(conEfectividadMin * modificadorCampo).toInt()


    val conRollMax = floor(base * 100.0 / 100.0 * modificadorClima).toInt()
    val conStabMax = (conRollMax  * STAB).toInt()
    val conEfectividadMax = floor(pokeRound(conStabMax.toDouble()) * efectividadTotal).toInt()

    val danoMaximo = Math.round(conEfectividadMax * modificadorCampo).toInt()

    val porcentajeMinimo = (danoMinimo.toDouble() / pokemonDefensor.hpFinal) * 100
    val porcentajeMaximo = (danoMaximo.toDouble() / pokemonDefensor.hpFinal) * 100

    val baseCritica = (base *1.5).toInt()


    val conRollMinCritico = floor(baseCritica * 85.0 / 100.0 * modificadorClima * modificadorCampo).toInt()
    val conStabCriticoMin = (conRollMinCritico * STAB).toInt()
    val danoCriticoMinimo = floor(pokeRound(conStabCriticoMin.toDouble()) * efectividadTotal ).toInt()

    val conRollMaxCritico = floor(baseCritica * 100.0 / 100.0 * modificadorClima * modificadorCampo).toInt()
    val conStabCriticoMax = floor(conRollMaxCritico * STAB).toInt()
    val danoCriticoMaximo = floor(pokeRound(conStabCriticoMax.toDouble())  * efectividadTotal ).toInt()

    val porcentajeCriticoMinimo = (danoCriticoMinimo.toDouble() / pokemonDefensor.hpFinal) * 100
    val porcentajeCriticoMaximo = (danoCriticoMaximo.toDouble() / pokemonDefensor.hpFinal) * 100

    val porcentajeMinimoRedondeado = String.format(java.util.Locale.US,"%.1f", porcentajeMinimo).toDouble()
    val porcentajeMaximoRedondeado = String.format(java.util.Locale.US,"%.1f", porcentajeMaximo).toDouble()

    val porcentajeCriticoMinimoRedondeado = String.format(java.util.Locale.US,"%.1f", porcentajeCriticoMinimo).toDouble()
    val porcentajeCriticoMaximoRedondeado = String.format(java.util.Locale.US,"%.1f", porcentajeCriticoMaximo).toDouble()

    return ResultadoDano(danoMinimo, danoMaximo,danoCriticoMinimo,danoCriticoMaximo,  porcentajeMinimoRedondeado, porcentajeMaximoRedondeado,porcentajeCriticoMinimoRedondeado,porcentajeCriticoMaximoRedondeado)
}




