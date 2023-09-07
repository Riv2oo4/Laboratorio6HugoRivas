package com.example.laboratorio6hugorivas.uii.Lugares.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio6hugorivas.R

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