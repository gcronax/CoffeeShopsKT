package com.example.coffeeshopskt

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class cartas(
    val titulo: String,
    val direccion: Int,
    val subbit: String
)
@Composable
fun principal(navController: NavHostController, modifier: Modifier = Modifier,titulo: (String) -> Unit) {

    val cartaSelect by remember {
        mutableStateOf(
            listOf(
                cartas("Antico Caffè Greco", R.drawable.images, "St. Italy, Rome"),
                cartas("Coffee Room", R.drawable.images1, "St. Germany, Berlin"),
                cartas("Coffee Ibiza", R.drawable.images2, "St. Colon, Madrid"),
                cartas("Pudding Coffee Shop", R.drawable.images3, "St. Diagonal, Barcelona"),
                cartas("L'Express", R.drawable.images4, "St. Picadilly Circus, London"),
                cartas("Coffee Corner", R.drawable.images5, "St. Ángel Guimera, Valencia"),
                cartas("Sweet Cup", R.drawable.images6, "St. Kinkerstraat, Amsterdam")
            )
        )
    }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        items(cartaSelect.size) { index ->
            Card(Modifier.fillMaxWidth().padding(10.dp)
                .clickable(onClick = {
                    navController.navigate("Comentarios")
                    titulo(cartaSelect[index].titulo)
                }))
            {
                Image(
                    painter = painterResource(id = cartaSelect[index].direccion),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = cartaSelect[index].titulo,
                    modifier = Modifier.padding(horizontal = 12.dp),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
                var estadoRating by rememberSaveable { mutableFloatStateOf(0f) }
                RatingBar( onStarselected = {estadoRating = it},5,estadoRating)

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = cartaSelect[index].subbit,
                    modifier = Modifier.padding(horizontal = 12.dp),
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
                HorizontalDivider()
                TextButton(onClick = { }, modifier = Modifier
                ) {
                    Text("RESERVE")
                }


            }
        }
    }
}
@Composable
fun RatingBar(
    onStarselected: (Float) -> Unit,
    stars: Int ,
    rating: Float
){
    Row{
        for (i in 1..stars){
            Icon(
                modifier = Modifier
                    .size(30.dp)
//                    .weight(1f)
                    .clickable{onStarselected(i.toFloat())}
                    .padding(4.dp),
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = if (i <= rating) Color.Red else Color.Gray
            )
        }
    }
}