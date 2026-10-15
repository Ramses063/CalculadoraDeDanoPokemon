package com.Ramses063.calculadoradedaopokemon.logica
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Climas
import com.Ramses063.calculadoradedaopokemon.modelo.Clases.Tipo

val tablaEfectividades = mapOf(
    // ==================== SÚPER EFECTIVOS (×2.0) ====================
    // Normal
    (Tipo.NORMAL to Tipo.ROCA) to 0.5,
    (Tipo.NORMAL to Tipo.ACERO) to 0.5,
    (Tipo.NORMAL to Tipo.FANTASMA) to 0.0,

    // Fuego
    (Tipo.FUEGO to Tipo.PLANTA) to 2.0,
    (Tipo.FUEGO to Tipo.HIELO) to 2.0,
    (Tipo.FUEGO to Tipo.BICHO) to 2.0,
    (Tipo.FUEGO to Tipo.ACERO) to 2.0,
    (Tipo.FUEGO to Tipo.FUEGO) to 0.5,
    (Tipo.FUEGO to Tipo.AGUA) to 0.5,
    (Tipo.FUEGO to Tipo.ROCA) to 0.5,
    (Tipo.FUEGO to Tipo.DRAGON) to 0.5,

    // Agua
    (Tipo.AGUA to Tipo.FUEGO) to 2.0,
    (Tipo.AGUA to Tipo.TIERRA) to 2.0,
    (Tipo.AGUA to Tipo.ROCA) to 2.0,
    (Tipo.AGUA to Tipo.AGUA) to 0.5,
    (Tipo.AGUA to Tipo.PLANTA) to 0.5,
    (Tipo.AGUA to Tipo.DRAGON) to 0.5,

    // Planta
    (Tipo.PLANTA to Tipo.AGUA) to 2.0,
    (Tipo.PLANTA to Tipo.TIERRA) to 2.0,
    (Tipo.PLANTA to Tipo.ROCA) to 2.0,
    (Tipo.PLANTA to Tipo.FUEGO) to 0.5,
    (Tipo.PLANTA to Tipo.PLANTA) to 0.5,
    (Tipo.PLANTA to Tipo.VENENO) to 0.5,
    (Tipo.PLANTA to Tipo.VOLADOR) to 0.5,
    (Tipo.PLANTA to Tipo.BICHO) to 0.5,
    (Tipo.PLANTA to Tipo.DRAGON) to 0.5,
    (Tipo.PLANTA to Tipo.ACERO) to 0.5,

    // Eléctrico
    (Tipo.ELECTRICO to Tipo.AGUA) to 2.0,
    (Tipo.ELECTRICO to Tipo.VOLADOR) to 2.0,
    (Tipo.ELECTRICO to Tipo.ELECTRICO) to 0.5,
    (Tipo.ELECTRICO to Tipo.PLANTA) to 0.5,
    (Tipo.ELECTRICO to Tipo.DRAGON) to 0.5,
    (Tipo.ELECTRICO to Tipo.TIERRA) to 0.0,

    // Hielo
    (Tipo.HIELO to Tipo.PLANTA) to 2.0,
    (Tipo.HIELO to Tipo.TIERRA) to 2.0,
    (Tipo.HIELO to Tipo.VOLADOR) to 2.0,
    (Tipo.HIELO to Tipo.DRAGON) to 2.0,
    (Tipo.HIELO to Tipo.FUEGO) to 0.5,
    (Tipo.HIELO to Tipo.AGUA) to 0.5,
    (Tipo.HIELO to Tipo.HIELO) to 0.5,
    (Tipo.HIELO to Tipo.ACERO) to 0.5,

    // Lucha
    (Tipo.LUCHA to Tipo.NORMAL) to 2.0,
    (Tipo.LUCHA to Tipo.HIELO) to 2.0,
    (Tipo.LUCHA to Tipo.ROCA) to 2.0,
    (Tipo.LUCHA to Tipo.SINIESTRO) to 2.0,
    (Tipo.LUCHA to Tipo.ACERO) to 2.0,
    (Tipo.LUCHA to Tipo.VENENO) to 0.5,
    (Tipo.LUCHA to Tipo.VOLADOR) to 0.5,
    (Tipo.LUCHA to Tipo.PSIQUICO) to 0.5,
    (Tipo.LUCHA to Tipo.BICHO) to 0.5,
    (Tipo.LUCHA to Tipo.HADA) to 0.5,
    (Tipo.LUCHA to Tipo.FANTASMA) to 0.0,

    // Veneno
    (Tipo.VENENO to Tipo.PLANTA) to 2.0,
    (Tipo.VENENO to Tipo.HADA) to 2.0,
    (Tipo.VENENO to Tipo.VENENO) to 0.5,
    (Tipo.VENENO to Tipo.TIERRA) to 0.5,
    (Tipo.VENENO to Tipo.ROCA) to 0.5,
    (Tipo.VENENO to Tipo.FANTASMA) to 0.5,
    (Tipo.VENENO to Tipo.ACERO) to 0.0,

    // Tierra
    (Tipo.TIERRA to Tipo.FUEGO) to 2.0,
    (Tipo.TIERRA to Tipo.ELECTRICO) to 2.0,
    (Tipo.TIERRA to Tipo.VENENO) to 2.0,
    (Tipo.TIERRA to Tipo.ROCA) to 2.0,
    (Tipo.TIERRA to Tipo.ACERO) to 2.0,
    (Tipo.TIERRA to Tipo.PLANTA) to 0.5,
    (Tipo.TIERRA to Tipo.BICHO) to 0.5,
    (Tipo.TIERRA to Tipo.VOLADOR) to 0.0,

    // Volador
    (Tipo.VOLADOR to Tipo.PLANTA) to 2.0,
    (Tipo.VOLADOR to Tipo.LUCHA) to 2.0,
    (Tipo.VOLADOR to Tipo.BICHO) to 2.0,
    (Tipo.VOLADOR to Tipo.ELECTRICO) to 0.5,
    (Tipo.VOLADOR to Tipo.ROCA) to 0.5,
    (Tipo.VOLADOR to Tipo.ACERO) to 0.5,

    // Psíquico
    (Tipo.PSIQUICO to Tipo.LUCHA) to 2.0,
    (Tipo.PSIQUICO to Tipo.VENENO) to 2.0,
    (Tipo.PSIQUICO to Tipo.PSIQUICO) to 0.5,
    (Tipo.PSIQUICO to Tipo.ACERO) to 0.5,
    (Tipo.PSIQUICO to Tipo.SINIESTRO) to 0.0,

    // Bicho
    (Tipo.BICHO to Tipo.PLANTA) to 2.0,
    (Tipo.BICHO to Tipo.PSIQUICO) to 2.0,
    (Tipo.BICHO to Tipo.SINIESTRO) to 2.0,
    (Tipo.BICHO to Tipo.FUEGO) to 0.5,
    (Tipo.BICHO to Tipo.LUCHA) to 0.5,
    (Tipo.BICHO to Tipo.VENENO) to 0.5,
    (Tipo.BICHO to Tipo.VOLADOR) to 0.5,
    (Tipo.BICHO to Tipo.FANTASMA) to 0.5,
    (Tipo.BICHO to Tipo.ACERO) to 0.5,
    (Tipo.BICHO to Tipo.HADA) to 0.5,

    // Roca
    (Tipo.ROCA to Tipo.FUEGO) to 2.0,
    (Tipo.ROCA to Tipo.HIELO) to 2.0,
    (Tipo.ROCA to Tipo.VOLADOR) to 2.0,
    (Tipo.ROCA to Tipo.BICHO) to 2.0,
    (Tipo.ROCA to Tipo.LUCHA) to 0.5,
    (Tipo.ROCA to Tipo.TIERRA) to 0.5,
    (Tipo.ROCA to Tipo.ACERO) to 0.5,

    // Fantasma
    (Tipo.FANTASMA to Tipo.PSIQUICO) to 2.0,
    (Tipo.FANTASMA to Tipo.FANTASMA) to 2.0,
    (Tipo.FANTASMA to Tipo.SINIESTRO) to 0.5,
    (Tipo.FANTASMA to Tipo.NORMAL) to 0.0,

    // Dragón
    (Tipo.DRAGON to Tipo.DRAGON) to 2.0,
    (Tipo.DRAGON to Tipo.ACERO) to 0.5,
    (Tipo.DRAGON to Tipo.HADA) to 0.0,

    // Siniestro
    (Tipo.SINIESTRO to Tipo.PSIQUICO) to 2.0,
    (Tipo.SINIESTRO to Tipo.FANTASMA) to 2.0,
    (Tipo.SINIESTRO to Tipo.LUCHA) to 0.5,
    (Tipo.SINIESTRO to Tipo.SINIESTRO) to 0.5,
    (Tipo.SINIESTRO to Tipo.HADA) to 0.5,

    // Acero
    (Tipo.ACERO to Tipo.HIELO) to 2.0,
    (Tipo.ACERO to Tipo.ROCA) to 2.0,
    (Tipo.ACERO to Tipo.HADA) to 2.0,
    (Tipo.ACERO to Tipo.FUEGO) to 0.5,
    (Tipo.ACERO to Tipo.AGUA) to 0.5,
    (Tipo.ACERO to Tipo.ELECTRICO) to 0.5,
    (Tipo.ACERO to Tipo.ACERO) to 0.5,

    // Hada
    (Tipo.HADA to Tipo.LUCHA) to 2.0,
    (Tipo.HADA to Tipo.DRAGON) to 2.0,
    (Tipo.HADA to Tipo.SINIESTRO) to 2.0,
    (Tipo.HADA to Tipo.FUEGO) to 0.5,
    (Tipo.HADA to Tipo.VENENO) to 0.5,
    (Tipo.HADA to Tipo.ACERO) to 0.5
)

fun calcularEfectividad(tipoAtacante: Tipo, tipoDefensor: Tipo, clima: Climas): Double{

    val efectividadBase = tablaEfectividades[tipoAtacante to tipoDefensor] ?: 1.0

    if (clima == Climas.Turbulencias && tipoDefensor == Tipo.VOLADOR && efectividadBase > 1.0){
        return 1.0
    }

    return efectividadBase

}
