package com.Ramses063.calculadoradedaopokemon.logica

import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Climas
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Movimiento
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Tipo

fun ModificadorClima(climas: Climas, movimiento: Movimiento): Double{

    var modificadorClima: Double = 1.0
    val tipoMovimiento = movimiento.tipo

    when {
        //-----------------------------------SOL--------------------------------------
        climas == Climas.Sol && tipoMovimiento == Tipo.FUEGO -> modificadorClima = 1.5
        climas == Climas.Sol && tipoMovimiento == Tipo.AGUA -> modificadorClima = 0.5

        //-----------------------------SOL ABRAZADOR----------------------------------
        climas == Climas.SolAbrasador && tipoMovimiento == Tipo.FUEGO -> modificadorClima = 1.5
        climas == Climas.SolAbrasador && tipoMovimiento == Tipo.AGUA -> modificadorClima = 0.0

        //---------------------------------LLUVIA-------------------------------------
        climas == Climas.Lluvia && tipoMovimiento == Tipo.FUEGO -> modificadorClima = 0.5
        climas == Climas.Lluvia && tipoMovimiento == Tipo.AGUA -> modificadorClima = 1.5

        //--------------------------------DILUVIO-------------------------------------
        climas == Climas.Diluvio && tipoMovimiento == Tipo.FUEGO -> modificadorClima = 0.0
        climas == Climas.Diluvio && tipoMovimiento == Tipo.AGUA -> modificadorClima = 1.5
    }
 return modificadorClima
}