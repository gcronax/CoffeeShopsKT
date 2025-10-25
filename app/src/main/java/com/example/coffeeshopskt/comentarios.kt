package com.example.coffeeshopskt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun comentarios(navController: NavHostController, modifier: Modifier = Modifier,titulo: String) {
    Column (modifier = Modifier.fillMaxSize(),
        ){
        Text("prueba", modifier = Modifier)
        Text("prueba", modifier = Modifier)
        Text("prueba", modifier = Modifier)
        Text("prueba", modifier = Modifier)
        Text("prueba", modifier = Modifier)
        Text("prueba", modifier = Modifier)
        Text("prueba", modifier = Modifier)
        Text("prueba", modifier = Modifier)

        Text(titulo, modifier = Modifier)

    }


}