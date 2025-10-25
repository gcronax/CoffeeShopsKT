package com.example.coffeeshopskt

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeeshopskt.ui.theme.CoffeeShopsTheme
import com.example.coffeeshopskt.ui.theme.PurpleGrey80

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeShopsTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "CoffeeShops") },
                            colors= TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            ),
                            navigationIcon = {
                                IconButton(onClick = { /*TODO*/}) {
                                    Icon(imageVector = Icons.Filled.Menu,
                                        contentDescription = "Back")
                                }
                            },
                            actions = {
                                IconDropDownMenu(modifier = Modifier)
                            }
                        )
                    },
                )
                { innerPadding ->
                    var tituloPasado by rememberSaveable { mutableStateOf("") }
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Principal") {
                        composable("Principal") {principal(navController,
                            Modifier.padding(innerPadding),{tituloPasado = it})  }
                        composable("Comentarios") {comentarios(navController,
                            Modifier.padding(innerPadding),tituloPasado)  }

                    }

                }
            }
        }
    }
}
@Composable
fun IconDropDownMenu(modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Column(Modifier.padding(20.dp)) {
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(imageVector = Icons.Filled.MoreVert,
                contentDescription = "Buscar",
                tint=PurpleGrey80
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
//            modifier = modifier.align(Alignment.End)
        ) {
            DropdownMenuItem(
                onClick = { expanded = false },
                leadingIcon ={
                    Icon(imageVector = Icons.Filled.Share,
                    contentDescription = "Compartir")
                             },
                text = {Text(text = "Compartir")}

            )
            DropdownMenuItem(
                onClick = { expanded = false },
                leadingIcon ={
                    Icon(imageVector = Icons.Filled.Lock,
                    contentDescription = "Compartir")
                             },
                text = {Text(text = "Album")},

            )

        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    CoffeeShopsTheme {
//        Greeting("Android")
//    }
//}