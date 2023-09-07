package com.example.laboratorio6hugorivas.uii.Conciertos.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio5hugorivas.Eventos

@Composable
fun TodoEventosApp(events: List<Eventos>){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text = "TodoEventos",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        Text(
            text = "Tus Favoritos",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(vertical = 8.dp)
        ){
            items(events.chunked(2)){
                    eventRow ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    eventRow.forEach{event -> EventCard(event)}
                }
            }
        }
        Text(
            text = "Todos los eventos",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 16.dp,bottom = 8.dp)

        )
        LazyColumn(
            contentPadding = PaddingValues(vertical = 8.dp)
        ){
            items(events){
                    event -> EventCard(event)
            }
        }
    }
}

@Composable
fun EventCard(event: Eventos){
    var isFavorite by remember { mutableStateOf(event.favorite) }
    Card(

        modifier = Modifier
            .width(200.dp)
            .padding(8.dp),


        ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ){
            Image(
                painter = painterResource(id = event.imageId),
                contentDescription  = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(
                        MaterialTheme.shapes.medium
                    )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = event.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = event.artist,
                fontSize = 14.sp,
                color = Color.White
            )
            Button(
                onClick = {isFavorite = !isFavorite}
            ){
                Text(
                    text =
                    if (event.favorite)"Quitar de favoritos" else "Agregar a favoritos"
                )
            }
        }

    }
}


@Composable
fun Myapp(events: List<Eventos>){
    val favoritos = events.filter{it.favorite}
    val todosEventos = events
    MaterialTheme(
        colorScheme = darkColorScheme()
    ){
        TodoEventosApp(events)

    }
}