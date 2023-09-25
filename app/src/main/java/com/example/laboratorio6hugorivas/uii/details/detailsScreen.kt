package com.example.laboratorio6hugorivas.uii.details


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import com.example.laboratorio6hugorivas.R
import com.example.laboratorio6hugorivas.navigation.AppScreens


data class Eventos(val name: String, val artist: String, val imageId: Int,val favorite: Boolean = false )

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavController){
    Scaffold {
        BodyContent(navController)
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyContent(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detalles") },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.navigate(route = AppScreens.conciertosScreen.route) }
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Forward")
                    }
                },
                actions = {
                    IconButton(
                        onClick = { navController.navigate(route = AppScreens.favoritesScreen.route) }
                    ) {
                        Icon(Icons.Default.ArrowForward, contentDescription = "Forward")
                    }
                }
            )
        }
    ) {

        val events = listOf(
            "Evento 1" to "Lugar 1",
            "Evento 2" to "Lugar 2",
            "Evento 3" to "Lugar 3"
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(events) { event ->
                EventItem(name = event.first, place = event.second)
            }
        }
    }
}
@Composable
fun EventItem(name: String, place: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .padding(end = 8.dp)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = name,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = place)
        }

        Row(
            modifier = Modifier
                .padding(start = 8.dp)
                .wrapContentWidth(Alignment.End),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            IconButton(
                onClick = {  }
            ) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Más opciones")
            }
        }
    }
}
/*
@Composable
fun EventList(events: List<Pair<String, String>>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(events) { event ->
            EventItem(name = event.first, place = event.second)
        }
    }
}

 */




