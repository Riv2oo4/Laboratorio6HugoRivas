package com.example.laboratorio5hugorivas

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
import com.example.laboratorio6hugorivas.R


data class Eventos(val name: String, val artist: String, val imageId: Int,val favorite: Boolean = false )
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Myapp(listOf(
                Eventos(name = "Evento 1", artist = "AC/DC", imageId = R.drawable.evento_1),
                Eventos(name = "Evento 2", artist = "Peso pluma", imageId = R.drawable.evento_2),


                ))





            /*
            val events = listOf(
                "AC/DC" to "Hollywood Bowl",
                "Guns N Roses" to "Red Rocks",
                "Metallica" to "Gorge AmphiTheatre"
            )

            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Lista de Lugares") },

                    )
                }
            ) {
                EventList(events = events)
            }

             */


            /*
            val event = Event(
                place = "Lugar del Evento",
                name = "Título del Evento",
                date = "Fecha del Evento",
                time = "Hora del Evento",
                description = "Descripción del Evento",
                imageId = R.drawable.evento_1
            )

            EventDetail(event = event)

             */


            /*
            ProfilePage()

             */





        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEventList() {
    val events = listOf(
        "Evento 1" to "Lugar 1",
        "Evento 2" to "Lugar 2",
        "Evento 3" to "Lugar 3"
    )

    EventList(events = events)
}
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
@Composable
fun EventDetail(event: Event) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = event.imageId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = event.place,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = event.name,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(8.dp))


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = event.date)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = event.time)
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "About",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(text = event.description)
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(text = "Favorite")
            }
            Button(
                onClick = {  },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(text = "Buy")
            }
        }
    }
}
data class Event(
    val place: String,
    val name: String,
    val date: String,
    val time: String,
    val description: String,
    val imageId: Int
)
@Composable
fun ProfilePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                )


                Text(
                    text = "Hugo Rivas",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
        ) {
            ProfileSection(
                icon = Icons.Default.Person,
                title = "Edit Profile",
                showOptions = true
            )

            ProfileSection(
                icon = Icons.Default.Lock,
                title = "Reset Password",
                showOptions = true
            )

            ProfileSection(
                icon = Icons.Default.Person,
                title = "Notifications",
                toggleable = true
            )

            ProfileSection(
                icon = Icons.Default.Star,
                title = "Favorites",
                showOptions = true
            )
        }
    }
}

@Composable
fun ProfileSection(
    icon: ImageVector,
    title: String,
    toggleable: Boolean = false,
    showOptions: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null)

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            )

            if (toggleable) {

                Switch(
                    checked = true,
                    onCheckedChange = {  }
                )
            }

            if (showOptions) {

                IconButton(
                    onClick = { }
                ) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                }
            }
        }
    }
}










