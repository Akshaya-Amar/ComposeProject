package com.amar.jetpackcomposefirst.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amar.jetpackcomposefirst.R

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
     CustomComposable("Akshaya Amar", "Android Developer")
}