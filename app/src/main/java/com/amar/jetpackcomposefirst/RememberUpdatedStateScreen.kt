package com.amar.jetpackcomposefirst

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedStateAnotherExampleThird() {
     var buttonColor by remember { mutableStateOf("Not set") }

     Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
     ) {
          Button(
               onClick = { buttonColor = "Magenta" },

          ) {
               Text(text = "Magenta Color")
          }

          Spacer(modifier = Modifier.height(48.dp))

          Button(
               onClick = { buttonColor = "Blue" },
               colors = ButtonDefaults.buttonColors(Color.Blue)
          ) {
               Text(text = "Blue Color")
          }

          Timer(buttonColor)
     }
}

@Composable
fun Timer(buttonColor: String) {
     val updateButtonColor by rememberUpdatedState(buttonColor)

     LaunchedEffect(Unit) {
          delay(5000)
          Log.d("check...", "Button color is : $updateButtonColor")
     }
}

@Preview(showBackground = true)
@Composable
private fun RememberUpdatedStateAnotherExampleThirdPreview() {
     RememberUpdatedStateAnotherExampleThird()
}

fun first() {
     Log.d("check...", "This is first function")
}

fun second() {
     Log.d("check...", "This is second function")
}

@Composable
fun RememberUpdatedStateAnotherExample() {
     var state by remember { mutableStateOf(::first) }
     Button(onClick = { state = ::second }) {
          Text(text = "Click to change state")
     }

     LandingScreen(state)
}

@Composable
fun LandingScreen(onTimeout: () -> Unit) {
     val updatedOnTimeout by rememberUpdatedState((onTimeout))
     LaunchedEffect(Unit) {
          delay(5000)
          updatedOnTimeout()
     }
}

@Composable
fun RememberUpdatedStateDemo() {
     var counter by remember { mutableIntStateOf(0) }

     LaunchedEffect(Unit) {
          delay(2000)
          counter = 10
     }

     Counter(counter)
}

@Composable
fun Counter(counter: Int) {
     val updatedValue by rememberUpdatedState(counter) // latest value without recomposition
//     var updatedValue by remember { mutableIntStateOf(0) } // latest value with recomposition
//     updatedValue = counter

     LaunchedEffect(Unit) {
          Log.d("check...", "Counter before try: $counter")
          try {
               delay(5000)
               Log.d("check...", "Counter: $updatedValue")
          } catch (exception: Exception) {
               Log.d("check...", "Exception: ${exception.message}")
          }
     }

     Text(
          text = "Counter value is $counter",
          fontSize = 24.sp
     )
}
