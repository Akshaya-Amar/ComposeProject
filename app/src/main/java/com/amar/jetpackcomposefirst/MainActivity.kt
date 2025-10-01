package com.amar.jetpackcomposefirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.amar.jetpackcomposefirst.ui.CustomComposable
import com.amar.jetpackcomposefirst.ui.theme.JetpackcomposeFirstTheme

class MainActivity : ComponentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
//          enableEdgeToEdge()
          setContent {
               JetpackcomposeFirstTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                         /*Greeting(
                              name = "First composable project",
                              modifier = Modifier.padding(innerPadding)
                         )*/
//                         CustomComposable("Akshaya Amar", "Android Developer")
//                         Sample()
//                         PreviewItem()
//                         CounterExample()
//                         StateHoistingSample()
//                         RecompositionSample()
//                         LaunchEffectComposable()
//                         RememberCoroutineScopeComposable()
                         LaunchedEffectDemo()
                    }
               }
          }
     }

     @Composable
     fun Greeting(name: String, modifier: Modifier = Modifier) {
          Text(
               text = "Hello $name!",
               modifier = modifier
          )
     }

     @Preview(showBackground = true)
     @Composable
     fun GreetingPreview() {
          JetpackcomposeFirstTheme {
               Greeting("Android")
          }
     }
}
