package com.amar.jetpackcomposefirst.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StateHoistingSample() {
     var name by remember { mutableStateOf("") }
     Column(
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
     }
}

@Composable
fun TextFieldSample(name: String, onNameChange: (String) -> Unit) {
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