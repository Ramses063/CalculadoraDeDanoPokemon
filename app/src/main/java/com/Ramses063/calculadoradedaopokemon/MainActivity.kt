package com.Ramses063.calculadoradedaopokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Tipo
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.Ramses063.calculadoradedaopokemon.ui.theme.CalculadoraDeDañoPokemonTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.Ramses063.calculadoradedaopokemon.logica.CalcularDano
import com.Ramses063.calculadoradedaopokemon.logica.ResultadoDano
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.CategoriaDeMovimiento
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Movimiento
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Naturalezas
import com.Ramses063.calculadoradedaopokemon.modelo.Pokemons.Pokemon
import com.Ramses063.calculadoradedaopokemon.BuildConfig

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContent {
            val teclado = LocalSoftwareKeyboardController.current
            CalculadoraDeDañoPokemonTheme() {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .imePadding()
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            teclado?.hide()
                        }
                )
                {




                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {

                    var resultadoMov1 by remember { mutableStateOf<ResultadoDano?>(null) }
                    var resultadoMov2 by remember { mutableStateOf<ResultadoDano?>(null) }
                    var potencia1 by remember { mutableStateOf("") }
                    var tipoSeleccionado by remember { mutableStateOf(Tipo.FUEGO) }
                    var expandido by remember { mutableStateOf(false) }
                    var categoriaSeleccionada1 by remember { mutableStateOf(CategoriaDeMovimiento.FISICO) }
                    var expandidoCategoria1 by remember { mutableStateOf(false) }
                    var potencia2 by remember { mutableStateOf("") }
                    var tipoSeleccionado2 by remember { mutableStateOf(Tipo.FUEGO) }
                    var expandido2 by remember { mutableStateOf(false) }
                    var categoriaSeleccionada2 by remember { mutableStateOf(CategoriaDeMovimiento.FISICO) }
                    var expandidoCategoria2 by remember { mutableStateOf(false) }
                    var tipo1Pokemon1 by remember { mutableStateOf(Tipo.NORMAL) }
                    var expandidoTipo1Pokemon1 by remember { mutableStateOf(false) }
                    var tipo2Pokemon1 by remember { mutableStateOf(Tipo.VACIO) }
                    var expandidoTipo2Pokemon1 by remember { mutableStateOf(false) }
                    var nivel1 by remember { mutableStateOf("") }
                    var hp1 by remember { mutableStateOf("") }
                    var ataque1 by remember { mutableStateOf("") }
                    var defensa1 by remember { mutableStateOf("") }
                    var ataqueE1 by remember { mutableStateOf("") }
                    var defensaE1 by remember { mutableStateOf("") }
                    var velocidad1 by remember { mutableStateOf("") }
                    var naturaleza1 by remember {mutableStateOf(Naturalezas.Seria)}
                    var expandidoNaturaleza1 by remember {mutableStateOf(false)}
                    var mostrarEVs1 by remember { mutableStateOf(false) }
                    var evHP1 by remember { mutableStateOf("") }
                    var evAtaque1 by remember { mutableStateOf("") }
                    var evDefensa1 by remember { mutableStateOf("") }
                    var evAtaqueE1 by remember { mutableStateOf("") }
                    var evDefensaE1 by remember { mutableStateOf("") }
                    var evVelocidad1 by remember { mutableStateOf("") }
                    var mostrarIVs1 by remember { mutableStateOf(false) }
                    var ivHP1 by remember { mutableStateOf("") }
                    var ivAtaque1 by remember { mutableStateOf("") }
                    var ivDefensa1 by remember { mutableStateOf("") }
                    var ivAtaqueE1 by remember { mutableStateOf("") }
                    var ivDefensaE1 by remember { mutableStateOf("") }
                    var ivVelocidad1 by remember { mutableStateOf("") }
                    var tipo1Pokemon2 by remember { mutableStateOf(Tipo.NORMAL) }
                    var expandidoTipo1Pokemon2 by remember { mutableStateOf(false) }
                    var tipo2Pokemon2 by remember { mutableStateOf(Tipo.VACIO) }
                    var expandidoTipo2Pokemon2 by remember { mutableStateOf(false) }
                    var nivel2 by remember { mutableStateOf("") }
                    var hp2 by remember { mutableStateOf("") }
                    var ataque2 by remember { mutableStateOf("") }
                    var defensa2 by remember { mutableStateOf("") }
                    var ataqueE2 by remember { mutableStateOf("") }
                    var defensaE2 by remember { mutableStateOf("") }
                    var velocidad2 by remember { mutableStateOf("") }
                    var naturaleza2 by remember {mutableStateOf(Naturalezas.Seria)}
                    var expandidoNaturaleza2 by remember {mutableStateOf(false)}
                    var mostrarEVs2 by remember { mutableStateOf(false) }
                    var evHP2 by remember { mutableStateOf("") }
                    var evAtaque2 by remember { mutableStateOf("") }
                    var evDefensa2 by remember { mutableStateOf("") }
                    var evAtaqueE2 by remember { mutableStateOf("") }
                    var evDefensaE2 by remember { mutableStateOf("") }
                    var evVelocidad2 by remember { mutableStateOf("") }
                    var mostrarIVs2 by remember { mutableStateOf(false) }
                    var ivHP2 by remember { mutableStateOf("") }
                    var ivAtaque2 by remember { mutableStateOf("") }
                    var ivDefensa2 by remember { mutableStateOf("") }
                    var ivAtaqueE2 by remember { mutableStateOf("") }
                    var ivDefensaE2 by remember { mutableStateOf("") }
                    var ivVelocidad2 by remember { mutableStateOf("") }


                    // Resultado Del Calculo

                    Spacer(modifier = Modifier.height(64.dp))
                    Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
                    Text(text = "RESULTADO DEL CÁLCULO", fontSize = 24.sp)}
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            if (resultadoMov1 != null) {
                                Text("Normal:")
                                Text("${resultadoMov1!!.minimo} - ${resultadoMov1!!.maximo}")
                                Text("(${resultadoMov1!!.porcentajeMinimo}% - ${resultadoMov1!!.porcentajeMaximo}%)")
                                Text("Crítico:")
                                Text("${resultadoMov1!!.criticoMinimo} - ${resultadoMov1!!.criticoMaximo}")
                                Text("(${resultadoMov1!!.porcentajeCriticoMinimo}% - ${resultadoMov1!!.porcentajeCriticoMaximo}%)")
                            } else {
                                Text("Normal:")
                                Text("...")
                                Text("Crítico:")
                                Text("...")
                            }
                        }
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.End
                        ) {if (resultadoMov2 != null) {
                            Text("Normal:")
                            Text("${resultadoMov2!!.minimo} - ${resultadoMov2!!.maximo}")
                            Text("(${resultadoMov2!!.porcentajeMinimo}% - ${resultadoMov2!!.porcentajeMaximo}%)")
                            Text("Crítico:")
                            Text("${resultadoMov2!!.criticoMinimo} - ${resultadoMov2!!.criticoMaximo}")
                            Text("(${resultadoMov2!!.porcentajeCriticoMinimo}% - ${resultadoMov2!!.porcentajeCriticoMaximo}%)")
                        } else {
                            Text("Normal:")
                            Text("...")
                            Text("Crítico:")
                            Text("...")
                        }
                        }
                    }

                    // Boton Calcular

                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = {
                            val pokemon1 = Pokemon(
                                nombre = "Pokemon 1",
                                tipo1 = tipo1Pokemon1,
                                tipo2 = tipo2Pokemon1,
                                nivel = nivel1.toIntOrNull() ?: 50,
                                hp = hp1.toIntOrNull() ?: 0,
                                ataque = ataque1.toIntOrNull() ?: 0,
                                defensa = defensa1.toIntOrNull() ?: 0,
                                ataqueEspecial = ataqueE1.toIntOrNull() ?: 0,
                                defensaEspecial = defensaE1.toIntOrNull() ?: 0,
                                velocidad = velocidad1.toIntOrNull() ?: 0,
                                hpFinal = 0,
                                ataqueFinal = 0,
                                defensaFinal = 0,
                                ataqueEspecialFinal = 0,
                                defensaEspecialFinal = 0,
                                velocidadFinal = 0,
                                naturaleza = naturaleza1,
                                IVsHP = ivHP1.toIntOrNull() ?: 31,
                                IVsAtaque = ivAtaque1.toIntOrNull() ?: 31,
                                IVsDefensa = ivDefensa1.toIntOrNull() ?: 31,
                                IVsAtaqueE = ivAtaqueE1.toIntOrNull() ?: 31,
                                IVsDefensaE = ivDefensaE1.toIntOrNull() ?: 31,
                                IVsVelocidad = ivVelocidad1.toIntOrNull() ?: 31,
                                EvsHp = evHP1.toIntOrNull() ?: 0,
                                EvsAtaque = evAtaque1.toIntOrNull() ?: 0,
                                EvsDefensa = evDefensa1.toIntOrNull() ?: 0,
                                EvsAtaqueE = evAtaqueE1.toIntOrNull() ?: 0,
                                EvsDefensaE = evDefensaE1.toIntOrNull() ?: 0,
                                EvsVelocidad = evVelocidad1.toIntOrNull() ?: 0,
                                )

                            val pokemon2 = Pokemon(
                                nombre = "Pokemon 2",
                                tipo1 = tipo1Pokemon2,
                                tipo2 = tipo2Pokemon2,
                                nivel = nivel2.toIntOrNull() ?: 50,
                                hp = hp2.toIntOrNull() ?: 0,
                                ataque = ataque2.toIntOrNull() ?: 0,
                                defensa = defensa2.toIntOrNull() ?: 0,
                                ataqueEspecial = ataqueE2.toIntOrNull() ?: 0,
                                defensaEspecial = defensaE2.toIntOrNull() ?: 0,
                                velocidad = velocidad2.toIntOrNull() ?: 0,
                                hpFinal = 0,
                                ataqueFinal = 0,
                                defensaFinal = 0,
                                ataqueEspecialFinal = 0,
                                defensaEspecialFinal = 0,
                                velocidadFinal = 0,
                                naturaleza = naturaleza2,
                                IVsHP = ivHP2.toIntOrNull() ?: 31,
                                IVsAtaque = ivAtaque2.toIntOrNull() ?: 31,
                                IVsDefensa = ivDefensa2.toIntOrNull() ?: 31,
                                IVsAtaqueE = ivAtaqueE2.toIntOrNull() ?: 31,
                                IVsDefensaE = ivDefensaE2.toIntOrNull() ?: 31,
                                IVsVelocidad = ivVelocidad2.toIntOrNull() ?: 31,
                                EvsHp = evHP2.toIntOrNull() ?: 0,
                                EvsAtaque = evAtaque2.toIntOrNull() ?: 0,
                                EvsDefensa = evDefensa2.toIntOrNull() ?: 0,
                                EvsAtaqueE = evAtaqueE2.toIntOrNull() ?: 0,
                                EvsDefensaE = evDefensaE2.toIntOrNull() ?: 0,
                                EvsVelocidad = evVelocidad2.toIntOrNull() ?: 0,
                            )

                            val movimiento1 = Movimiento(
                                nombre = "Movimiento 1",
                                tipo = tipoSeleccionado,
                                potencia = potencia1.toIntOrNull() ?: 0,
                                categoria = categoriaSeleccionada1
                                )

                            val movimiento2 = Movimiento(
                                nombre = "Movimiento 2",
                                tipo = tipoSeleccionado2,
                                potencia = potencia2.toIntOrNull() ?: 0,
                                categoria = categoriaSeleccionada2
                            )

                            resultadoMov1 = CalcularDano(pokemon1, pokemon2, movimiento1)
                            resultadoMov2 = CalcularDano(pokemon2, pokemon1, movimiento2)
                        },
                        modifier = Modifier.fillMaxWidth()

                    ) {
                        Text("Calcular")
                    }

                    //Seccion Movimientos

                    Spacer(modifier = Modifier.height(32.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Movimiento 1", fontSize = 24.sp)

                            Spacer(modifier = Modifier.height(20.dp))



                            Row() {
                                Text(text = "Potencia:", fontSize = 20.sp)}

                            Spacer(modifier = Modifier.height(10.dp))

                            Row() {

                                BasicTextField(
                                    value = potencia1,
                                    onValueChange = { nuevoTexto: String ->
                                        if (nuevoTexto.all {it.isDigit()}){
                                            potencia1 = nuevoTexto
                                        }
                                    },singleLine = true,
                                    textStyle = TextStyle(fontSize = 20.sp, color = Color.White),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier
                                        .width(160.dp)
                                        .height(50.dp)
                                        .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                        .padding(13.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))



                            Row() {
                                Text(text = "Tipo:", fontSize = 20.sp)}

                            Spacer(modifier = Modifier.height(10.dp))

                            Row() {
                                ExposedDropdownMenuBox(
                                    expanded = expandido,
                                    onExpandedChange = { expandido = !expandido }
                                ) {
                                    OutlinedTextField(
                                        value = tipoSeleccionado.name,
                                        onValueChange = {},
                                        readOnly = true,
                                        trailingIcon = {
                                            ExposedDropdownMenuDefaults.TrailingIcon(
                                                expanded = expandido
                                            )
                                        },
                                        modifier = Modifier.menuAnchor().width(160.dp).height(56.dp)
                                    )
                                    ExposedDropdownMenu(
                                        expanded = expandido,
                                        onDismissRequest = { expandido = false }
                                    ) {
                                        Tipo.values().forEach { tipo ->
                                            DropdownMenuItem(
                                                text = { Text(tipo.name) },
                                                onClick = {
                                                    tipoSeleccionado = tipo
                                                    expandido = false
                                                }
                                            )
                                        }
                                    }
                                }

                            }

                            Spacer(modifier = Modifier.height(20.dp))



                            Row() {
                                Text(text = "Categoria:", fontSize = 20.sp)}

                            Spacer(modifier = Modifier.height(10.dp))

                            Row() {
                                ExposedDropdownMenuBox(
                                    expanded = expandidoCategoria1,
                                    onExpandedChange = { expandidoCategoria1 = !expandidoCategoria1 }
                                ) {
                                    OutlinedTextField(
                                        value = categoriaSeleccionada1.name,
                                        onValueChange = {},
                                        readOnly = true,
                                        trailingIcon = {
                                            ExposedDropdownMenuDefaults.TrailingIcon(
                                                expanded = expandidoCategoria1
                                            )
                                        },
                                        modifier = Modifier.menuAnchor().width(160.dp).height(56.dp)
                                    )
                                    ExposedDropdownMenu(
                                        expanded = expandidoCategoria1,
                                        onDismissRequest = { expandidoCategoria1 = false }
                                    ) {
                                        CategoriaDeMovimiento.values().forEach { categoria ->
                                            DropdownMenuItem(
                                                text = { Text(categoria.name) },
                                                onClick = {
                                                    categoriaSeleccionada1 = categoria
                                                    expandidoCategoria1 = false
                                                }
                                            )
                                        }
                                    }
                                }

                            }
                        }
                        Column(modifier = Modifier.weight(1f),
                                horizontalAlignment = Alignment.End
                        ) {
                            Text(text = "Movimiento 2", fontSize = 24.sp)

                            Spacer(modifier = Modifier.height(20.dp))



                            Row() {
                                Text(text = "Potencia:", fontSize = 20.sp)}

                            Spacer(modifier = Modifier.height(10.dp))

                            Row() {

                                BasicTextField(
                                    value = potencia2,
                                    onValueChange = { nuevoTexto: String ->
                                        if (nuevoTexto.all {it.isDigit()}){
                                            potencia2 = nuevoTexto
                                        }
                                    },singleLine = true,
                                    textStyle = TextStyle(fontSize = 20.sp, color = Color.White),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                    modifier = Modifier
                                        .width(160.dp)
                                        .height(50.dp)
                                        .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                        .padding(13.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))



                            Row() {
                                Text(text = "Tipo:")}

                            Spacer(modifier = Modifier.height(10.dp))

                            Row() {
                                ExposedDropdownMenuBox(
                                    expanded = expandido2,
                                    onExpandedChange = { expandido2 = !expandido2 }
                                ) {
                                    OutlinedTextField(
                                        value = tipoSeleccionado2.name,
                                        onValueChange = {},
                                        readOnly = true,
                                        trailingIcon = {
                                            ExposedDropdownMenuDefaults.TrailingIcon(
                                                expanded = expandido2
                                            )
                                        },
                                        modifier = Modifier.menuAnchor().width(160.dp).height(56.dp)

                                    )
                                    ExposedDropdownMenu(
                                        expanded = expandido2,
                                        onDismissRequest = { expandido2 = false }
                                    ) {
                                        Tipo.values().forEach { tipo ->
                                            DropdownMenuItem(
                                                text = { Text(tipo.name) },
                                                onClick = {
                                                    tipoSeleccionado2 = tipo
                                                    expandido2 = false
                                                }
                                            )
                                        }
                                    }
                                }




                            }

                            Spacer(modifier = Modifier.height(20.dp))



                            Row() {
                                Text(text = "Categoria:", fontSize = 20.sp)}

                            Spacer(modifier = Modifier.height(10.dp))

                            Row() {
                                ExposedDropdownMenuBox(
                                    expanded = expandidoCategoria2,
                                    onExpandedChange = { expandidoCategoria2 = !expandidoCategoria2 }
                                ) {
                                    OutlinedTextField(
                                        value = categoriaSeleccionada2.name,
                                        onValueChange = {},
                                        readOnly = true,
                                        trailingIcon = {
                                            ExposedDropdownMenuDefaults.TrailingIcon(
                                                expanded = expandidoCategoria2
                                            )
                                        },
                                        modifier = Modifier.menuAnchor().width(160.dp).height(56.dp)
                                    )
                                    ExposedDropdownMenu(
                                        expanded = expandidoCategoria2,
                                        onDismissRequest = { expandidoCategoria2 = false }
                                    ) {
                                        CategoriaDeMovimiento.values().forEach { categoria ->
                                            DropdownMenuItem(
                                                text = { Text(categoria.name) },
                                                onClick = {
                                                    categoriaSeleccionada2 = categoria
                                                    expandidoCategoria2 = false
                                                }
                                            )
                                        }
                                    }
                                }

                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row() {
                        //Pokemon 1
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Pokemon 1", fontSize = 24.sp)
                            Spacer(modifier = Modifier.height(10.dp))



                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("Tipo 1  ", fontSize = 18.sp)

                                Box {
                                    Box(
                                        modifier = Modifier
                                            .width(97.dp)
                                            .height(32.dp)
                                            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                            .clickable { expandidoTipo1Pokemon1 = true },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = tipo1Pokemon1.name,
                                            fontSize = 15.sp,
                                            color = Color.White
                                        )
                                    }
                                    DropdownMenu(
                                        expanded = expandidoTipo1Pokemon1,
                                        onDismissRequest = { expandidoTipo1Pokemon1 = false }
                                    ) {
                                        Tipo.values().forEach { tipo ->
                                            DropdownMenuItem(
                                                text = { Text(tipo.name) },
                                                onClick = {
                                                    tipo1Pokemon1 = tipo
                                                    expandidoTipo1Pokemon1 = false
                                                }
                                            )
                                        }
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("Tipo 2  ", fontSize = 18.sp)

                                Box {
                                    Box(
                                        modifier = Modifier
                                            .width(97.dp)
                                            .height(32.dp)
                                            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                            .clickable { expandidoTipo2Pokemon1 = true },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = tipo2Pokemon1.name,
                                            fontSize = 15.sp,
                                            color = Color.White
                                        )
                                    }
                                    DropdownMenu(
                                        expanded = expandidoTipo2Pokemon1,
                                        onDismissRequest = { expandidoTipo2Pokemon1 = false }
                                    ) {
                                        Tipo.values().forEach { tipo ->
                                            DropdownMenuItem(
                                                text = { Text(tipo.name) },
                                                onClick = {
                                                    tipo2Pokemon1 = tipo
                                                    expandidoTipo2Pokemon1 = false
                                                }
                                            )
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))



                            FilaStat("Nivel", nivel1, onValorChange =  { nivel1 = it })
                            FilaStat("HP", hp1, onValorChange = { hp1 = it })
                            FilaStat("Ataque", ataque1, onValorChange = { ataque1 = it })
                            FilaStat("Defensa", defensa1, onValorChange = { defensa1 = it })
                            FilaStat("Ataque E.", ataqueE1, onValorChange = { ataqueE1 = it })
                            FilaStat("Defensa E.", defensaE1, onValorChange = { defensaE1 = it })
                            FilaStat("Velocidad", velocidad1, onValorChange = { velocidad1 = it })



                            Column() {

                                Text(
                                    text = "Naturaleza",
                                    fontSize = 20.sp
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Box{
                                    Box(
                                        modifier = Modifier
                                            .width(160.dp)
                                            .height(40.dp)
                                            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                            .clickable { expandidoNaturaleza1 = true },
                                        contentAlignment = Alignment.Center
                                    ){
                                        Text(
                                            text = naturaleza1.name,
                                            fontSize = 18.sp,
                                            color = Color.White,
                                            textAlign = TextAlign.Center
                                        )
                                    }

                                DropdownMenu(
                                    expanded = expandidoNaturaleza1,
                                    onDismissRequest = {expandidoNaturaleza1 = false}
                                ) {
                                    Naturalezas.values().forEach { naturaleza -> DropdownMenuItem(
                                        text = {Text(naturaleza.name)},
                                        onClick = {
                                            naturaleza1 = naturaleza
                                            expandidoNaturaleza1 = false
                                        }
                                    )  }
                                }
                                }

                                Spacer(modifier = Modifier.height(20.dp))



                                Box(
                                    modifier = Modifier
                                        .width(160.dp)
                                        .height(40.dp)
                                        .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                        .clickable { mostrarEVs1 = !mostrarEVs1 },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text= if (mostrarEVs1) "EVs ▲" else "EVs ▼",
                                        fontSize = 18.sp,
                                        color = Color.White
                                    )


                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                if (mostrarEVs1) {
                                    FilaStat("EVs HP", evHP1, maximo = 252, { evHP1 = it })
                                    FilaStat("EVs At.", evAtaque1, maximo = 252,{ evAtaque1 = it })
                                    FilaStat("EVs Def.", evDefensa1, maximo = 252,{ evDefensa1 = it })
                                    FilaStat("EVs At. E.", evAtaqueE1, maximo = 252,{ evAtaqueE1 = it })
                                    FilaStat("EVs Def. E.", evDefensaE1, maximo = 252,{ evDefensaE1 = it })
                                    FilaStat("EVs Vel.", evVelocidad1, maximo = 252,{ evVelocidad1 = it })
                                }

                                Spacer(modifier = Modifier.height(10.dp))



                                Box(
                                    modifier = Modifier
                                        .width(160.dp)
                                        .height(40.dp)
                                        .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                        .clickable { mostrarIVs1 = !mostrarIVs1 },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text= if (mostrarIVs1) "IVs ▲" else "IVs ▼",
                                        fontSize = 18.sp,
                                        color = Color.White
                                    )


                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                if (mostrarIVs1) {
                                    FilaStat("IVs HP", ivHP1, maximo = 31, { ivHP1 = it })
                                    FilaStat("IVs At.", ivAtaque1, maximo = 31,{ ivAtaque1 = it })
                                    FilaStat("IVs Def.", ivDefensa1, maximo = 31,{ ivDefensa1 = it })
                                    FilaStat("IVs At. E.", ivAtaqueE1, maximo = 31,{ ivAtaqueE1 = it })
                                    FilaStat("IVs Def. E.", ivDefensaE1, maximo = 31,{ ivDefensaE1 = it })
                                    FilaStat("IVs Vel.", ivVelocidad1, maximo = 31,{ ivVelocidad1 = it })
                                }
                            }
                        }







                        //Pokemon 2
                        Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {

                            Text("Pokemon 2", fontSize = 24.sp)

                            Spacer(modifier = Modifier.height(10.dp))



                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("Tipo 1  ", fontSize = 18.sp)

                                Box {
                                    Box(
                                        modifier = Modifier
                                            .width(97.dp)
                                            .height(32.dp)
                                            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                            .clickable { expandidoTipo1Pokemon2 = true },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = tipo1Pokemon2.name,
                                            fontSize = 15.sp,
                                            color = Color.White
                                        )
                                    }
                                    DropdownMenu(
                                        expanded = expandidoTipo1Pokemon2,
                                        onDismissRequest = { expandidoTipo1Pokemon2 = false }
                                    ) {
                                        Tipo.values().forEach { tipo ->
                                            DropdownMenuItem(
                                                text = { Text(tipo.name) },
                                                onClick = {
                                                    tipo1Pokemon2 = tipo
                                                    expandidoTipo1Pokemon2 = false
                                                }
                                            )
                                        }
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("Tipo 2  ", fontSize = 18.sp)

                                Box {
                                    Box(
                                        modifier = Modifier
                                            .width(97.dp)
                                            .height(32.dp)
                                            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                            .clickable { expandidoTipo2Pokemon2 = true },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = tipo2Pokemon2.name,
                                            fontSize = 15.sp,
                                            color = Color.White
                                        )
                                    }
                                    DropdownMenu(
                                        expanded = expandidoTipo2Pokemon2,
                                        onDismissRequest = { expandidoTipo2Pokemon2 = false }
                                    ) {
                                        Tipo.values().forEach { tipo ->
                                            DropdownMenuItem(
                                                text = { Text(tipo.name) },
                                                onClick = {
                                                    tipo2Pokemon2 = tipo
                                                    expandidoTipo2Pokemon2 = false
                                                }
                                            )
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))



                            FilaStat("Nivel", nivel2, onValorChange = { nivel2 = it }, etiquetaIzquierda = false)
                            FilaStat("HP", hp2, onValorChange = { hp2 = it }, etiquetaIzquierda = false)
                            FilaStat("Ataque", ataque2, onValorChange = { ataque2 = it }, etiquetaIzquierda = false)
                            FilaStat("Defensa", defensa2, onValorChange = { defensa2 = it }, etiquetaIzquierda = false)
                            FilaStat("Ataque E.", ataqueE2, onValorChange = { ataqueE2 = it }, etiquetaIzquierda = false)
                            FilaStat("Defensa E.", defensaE2, onValorChange = { defensaE2 = it }, etiquetaIzquierda = false)
                            FilaStat("Velocidad", velocidad2, onValorChange = { velocidad2 = it }, etiquetaIzquierda = false)




                            Column() {

                                Row(modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End){
                                Text(
                                    text = "Naturaleza",
                                    fontSize = 20.sp
                                )}

                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Box {
                                        Box(
                                            modifier = Modifier
                                                .width(160.dp)
                                                .height(40.dp)
                                                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                                .clickable { expandidoNaturaleza2 = true },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = naturaleza2.name,
                                                fontSize = 18.sp,
                                                color = Color.White
                                            )
                                        }
                                        DropdownMenu(
                                            expanded = expandidoNaturaleza2,
                                            onDismissRequest = { expandidoNaturaleza2 = false }
                                        ) {
                                            Naturalezas.values().forEach { naturaleza ->
                                                DropdownMenuItem(
                                                    text = { Text(naturaleza.name) },
                                                    onClick = {
                                                        naturaleza2 = naturaleza
                                                        expandidoNaturaleza2 = false
                                                    }
                                                )
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(20.dp))





                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {

                                    Box(
                                        modifier = Modifier
                                            .width(160.dp)
                                            .height(40.dp)
                                            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                            .clickable { mostrarEVs2 = !mostrarEVs2 },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = if (mostrarEVs2) "EVs ▲" else "EVs ▼",
                                            fontSize = 18.sp,
                                            color = Color.White
                                        )


                                    }
                                }

                                    Spacer(modifier = Modifier.height(10.dp))

                                    if (mostrarEVs2) {
                                        FilaStat(
                                            "EVs HP",
                                            evHP2,
                                            maximo = 252,
                                            { evHP2 = it },
                                            etiquetaIzquierda = false
                                        )
                                        FilaStat(
                                            "EVs At.",
                                            evAtaque2,
                                            maximo = 252,
                                            { evAtaque2 = it },
                                            etiquetaIzquierda = false
                                        )
                                        FilaStat(
                                            "EVs Def.",
                                            evDefensa2,
                                            maximo = 252,
                                            { evDefensa2 = it },
                                            etiquetaIzquierda = false
                                        )
                                        FilaStat(
                                            "EVs At. E.",
                                            evAtaqueE2,
                                            maximo = 252,
                                            { evAtaqueE2 = it },
                                            etiquetaIzquierda = false
                                        )
                                        FilaStat(
                                            "EVs Def. E.",
                                            evDefensaE2,
                                            maximo = 252,
                                            { evDefensaE2 = it },
                                            etiquetaIzquierda = false
                                        )
                                        FilaStat(
                                            "EVs Vel.",
                                            evVelocidad2,
                                            maximo = 252,
                                            { evVelocidad2 = it },
                                            etiquetaIzquierda = false
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(10.dp))




                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Box(
                                    modifier = Modifier
                                        .width(160.dp)
                                        .height(40.dp)
                                        .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                        .clickable { mostrarIVs2 = !mostrarIVs2 },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = if (mostrarIVs2) "IVs ▲" else "IVs ▼",
                                        fontSize = 18.sp,
                                        color = Color.White
                                    )
                                }
                            }

                                    Spacer(modifier = Modifier.height(10.dp))

                                    if (mostrarIVs2) {
                                        FilaStat(
                                            "IVs HP",
                                            ivHP2,
                                            maximo = 31,
                                            { ivHP2 = it },
                                            etiquetaIzquierda = false
                                        )
                                        FilaStat(
                                            "IVs At.",
                                            ivAtaque2,
                                            maximo = 31,
                                            { ivAtaque2 = it },
                                            etiquetaIzquierda = false
                                        )
                                        FilaStat(
                                            "IVs Def.",
                                            ivDefensa2,
                                            maximo = 31,
                                            { ivDefensa2 = it },
                                            etiquetaIzquierda = false
                                        )
                                        FilaStat(
                                            "IVs At. E.",
                                            ivAtaqueE2,
                                            maximo = 31,
                                            { ivAtaqueE2 = it },
                                            etiquetaIzquierda = false
                                        )
                                        FilaStat(
                                            "IVs Def. E.",
                                            ivDefensaE2,
                                            maximo = 31,
                                            { ivDefensaE2 = it },
                                            etiquetaIzquierda = false
                                        )
                                        FilaStat(
                                            "IVs Vel.",
                                            ivVelocidad2,
                                            maximo = 31,
                                            { ivVelocidad2 = it },
                                            etiquetaIzquierda = false
                                        )
                                    }
                                }
                            }


                            }
                    Text(
                        text = "v${BuildConfig.VERSION_NAME}",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp))
                        }

                    }


                    }
            }


                    // Llave de la Columna de la interfaz
                }
                }







@Composable

fun FilaStat(
    nombre: String,
    valor: String,
    maximo: Int = 999,
    onValorChange: (String) -> Unit,
    etiquetaIzquierda: Boolean = true
) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (etiquetaIzquierda) Arrangement.Start else Arrangement.End
    ) {
        if (etiquetaIzquierda) {
            Text(
                text = "$nombre  ",
                fontSize = 18.sp,
                modifier = Modifier.width(110.dp)
            )
        }

        BasicTextField(
            value = valor,
            onValueChange = { nuevoTexto: String ->
                if (nuevoTexto.all { it.isDigit() } && (nuevoTexto.isEmpty() || nuevoTexto.toInt() <= maximo )) {
                    onValorChange(nuevoTexto)
                }
            },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .width(50.dp)
                .height(32.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                .padding(8.dp)
        )

        if (!etiquetaIzquierda) {
            Text(
                text = "$nombre",
                fontSize = 18.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.width(110.dp)
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))

}

