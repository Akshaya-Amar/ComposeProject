package com.amar.jetpackcomposefirst

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

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
     Log.d("check...", "updated value -> $updatedValue")
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

     Column {

          Text(
               text = "Counter value is $counter",
               fontSize = 24.sp
          )

          Text(text = "Updated value is $updatedValue")
     }
}