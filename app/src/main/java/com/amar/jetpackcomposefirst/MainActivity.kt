package com.amar.jetpackcomposefirst

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amar.jetpackcomposefirst.ui.theme.JetpackcomposeFirstTheme

class MainActivity : ComponentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          enableEdgeToEdge()
          setContent {
               /*Text(
                    text = "hello world"
               )*/
               JetpackcomposeFirstTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
/*                         Greeting(
                              name = "First composable project",
                              modifier = Modifier.padding(innerPadding)
                         )*/
                         Sample()
                    }
               }
          }
     }
}

@Composable
fun Sample() {
     val context = LocalContext.current
     Column(
          modifier = Modifier
               .fillMaxSize()
               .padding(16.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
     ) {
          Text(
               text = "First composable project",
               fontSize = 24.sp,
               color = Color.Red
          )

          Spacer(modifier = Modifier.height(16.dp))

          Image(
               painterResource(R.drawable.clip_art),
               contentDescription = "Dummy image"
          )

          Spacer(modifier = Modifier.height(16.dp))

          var text by remember { mutableStateOf("") }

          OutlinedTextField(
               value = text,
               onValueChange = { text = it },
               label = {
                    Text(text = "Enter name")
               },
               placeholder = {
                    Text(text = "Eg: Placeholder")
               },
               trailingIcon = {
                    /*Image(
                         painter = painterResource(id = R.drawable.baseline_cancel_24),
                         contentDescription = "Trailing icon"
                    )*/
                    if (text.isNotEmpty()) {
                         IconButton(onClick = { text = "" }) {
                              Icon(
                                   imageVector = Icons.Default.Clear,
                                   contentDescription = "clear text"
                              )
                         }
                    }
               }
          )

          Spacer(modifier = Modifier.height(16.dp))

          Button(
               onClick = { Toast.makeText(context, text, Toast.LENGTH_LONG).show() },
               colors = ButtonDefaults.buttonColors(
//                    containerColor = Color(0xFFEE0020) // for custom color instead of using Color class
                    contentColor = Color.White
//                    contentColor = Color.Red
               )
          ) {
               Text("Click me")
          }

          Spacer(modifier = Modifier.height(16.dp))

          if (text.isNotEmpty()) {
               Text(
                    text = "Hello, $text !",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
               )
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
     Sample()
     /*JetpackcomposeFirstTheme {
          Greeting("Android")
     }*/
}