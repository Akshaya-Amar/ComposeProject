package com.amar.jetpackcomposefirst

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffectDemo() {
     var counter by remember { mutableIntStateOf(0) }
     var selectedItem by remember { mutableStateOf("Apple") }
     var description by remember { mutableStateOf<String?>(null) }

     LaunchedEffect(selectedItem) { // selected item as a key for LaunchEffect i.e. when selectedItem changes, only then LaunchEffect runs
          try {
               description = null
               description = getFruitDescription(selectedItem)
               Log.d("check...", "FetchedData: $description")
          } catch (exception: Exception) {
               Log.d("check...", "Exception -> $exception")
          }
     }

     Column(
          modifier = Modifier
               .fillMaxSize()
               .padding(16.dp),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
     ) {
          Text(
               text = "Counter value -> $counter",
               modifier = Modifier.padding(16.dp),
               fontSize = 24.sp
          )
          Button(onClick = { counter++ }) {
               Text(text = "Increment counter")
          }

          Spacer(modifier = Modifier.height(72.dp))

          Text(
               text = selectedItem,
               modifier = Modifier.padding(16.dp),
               fontSize = 24.sp
          )
          Button(onClick = {
               selectedItem = listOf(
                    "Apple",
                    "Banana",
                    "Orange",
                    "Grapes",
                    "Strawberry",
                    "Pineapple",
                    "Mango",
                    "Watermelon",
                    "Peach",
                    "Kiwi"
               ).random()
          }) {
               Text(text = "Perform Network Operation")
          }
          Text(
               text = description ?: "Loading...",
               modifier = Modifier.padding(16.dp),
               fontSize = 24.sp
          )
     }
}

@Preview(showBackground = true)
@Composable
private fun LaunchedEffectDemoPreview() {
     LaunchedEffectDemo()
}

private suspend fun getFruitDescription(item: String): String {
     delay(1000)
     return when (item.lowercase()) {
          "apple" -> "Apple is a crisp, juicy and sweet fruit."
          "banana" -> "Banana is a soft and sweet fruit, rich in potassium."
          "orange" -> "Orange is a tangy fruit full of vitamin C."
          "grapes" -> "Grapes are small, sweet and juicy fruits."
          "strawberry" -> "Strawberry is a sweet fruit with a hint of tartness."
          "pineapple" -> "Pineapple is a tropical, sweet and tangy fruit."
          "mango" -> "Mango is a rich, sweet and tropical fruit."
          "watermelon" -> "Watermelon is a juicy and refreshing fruit."
          "peach" -> "Peach is a sweet and fragrant fruit."
          "kiwi" -> "Kiwi is a tangy fruit rich in vitamin C."
          else -> "No description available for \"$item\"."
     }
}