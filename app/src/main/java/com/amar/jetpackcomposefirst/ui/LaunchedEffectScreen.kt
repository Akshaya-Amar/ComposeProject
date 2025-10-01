package com.amar.jetpackcomposefirst.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun LaunchEffectComposable() {
     var counter by rememberSaveable { mutableIntStateOf(0) }
     LaunchedEffect(Unit) {
          try {
               for (i in 1..10) {
                    counter++
                    delay(1000)
               }
          } catch (exception: Exception) {
               Log.d("check...", "LaunchEffectComposable: Exception -> ${exception.message}")
          }
     }

     val text = if (counter == 10) {
          "Counter Stopped"
     } else {
          "Counter running -> $counter"
     }

     Text(text = text)
}

@Preview(showBackground = true)
@Composable
private fun LaunchedEffectComposable() {
     LaunchEffectComposable()
}

@Composable
fun RecompositionSample() {
     var count by remember { mutableIntStateOf(0) }
     val key = count % 3 == 0
     LaunchedEffect(key) { // it will be excuted whenever the state changes(key in this case)
          val list = fetchList()
          Log.d("check...", "List Size: ${list.size}, ${Thread.currentThread().name}, $this")
          Log.d("check...", "RecompositionSample: before column, $count")
     }
     Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
     ) {
          Text(
               text = "Counter -> $count",
               fontSize = 24.sp
          )

          Spacer(modifier = Modifier.height(24.dp))

          Button(onClick = { count++ }) {
               Text(text = "Increment the counter")
          }
     }
}

@Preview(showBackground = true)
@Composable
fun RecompositionPreview() {
     RecompositionSample()
}

private fun fetchList(): List<Int> {
//     return (1..10).toList()
     val numbers = (10..50).random()
     return (1..numbers).toList()
}