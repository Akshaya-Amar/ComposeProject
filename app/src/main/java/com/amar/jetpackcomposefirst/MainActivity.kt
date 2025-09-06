package com.amar.jetpackcomposefirst

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.text.font.FontWeight
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
     Column( // working like vertical linear layout; column means arranging vertically
          modifier = Modifier
               .fillMaxSize()
               .padding(16.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
     ) {
          Text(
               modifier = Modifier.wrapContentWidth(),
               text = "First composable project",
               fontSize = 24.sp,
//               color = Color.Red
               color = MaterialTheme.colorScheme.primary
          )

          Spacer(modifier = Modifier.height(16.dp))

          Image(
               painterResource(R.drawable.clip_art),
               contentDescription = "Dummy image"
          )

          Spacer(modifier = Modifier.height(16.dp))

          // data has to be saved in state, ui is dependent on state
          var text by remember { mutableStateOf("") }

          OutlinedTextField(
               modifier = Modifier.fillMaxWidth(),
               value = text,
               onValueChange = {
                    text = it
               },
               label = {
                    Text(text = "Enter name")
               },
               placeholder = {
                    Text(text = "Eg: Placeholder")
               },
               singleLine = true,
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
                    modifier = Modifier.padding(bottom = 8.dp, top = 16.dp),
                    style = MaterialTheme.typography.bodyMedium
               )
          }

          Row(
               modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
               horizontalArrangement = Arrangement.Center,
               verticalAlignment = Alignment.CenterVertically
          ) {
               Button(
                    onClick = {
                         Toast.makeText(context, "First", Toast.LENGTH_LONG).show()
                    }
               ) {
                    Text(
                         text = "First"
                    )
               }
               Spacer(modifier = Modifier.padding(8.dp))
               Button(
                    onClick = {
                         Toast.makeText(context, "Second", Toast.LENGTH_LONG).show()
                    }
               ) {
                    Text(
                         text = "Second"
                    )
               }
               Spacer(modifier = Modifier.padding(8.dp))
               Button(
                    onClick = {
                         Toast.makeText(context, "Third", Toast.LENGTH_LONG).show()
                    }
               ) {
                    Text(
                         text = "Third"
                    )
               }
          }

          Row(
               modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray),
               verticalAlignment = Alignment.CenterVertically
          ) {
               Image(
                    modifier = Modifier
                         .size(80.dp)
                         .padding(8.dp),
                    painter = painterResource(R.drawable.clip_art),
                    contentDescription = ""
               )
               Column(
                    modifier = Modifier
                         .padding(start = 8.dp, end = 16.dp)
                         .fillMaxWidth()
               ) {
                    Text(
                         text = "Akshaya Amar",
                         fontWeight = FontWeight.Bold,
                         fontSize = 20.sp
                    )
                    Text(
                         text = "Android Developer",
                         fontWeight = FontWeight.Normal
                    )
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
     Sample()
     /*JetpackcomposeFirstTheme {
          Greeting("Android")
     }*/
}