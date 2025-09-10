package com.amar.jetpackcomposefirst

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PreviewItem() {
     /*BlogCategory(
          img = R.drawable.clip_art,
          title = "Akshaya Amar",
          subtitle = "Android Developer"
     )*/

     /*Column(modifier = Modifier.verticalScroll(rememberScrollState())){
          getCategoryList().map { item ->
               BlogCategory(
                    img = item.img,
                    title = item.title,
                    subtitle = item.subtitle
               )
          }
     }*/

     // passing item.img, item.title and item.subtitle, instead of whole item object because if child composables only take the fields they actually need (rather than a large object), Compose can skip unnecessary recompositions more effectively.
     LazyColumn {
          items(getCategoryList()) { item ->
               BlogCategory(
                    img = item.img,
                    title = item.title,
                    subtitle = item.subtitle
               )
          }
     }
}

@Composable
fun BlogCategory(img: Int, title: String, subtitle: String) {
     Card(
          modifier = Modifier
               .fillMaxWidth()
               .padding(8.dp),
          elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
          colors = CardDefaults.cardColors(containerColor = Color.White),
          shape = RoundedCornerShape(8.dp)
     ) {
          Row(
               modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
               verticalAlignment = Alignment.CenterVertically
          ) {
               Image(
                    modifier = Modifier
                         .size(48.dp),
                    painter = painterResource(img),
                    contentDescription = ""
               )
               Column(
                    modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = 8.dp)
               ) {
                    Text(
                         text = title,
                         fontSize = 20.sp,
                         fontWeight = FontWeight.Bold
                    )
                    Text(
                         text = subtitle,
                         fontSize = 16.sp
                    )
               }
          }
     }
}

data class Category(
     val img: Int,
     val title: String,
     val subtitle: String
)

fun getCategoryList(): List<Category> {
     return listOf(
          Category(R.drawable.first, "First", "Android Developer"),
          Category(R.drawable.second, "Second", "iOS Developer"),
          Category(R.drawable.third, "Third", "Web Developer"),
          Category(R.drawable.forth, "Forth", "Backend Engineer"),
          Category(R.drawable.fifth, "Fifth", "UI/UX Designer"),
          Category(R.drawable.sixth, "Sixth", "Data Scientist"),
          Category(R.drawable.first, "Seventh", "DevOps Engineer"),
          Category(R.drawable.second, "Eighth", "Cloud Architect"),
          Category(R.drawable.third, "Ninth", "Machine Learning Engineer"),
          Category(R.drawable.forth, "Tenth", "Game Developer"),
          Category(R.drawable.fifth, "Eleventh", "Security Analyst"),
          Category(R.drawable.sixth, "Twelfth", "Full Stack Developer"),
          Category(R.drawable.first, "Thirteenth", "AI Researcher"),
          Category(R.drawable.second, "Fourteenth", "Product Manager"),
          Category(R.drawable.third, "Fifteenth", "QA Engineer"),
          Category(R.drawable.forth, "Sixteenth", "Software Architect"),
          Category(R.drawable.fifth, "Seventeenth", "Business Analyst"),
          Category(R.drawable.sixth, "Eighteenth", "Scrum Master"),
          Category(R.drawable.first, "Nineteenth", "Technical Writer"),
          Category(R.drawable.second, "Twentieth", "Blockchain Developer"),
          Category(R.drawable.third, "Twenty-First", "Network Engineer"),
          Category(R.drawable.forth, "Twenty-Second", "AR/VR Developer"),
          Category(R.drawable.fifth, "Twenty-Third", "Mobile App Tester"),
          Category(R.drawable.sixth, "Twenty-Fourth", "Penetration Tester"),
          Category(R.drawable.first, "Twenty-Fifth", "Solutions Architect"),
          Category(R.drawable.second, "Twenty-Sixth", "Database Admin"),
          Category(R.drawable.third, "Twenty-Seventh", "IT Support"),
          Category(R.drawable.forth, "Twenty-Eighth", "Systems Analyst"),
          Category(R.drawable.fifth, "Twenty-Ninth", "IoT Engineer"),
          Category(R.drawable.sixth, "Thirtieth", "Digital Marketer"),
          Category(R.drawable.first, "Thirty-First", "SEO Specialist"),
          Category(R.drawable.second, "Thirty-Second", "Content Creator"),
          Category(R.drawable.third, "Thirty-Third", "Technical Recruiter"),
          Category(R.drawable.forth, "Thirty-Fourth", "Game Designer"),
          Category(R.drawable.fifth, "Thirty-Fifth", "Data Engineer"),
          Category(R.drawable.sixth, "Thirty-Sixth", "SRE Engineer"),
          Category(R.drawable.first, "Thirty-Seventh", "Automation Engineer"),
          Category(R.drawable.second, "Thirty-Eighth", "Software Tester"),
          Category(R.drawable.third, "Thirty-Ninth", "Firmware Engineer"),
          Category(R.drawable.forth, "Fortieth", "Embedded Systems Engineer"),
          Category(R.drawable.fifth, "Forty-First", "Tech Evangelist"),
          Category(R.drawable.sixth, "Forty-Second", "Computer Vision Engineer"),
          Category(R.drawable.first, "Forty-Third", "Robotics Engineer"),
          Category(R.drawable.second, "Forty-Fourth", "NLP Engineer"),
          Category(R.drawable.third, "Forty-Fifth", "VR Artist"),
          Category(R.drawable.forth, "Forty-Sixth", "3D Modeler"),
          Category(R.drawable.fifth, "Forty-Seventh", "Animation Developer"),
          Category(R.drawable.sixth, "Forty-Eighth", "Mobile Game Developer"),
          Category(R.drawable.first, "Forty-Ninth", "Tech Blogger"),
          Category(R.drawable.second, "Fiftieth", "Open Source Contributor")
     )
}

/*What Should You Do?
When to Pass Individual Properties:

When each composable only needs a few specific values.

To enhance composability, reusability, and performance (avoiding unnecessary recomposition).

When designing smaller, focused UI components.

When Passing the Whole Object Makes Sense:

If the composable truly depends on multiple or evolving fields.

When passing a class reduces boilerplate without hurting performance.

When maintaining readability is more important than preventing minor recompositions.

Summary Table
Scenario	Preferred Choice	Reasoning
Simple composables needing just 2–3 props	Pass individual values	Cleaner, more reusable, better for recomposition control
Complex or evolving props list	Pass data object	Less boilerplate, scalable
Performance-critical recomposition scenarios	Pass individual values	Fine-grained control allows skipping updates
Final Recommendation for BlogCategory

If your composable only needs img, title, and subtitle, it's best practice to pass just those fields explicitly for clearer intent and optimized recomposition.

BlogCategory(
    img = item.img,
    title = item.title,
    subtitle = item.subtitle
)


That said, if your Category data class isn't going to grow and you're okay with passing a bit more at once, BlogCategory(category: Category) is also acceptable—but keep in mind the trade-offs.*/