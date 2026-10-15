package com.Ramses063.calculadoradedaopokemon

import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Pokemon
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Tipo
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Movimiento
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.CategoriaDeMovimiento
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Naturalezas
import com.Ramses063.calculadoradedaopokemon.logica.CalcularDano
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Campos
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Climas
import org.junit.Test

class PruebaCalculadora {

    @Test
    fun probarDano() {
        val primarina = Pokemon(
            nombre = "Pikachu",
            tipo1 = Tipo.ELECTRICO,
            tipo2 = Tipo.VACIO,
            nivel = 50,
            hp = 35,
            ataque = 55,
            defensa = 40,
            ataqueEspecial = 50,
            defensaEspecial = 50,
            velocidad = 90,
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
            nombre = "Ninetales Alola",
            tipo1 = Tipo.FUEGO,
            tipo2 = Tipo.VACIO,
            nivel = 50,
            hp = 73,
            ataque = 76,
            defensa = 75,
            ataqueEspecial = 81,
            defensaEspecial = 100,
            velocidad = 100,
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
            nombre = "Rayo",
            tipo = Tipo.DRAGON,
            potencia = 90,
            categoria = CategoriaDeMovimiento.ESPECIAL
        )

        val resultado = CalcularDano(primarina, pangoro, fuerzaLunar, Climas.Despejado, Campos.Niebla)
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