package br.com.fiap.locaweb.components

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.provider.CalendarContract
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.locaweb.Event
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@Composable
fun EventBox(event: Event?, onRsvpClick: (String) -> Unit) {
    var message by remember { mutableStateOf(TextFieldValue("")) }
    var showAddToCalendar by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Box(modifier = Modifier.background(Color.LightGray, shape = RoundedCornerShape(16.dp))) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.LightGray)
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
        ) {
            Text(text = event!!.title, fontSize = 20.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "${event.date} ${event.startTime} - ${event.endTime}",
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = event.link, fontSize = 16.sp, color = Color.Blue)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "RSVP para este evento", fontSize = 16.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.LightGray)
                    .padding(8.dp)
            ) {
                OutlinedTextField(
                    value = message,
                    onValueChange = { message = it },
                    modifier = Modifier.fillMaxSize(),
                    placeholder = {
                        Text(
                            "Adicionar uma mensagem (opcional)",
                            color = Color.Black
                        )
                    },
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
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
                        .background(Color(0xfff0E6BA8), shape = RoundedCornerShape(16.dp))
                        .padding(16.dp)
                        .clickable {
                            val startTime = parseDate("${event.date} ${event.startTime}")
                            val endTime = parseDate("${event.date} ${event.endTime}")

                            addEventToCalendar(
                                context = context,
                                title = event.title,
                                description = message.text,
                                location = event.link,
                                startTime = startTime,
                                endTime = endTime
                            )
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Adicionar evento ao calendário",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

fun addEventToCalendar(
    context: Context,
    title: String,
    description: String,
    location: String,
    startTime: Long,
    endTime: Long
) {
    val values = ContentValues().apply {
        put(CalendarContract.Events.DTSTART, startTime)
        put(CalendarContract.Events.DTEND, endTime)
        put(CalendarContract.Events.TITLE, title)
        put(CalendarContract.Events.DESCRIPTION, description)
        put(CalendarContract.Events.CALENDAR_ID, 1)
        put(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.getDefault().id)
        put(CalendarContract.Events.EVENT_LOCATION, location)
    }

    val uri = context.contentResolver.insert(CalendarContract.Events.CONTENT_URI, values)

    if (uri != null) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = uri
        }
        context.startActivity(intent)
    } else {
        println("Failed to create event")
    }
}

fun parseDate(dateStr: String): Long {
    val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    return formatter.parse(dateStr)?.time ?: 0L
}