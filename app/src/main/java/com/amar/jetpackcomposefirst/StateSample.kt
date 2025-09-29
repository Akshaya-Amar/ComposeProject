package com.amar.jetpackcomposefirst

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun CounterExamplePreview() {
     CounterExample()
}

@Composable
fun CounterExample() {

     var count = 0
//     var count by remember { mutableIntStateOf(0) }

     Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
     ) {
          Text(
               text = "Counter value is $count",
               fontSize = 24.sp
          )

          Spacer(modifier = Modifier.height(16.dp))

          Button(onClick = {
               count++
               Log.d("check...", "CounterExample: $count")
          }) {
               Text(text = "Increment counter")
          }
     }
}
