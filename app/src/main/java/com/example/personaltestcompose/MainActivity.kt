package com.example.personaltestcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.personaltestcompose.ui.theme.PersonalTestComposeTheme

/*
* TODO:
*  1. Address focus change when focus is lost from the keyboard
*  2. Check that size is fixed on the outlined text fields
*  3. Figure out how to style the status bar
*  4. Figure out themes; see if I can get a night/dark mode for this app as well :)
*/

// Just a comment to say that I'm working on this from my personal device to practice using Git
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO: set status icon colors to white and do a dark mode/black background :)
        enableEdgeToEdge()
        setContent {
            PersonalTestComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                        Column (
                            modifier = Modifier
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ){
                            val username = remember { mutableStateOf("") }
                            val password = remember { mutableStateOf("") }
                            val focusManager = LocalFocusManager.current

                            Column(
                                modifier = Modifier
                                    .padding(20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                Greeting(
                                    modifier = Modifier.padding(10.dp)
                                )

                                OutlinedTextField(
                                    value = username.value,
                                    onValueChange = { username.value = it },
                                    label = { Text("Username") },
                                    modifier = Modifier.fillMaxWidth(0.9f).padding(10.dp)
                                )
                                OutlinedTextField(
                                    value = password.value,
                                    onValueChange = { password.value = it },
                                    label = { Text("Password") },
                                    modifier = Modifier
                                        .fillMaxWidth(0.9f)
                                        .padding(10.dp)
                                        .onFocusChanged { focusState ->
                                            if (!focusState.isFocused){
                                                focusManager.clearFocus()
                                            }
                                        }
                                )

                                Button(
                                    onClick = {
                                        Log.i("Button Click", "Wow a button was clicked!")
                                    },
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .requiredWidth(100.dp)
                                        .requiredHeight(40.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xff984aff)
                                    )
                                ) {
                                    Text("Log In")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
// Note: seems a modifier is needed to adjust the UI based on the screen (padding etc)
fun Greeting(modifier: Modifier = Modifier) {
    val gradientColors = listOf(Blue, Color(0xff984aff), Color(0xffef0fff) /*...*/)
    Text(
        text = "Hello, user!",
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


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    PersonalTestComposeTheme {
//        Greeting("Android")
//    }
//}

@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Filled")
    }
}