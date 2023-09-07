package com.example.laboratorio6hugorivas.uii.Favoritos.model

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.laboratorio5hugorivas.Myapp
import com.example.laboratorio6hugorivas.R


data class Eventos(val name: String, val artist: String, val imageId: Int,val favorite: Boolean = false )
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val event = Event(
                place = "Lugar del Evento",
                name = "Título del Evento",
                date = "Fecha del Evento",
                time = "Hora del Evento",
                description = "Descripción del Evento",
                imageId = R.drawable.evento_1
            )

            EventDetail(event = event)









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