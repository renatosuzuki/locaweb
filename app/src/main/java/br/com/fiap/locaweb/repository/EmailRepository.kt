package br.com.fiap.locaweb.repository

import br.com.fiap.locaweb.R
import br.com.fiap.locaweb.api.RetrofitClient
import br.com.fiap.locaweb.models.Email
import java.sql.Time
import java.time.LocalDate
import java.time.LocalTime
import java.util.Date

class EmailRepository {
    suspend fun getEmails(): List<Email> {
        //return RetrofitClient.apiService.getEmails()
        return listOf(
            Email(
                id = 1,
                sender = "sender1@example.com",
                receiver = "user1@example.com",
                subject = "Subject 1",
                content = "Content of email 1",
                read = false,
                starred = false,
                trashed = false,
                imageRes = R.drawable.ic_person1,
                hasEvent = true,
                eventTitle = "Alinhamento do Projeto",
                eventDate = Date(), // Data atual
                eventStartHour = Time(8, 0, 0), // 08:00 AM
                eventEndHour = Time(9, 0, 0), // 09:00 AM
                description = "Reunião para alinhamento de projeto."
            ),
            Email(
                id = 2,
                sender = "sender2@example.com",
                receiver = "user2@example.com",
                subject = "Subject 2",
                content = "Content of email 2",
                read = false,
                starred = false,
                trashed = false,
                imageRes = R.drawable.ic_person2
            ),
            Email(
                id = 3,
                sender = "sender3@example.com",
                receiver = "user3@example.com",
                subject = "Subject 3",
                content = "Content of email 3",
                read = false,
                starred = false,
                trashed = false,
                imageRes = R.drawable.ic_person4,
                hasEvent = true,
                eventTitle = "Reunião de Feedback",
                eventDate = Date(), // Data atual
                eventStartHour = Time(15, 30, 0), // 03:30 PM
                eventEndHour = Time(16, 30, 0), // 04:30 PM
                description = "Reunião para discutir feedback do projeto."
            ),
            Email(
                id = 4,
                sender = "sender4@example.com",
                receiver = "user4@example.com",
                subject = "Subject 4",
                content = "Content of email 4",
                read = false,
                starred = false,
                trashed = false,
                imageRes = R.drawable.ic_person5
            )
        )

    }
}
