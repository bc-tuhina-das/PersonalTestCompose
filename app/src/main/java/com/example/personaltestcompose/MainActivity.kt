package com.example.personaltestcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.personaltestcompose.ui.theme.PersonalTestComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO: set status icon colors to white and do a dark mode/black background :)
        enableEdgeToEdge()
        setContent {
            PersonalTestComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                        // Your UI content here
                        Greeting(
                            name = "Tuhina",
                            modifier = Modifier.padding(innerPadding)
                        )



                    }
                }
            }
        }
    }
}

@Composable
// Note: seems a modifier is needed to adjust the UI based on the screen (padding etc)
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val gradientColors = listOf(Blue, Color(0xff984aff), Color(0xffef0fff) /*...*/)
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = Color.Blue,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors
            )
        ),
        fontSize = 45.sp
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PersonalTestComposeTheme {
        Greeting("Android")
    }
}