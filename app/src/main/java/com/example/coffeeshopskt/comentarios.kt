package com.example.coffeeshopskt

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.coffeeshopskt.ui.theme.fuenteTitulo
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun comentarios(navController: NavHostController, modifier: Modifier = Modifier,titulo: String) {

    val listaComentarios = listOf(
        "El café estuvo increíble, súper recomendado.",
        "El ambiente es muy acogedor y tranquilo.",
        "Me gustó la música, ideal para trabajar.",
        "Los precios son un poco altos, pero vale la pena.",
        "El latte con almendra fue mi favorito.",
        "Muy buena atención del personal.",
        "Volvería sin dudarlo.",
        "El aroma a café recién molido es increíble.",
        "La decoración es hermosa y moderna.",
        "Excelente lugar para reunirse con amigos.",
        "El cappuccino estaba un poco frío.",
        "Tienen una gran variedad de postres.",
        "Me encantó la terraza exterior.",
        "Perfecto para pasar la tarde leyendo.",
        "WiFi rápido, ideal para estudiar.",
        "Los asientos son un poco incómodos.",
        "Las porciones son generosas.",
        "Muy limpio y ordenado.",
        "La vista desde la ventana es hermosa.",
        "Definitivamente mi cafetería favorita.",
        "El café estuvo increíble, súper recomendado.",
        "El ambiente es muy acogedor y tranquilo.",
        "Me gustó la música, ideal para trabajar.",
        "Los precios son un poco altos, pero vale la pena.",
        "El latte con almendra fue mi favorito.",
        "Muy buena atención del personal.",
        "Volvería sin dudarlo.",
        "El aroma a café recién molido es increíble.",
        "La decoración es hermosa y moderna.",
        "Excelente lugar para reunirse con amigos.",
        "El cappuccino estaba un poco frío.",
        "Tienen una gran variedad de postres.",
        "Me encantó la terraza exterior.",
        "Perfecto para pasar la tarde leyendo.",
        "WiFi rápido, ideal para estudiar.",
        "Los asientos son un poco incómodos.",
        "Las porciones son generosas.",
        "Muy limpio y ordenado.",
        "La vista desde la ventana es hermosa."
    )
    val context = LocalContext.current
    val gridState = rememberLazyStaggeredGridState()

    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = titulo,
            modifier = modifier.fillMaxWidth(),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = fuenteTitulo,
            textAlign = TextAlign.Center
        )
        LazyVerticalStaggeredGrid(
            modifier= Modifier.fillMaxSize().weight(1f),
            columns = StaggeredGridCells.Fixed(2),
            state = gridState,
            content = {
                items(listaComentarios.size) { indice ->
                    Card(
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Text(
                            text = listaComentarios[indice],
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
            })
        val showButton by remember{
            derivedStateOf {
                gridState.firstVisibleItemIndex>0
            }
        }
        val corutinesScope = rememberCoroutineScope()
        if(showButton) {
            Button(
                onClick = { corutinesScope.launch {
                    gridState.animateScrollToItem(0)
                } },
                modifier =
                    Modifier.align(Alignment.CenterHorizontally).padding(16.dp)
            ) {
                Text(text = "add new comment")
            }
        }
    }
}












