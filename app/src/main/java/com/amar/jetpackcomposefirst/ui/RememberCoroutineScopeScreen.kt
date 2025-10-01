package com.amar.jetpackcomposefirst.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

@Composable
fun RememberCoroutineScopeComposable() {
     var counter by remember { mutableIntStateOf(0) }
     val scope = rememberCoroutineScope()
     var counterJob by remember { mutableStateOf<Job?>(null) }
     val text = if (counter == 10) {
          "Counter Stopped"
     } else {
          "Counter is -> $counter"
     }
     Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
     ) {
          Text(
               text = text,
               modifier = Modifier.padding(12.dp),
               fontSize = 24.sp
          )
          Button(onClick = {
               counterJob?.cancel()
               counter = 0
               counterJob = scope.launch {
                    try {
                         Log.d("check...", "Counter started")
                         while (counter < 10) {
                              counter++
                              delay(1000)
                         }
                         Log.d("check...", "Counter finished")
                    } catch (exception: CancellationException) {
                         Log.d("check...", "Coroutine cancelled safely, message -> ${exception.message}")
                    } catch (exception: Exception) {
                         Log.e("check...", "Unexpected error: ${exception.message}")
                    }
               }
          }) {
               Text(text = "Start incrementing counter")
          }
     }
}

@Preview(showBackground = true)
@Composable
private fun RememberCoroutineScopeComposablePreview() {
     RememberCoroutineScopeComposable()
}