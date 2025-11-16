package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.lab5.ui.theme.Lab5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CalculatorScreen()
                }
            }
        }
    }
}

@Composable
fun CalculatorScreen() {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Поля вводу чисел
        OutlinedTextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Число 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Число 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Результат
        Text(text = "Результат: $result", style = MaterialTheme.typography.headlineSmall)

        // Кнопки операцій
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(modifier = Modifier.weight(1f), onClick = {
                result = calculate(number1, number2, "+")
            }) { Text("+") }

            Button(modifier = Modifier.weight(1f), onClick = {
                result = calculate(number1, number2, "-")
            }) { Text("-") }

            Button(modifier = Modifier.weight(1f), onClick = {
                result = calculate(number1, number2, "*")
            }) { Text("*") }

            Button(modifier = Modifier.weight(1f), onClick = {
                result = calculate(number1, number2, "/")
            }) { Text("/") }
        }

        // Кнопки очистити та вихід
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(modifier = Modifier.weight(1f), onClick = {
                number1 = ""
                number2 = ""
                result = ""
            }) { Text("Очистити") }

            Button(modifier = Modifier.weight(1f), onClick = {
                // Вихід із додатку
                System.exit(0)
            }) { Text("Вихід") }
        }
    }
}

fun calculate(num1: String, num2: String, operation: String): String {
    return try {
        val n1 = num1.toDouble()
        val n2 = num2.toDouble()
        when (operation) {
            "+" -> (n1 + n2).toString()
            "-" -> (n1 - n2).toString()
            "*" -> (n1 * n2).toString()
            "/" -> if (n2 != 0.0) (n1 / n2).toString() else "Помилка: Ділення на 0"
            else -> ""
        }
    } catch (e: Exception) {
        "Помилка: некоректні дані"
    }
}
