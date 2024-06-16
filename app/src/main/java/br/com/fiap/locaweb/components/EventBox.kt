package br.com.fiap.locaweb.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EventComponent(title: String, date: String, link: String, onRsvpClick: (String) -> Unit) {
    var message by remember { mutableStateOf(TextFieldValue("")) }
    var showAddToCalendar by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White)
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {
        Text(text = title, fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = date, fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = link, fontSize = 16.sp, color = Color.Blue)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "RSVP para este evento", fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray)
                .padding(8.dp)
        ) {
            BasicTextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier.fillMaxSize(),
                decorationBox = { innerTextField ->
                    if (message.text.isEmpty()) {
                        Text(text = "Adicionar uma mensagem (opcional)", color = Color.Gray)
                    }
                    innerTextField()
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                onRsvpClick("Sim")
                showAddToCalendar = true
            }) {
                Text(text = "Sim")
            }
            Button(onClick = { onRsvpClick("Não") }) {
                Text(text = "Não")
            }
            Button(onClick = {
                onRsvpClick("Talvez")
                showAddToCalendar = true
            }) {
                Text(text = "Talvez")
            }
        }

        if (showAddToCalendar) {
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow)
                    .padding(16.dp)
            ) {
                Text(text = "Adicionar evento ao calendário", fontSize = 16.sp, color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        EventComponent(
            title = "Reunião de Projeto",
            date = "12 de Junho de 2024",
            link = "https://meet.google.com/abc-defg-hij",
            onRsvpClick = { response ->
                // Handle RSVP click
            }
        )
}