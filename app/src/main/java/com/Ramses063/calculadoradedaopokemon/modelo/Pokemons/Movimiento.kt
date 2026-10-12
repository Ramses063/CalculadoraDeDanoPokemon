package com.Ramses063.calculadoradedaopokemon.modelo.Pokemons

data class Movimiento (
    val nombre: String,
    val tipo: Tipo,
    val potencia: Int,
    val categoria: CategoriaDeMovimiento,
    )