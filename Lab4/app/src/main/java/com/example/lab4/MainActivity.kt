package com.example.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lab4.ui.theme.Lab4Theme
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Greeting(
                            name = "Головченко"
                        )
                        ShowFigure()
                        GreetingWithFlag()
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        style = MaterialTheme.typography.headlineLarge,
        modifier = modifier
    )
}

@Composable
fun ShowFigure() {
    Image(
        painter = painterResource(id = R.drawable.figure),
        contentDescription = "Figure",
        modifier = Modifier.size(150.dp)
    )
}



@Composable
fun GreetingWithFlag() {
    // Отримуємо Context і конфігурацію
    val context = LocalContext.current
    val configuration = context.resources.configuration
    val locale = configuration.locales[0]  // головна мова системи

    // Створюємо новий Context для актуальної локалі
    val localizedContext = remember(locale) {
        context.createConfigurationContext(configuration)
    }

    // Беремо текст з ресурсів для поточної мови
    val surname = localizedContext.resources.getString(R.string.surname)

    val isUkrainian = locale.language == "uk"
    val flagRes = if (isUkrainian) R.drawable.flag_ukr else R.drawable.flag_usa
    val coatRes = if (isUkrainian) R.drawable.coat_of_arms_ukr else R.drawable.coat_of_arms_usa

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(
            text = surname,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(modifier = Modifier.padding(top = 4.dp)) {
            Image(
                painter = painterResource(id = flagRes),
                contentDescription = "Flag",
                modifier = Modifier.size(80.dp)
            )
            Image(
                painter = painterResource(id = coatRes),
                contentDescription = "Coat of arms",
                modifier = Modifier.size(80.dp)
            )
        }
    }

}