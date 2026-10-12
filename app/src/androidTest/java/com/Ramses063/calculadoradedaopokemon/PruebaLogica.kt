package com.Ramses063.calculadoradedaopokemon

import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Pokemon
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Tipo
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Movimiento
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.CategoriaDeMovimiento
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Naturalezas
import com.Ramses063.calculadoradedaopokemon.logica.CalcularDano
import org.junit.Test

class PruebaCalculadora {

    @Test
    fun probarDano() {
        val primarina = Pokemon(
            nombre = "Charizard",
            tipo1 = Tipo.AGUA,
            tipo2 = Tipo.HADA,
            nivel = 100,
            hp = 80,
            ataque = 74,
            defensa = 74,
            ataqueEspecial = 126,
            defensaEspecial = 116,
            velocidad = 60,
            hpFinal = 0,
            ataqueFinal = 0,
            defensaFinal = 0,
            ataqueEspecialFinal = 0,
            defensaEspecialFinal = 0,
            velocidadFinal = 0,
            naturaleza = Naturalezas.Seria,
            IVsHP = 31,
            IVsAtaque = 31,
            IVsDefensa = 31,
            IVsAtaqueE = 31,
            IVsDefensaE = 31,
            IVsVelocidad = 31,
            EvsHp = 0,
            EvsAtaque = 0,
            EvsDefensa = 0,
            EvsAtaqueE = 0,
            EvsDefensaE = 0,
            EvsVelocidad = 0
        )

        val pangoro = Pokemon(
            nombre = "Venusaur",
            tipo1 = Tipo.LUCHA,
            tipo2 = Tipo.SINIESTRO,
            nivel = 100,
            hp = 95,
            ataque = 124,
            defensa = 78,
            ataqueEspecial = 69,
            defensaEspecial = 71,
            velocidad = 58,
            hpFinal = 0,
            ataqueFinal = 0,
            defensaFinal = 0,
            ataqueEspecialFinal = 0,
            defensaEspecialFinal = 0,
            velocidadFinal = 0,
            naturaleza = Naturalezas.Seria,
            IVsHP = 31,
            IVsAtaque = 31,
            IVsDefensa = 31,
            IVsAtaqueE = 31,
            IVsDefensaE = 31,
            IVsVelocidad = 31,
            EvsHp = 0,
            EvsAtaque = 0,
            EvsDefensa = 0,
            EvsAtaqueE = 0,
            EvsDefensaE = 0,
            EvsVelocidad = 0
        )

        val fuerzaLunar = Movimiento(
            nombre = "Fuerza Lunar",
            tipo = Tipo.HADA,
            potencia = 95,
            categoria = CategoriaDeMovimiento.ESPECIAL
        )

        val resultado = CalcularDano(primarina, pangoro, fuerzaLunar)
        println("Daño mínimo: ${resultado.minimo}")
        println("Daño máximo: ${resultado.maximo}")

        println("Daño critico minimo: ${resultado.criticoMinimo}")
        println("Daño critico máximo: ${resultado.criticoMaximo}")

        println("Porcentaje Minimo: ${resultado.porcentajeMinimo}%")
        println("Porcentaje Maximo: ${resultado.porcentajeMaximo}%")

        println("Porcentaje Critico Minimo: ${resultado.porcentajeCriticoMinimo}%")
        println("Porcentaje Critico Maximoo: ${resultado.porcentajeCriticoMaximo}%")


    }

}