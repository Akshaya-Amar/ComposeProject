package com.amar.jetpackcomposefirst.ui

import android.widget.Toast
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amar.jetpackcomposefirst.R

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