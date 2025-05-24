package com.example.esanavalospc01.HOME

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties

@Composable
fun EdadCanina() {
    var edad by remember { mutableStateOf("") }
    var tamano by remember { mutableStateOf("Mediano") }
    var edadCanina by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val tam = listOf("Pequeño", "Mediano", "Grande")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Calculadora de Edad Canina",
            style = MaterialTheme.typography.titleLarge
        )

        TextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad (años humanos)") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Text(text = "Tamaño de la Mascota")

        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Text(text = tamano)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                properties = PopupProperties(focusable = true)
            ) {
                tam.forEach { label ->
                    DropdownMenuItem(
                        text = { Text(text = label) },
                        onClick = {
                            tamano = label
                            expanded = false
                        }
                    )
                }
            }
        }

        Button(
            onClick = {
                val edadHumana = edad.toIntOrNull() ?: 0
                edadCanina = when (tamano) {
                    "Pequeño" -> (edadHumana * 5).toString()
                    "Mediano" -> (edadHumana * 6).toString()
                    "Grande" -> (edadHumana * 7).toString()
                    else -> ""
                }
            }
        ) {
            Text("Calcular")
        }

        if (edadCanina.isNotEmpty()) {
            Text(text = "Edad canina: $edadCanina años", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

