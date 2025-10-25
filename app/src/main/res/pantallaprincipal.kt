package com.example.coffeshops

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class imgenes(
    val nombre: String,
    val direccion: Int
)
@Composable
fun principal(navController: NavHostController, modifier: Modifier = Modifier) {
    val imagenSeleccionada by remember {
        mutableStateOf(listOf(
            imgenes(
                "María Mata",
                R.drawable.images
            ),
            imgenes(
                "Antonio Sanz",
                R.drawable.images1
            ),
        ))
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(imagenSeleccionada.size) { index ->
//            rows(imagenSeleccionada[index])
            Card (modifier.fillMaxWidth()){
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = imagenSeleccionada[index].direccion),
                    contentDescription = "Imagen por defecto",
                    modifier = Modifier
                        .size(250.dp)
                        .padding(10.dp)
                        //.crop
                )
            }
        }
    }
}