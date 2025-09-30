package com.amar.jetpackcomposefirst

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.amar.jetpackcomposefirst.ui.recomposeHighlighter
import com.amar.jetpackcomposefirst.ui.theme.JetpackcomposeFirstTheme
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
//          enableEdgeToEdge()
          setContent {
               /*Text(
                    text = "hello world"
               )*/
               JetpackcomposeFirstTheme {
                    var name by remember { mutableStateOf("") }
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
/*                         Greeting(
                              name = "First composable project",
                              modifier = Modifier.padding(innerPadding)
                         )*/
//                         Sample()
                         /*Column {
                              CustomComposable()
                              CustomComposable()
                              CustomComposable()
                              CustomComposable()
                         }*/
//                         CustomComposable("Akshaya Amar", "Android Developer")
//                         PreviewItem()
//                         RecompositionSample()
//                         CounterExample()

                         /*Column(
                              modifier = Modifier
                                   .fillMaxSize()
                                   .padding(16.dp),
                              horizontalAlignment = Alignment.CenterHorizontally,
                              verticalArrangement = Arrangement.Center
                         ) {
                              TextFieldSample(name) { name = it }
                              Text(text = "Sample Text", modifier = Modifier.recomposeHighlighter())
                              Spacer(
                                   modifier = Modifier
                                        .height(16.dp)
                                        .recomposeHighlighter()
                              )
                              BoxSample(name)
                         }*/
                    }
//                    LaunchEffectComposable()
                    RememberCoroutineScopeComposable()
               }
          }
     }
}

private fun fetchList(): List<Int> {
//     return (1..10).toList()
     val numbers = (10..50).random()
     return (1..numbers).toList()
}

@Composable
fun RememberCoroutineScopeComposable() {
     var counter by remember { mutableIntStateOf(0) }
     val scope = rememberCoroutineScope()
     var job by remember { mutableStateOf<Job?>(null) }
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
               job?.cancel()
               counter = 0
               job = scope.launch {
                    try {
                         while (counter < 10) {
                              counter++
                              delay(1000)
                         }
                    } catch (exception: CancellationException) {
                         Log.d("check...", "Coroutine cancelled safely")
                    } catch (exception: Exception) {
                         Log.e("check...", "Unexpected error: ${exception.message}")
                    }
               }
          }) {
               Text(text = "Start incrementing counter from 0")
          }
     }
}

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

@Composable
fun TextFieldSample(name: String, onNameChange: (String) -> Unit) {
     LaunchedEffect(Unit) {
          val list = fetchList()
          Log.d("check...", "TextFieldSample: ${list.size}, ${Thread.currentThread().name}, $this")
     }

     OutlinedTextField(
          value = name,
          onValueChange = { onNameChange(it) },
          modifier = Modifier
               .fillMaxWidth()
               .recomposeHighlighter(),
          label = { Text(text = "Enter something") }
     )

     if (name.isNotEmpty()) {
          Text(
               text = "Hello $name",
               modifier = Modifier
                    .recomposeHighlighter()
                    .padding(16.dp)
          )
     }
}

@Composable
fun BoxSample(name: String) {
     if (name.isNotEmpty()) {
          val context = LocalContext.current
          Card(
               modifier = Modifier
                    .fillMaxWidth()
                    .clickable { Toast.makeText(context, name, Toast.LENGTH_LONG).show() }
                    .recomposeHighlighter(),
               elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
               colors = CardDefaults.cardColors(containerColor = Color.White),
               shape = RoundedCornerShape(4.dp),
          ) {
               Text(
                    modifier = Modifier.padding(16.dp),
                    text = name,
                    fontSize = 24.sp
               )
          }
     }
}

@Composable
fun RecompositionSample() {
     var count by remember { mutableIntStateOf(0) }
     val key = count % 3 == 0
     LaunchedEffect(key) {
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

/*elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), // Optional shadow
               shape = RoundedCornerShape(12.dp), // Optional rounded corners
               colors = CardDefaults.cardColors(containerColor = Color.White) // Optional background color*/
@Composable
fun CustomComposable(name: String, occupation: String) {
     val context = LocalContext.current
     Card(
          modifier = Modifier
               .fillMaxWidth()
               .padding(16.dp),
          elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          shape = RoundedCornerShape(12.dp),
          onClick = { Toast.makeText(context, name, Toast.LENGTH_LONG).show() }
     ) {
          Row(
               modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFEEEEEE)),
               verticalAlignment = Alignment.CenterVertically
          ) {
               Image(
                    modifier = Modifier
                         .size(80.dp)
                         .padding(8.dp),
                    painter = painterResource(R.drawable.clip_art),
                    contentDescription = "",
               )
               Column(
                    modifier = Modifier
                         .fillMaxWidth()
                         .padding(end = 8.dp)
//                         .padding(start = 8.dp, end = 8.dp)
//                         .padding(horizontal = 8.dp)
               ) {
                    Text(
                         text = name,
                         fontSize = 24.sp,
                         fontWeight = FontWeight.Bold
                    )
                    Text(
                         text = occupation,
                         fontSize = 18.sp
                    )
               }
          }
     }
}

@Preview(showBackground = true)
@Composable
fun CustomComposablePreview() {
     /*Column {
          CustomComposable()
          CustomComposable()
          CustomComposable()
     }*/
     CustomComposable("Akshaya Amar", "Android Developer")
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
//          using 'by' allows you to treat the state as a normal variable rather than calling .value each time like text.value
          var text by remember { mutableStateOf("") }
//          var text1 = remember { mutableStateOf("") }

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

          Card(
               modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
               onClick = {
                    Toast.makeText(context, "Card clicked", Toast.LENGTH_LONG).show()
               },
               elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), // Optional shadow
               shape = RoundedCornerShape(12.dp), // Optional rounded corners
               colors = CardDefaults.cardColors(containerColor = Color.White) // Optional background color
          ) {
               Row(
                    modifier = Modifier
                         .fillMaxWidth()
//                         .background(color = Color.LightGray),
                         .background(color = Color(0xFFEEEEEE)),
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
                              .fillMaxWidth()
                              .padding(start = 8.dp, end = 16.dp)
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
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
     Text(
          text = "Hello $name!",
          modifier = modifier
     )
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//     Sample()
     */
/*JetpackcomposeFirstTheme {
          Greeting("Android")
     }*//*

}*/
