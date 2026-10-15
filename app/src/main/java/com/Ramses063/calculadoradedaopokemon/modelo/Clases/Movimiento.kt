package com.Ramses063.calculadoradedaopokemon.modelo.Clases

data class Movimiento (
    val nombre: String,
    val tipo: Tipo,
    val potencia: Int,
    val categoria: CategoriaDeMovimiento,
    )