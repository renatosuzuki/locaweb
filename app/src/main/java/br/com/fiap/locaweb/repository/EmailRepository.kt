package br.com.fiap.locaweb.repository

import br.com.fiap.locaweb.R
import br.com.fiap.locaweb.api.RetrofitClient
import br.com.fiap.locaweb.models.Email

class EmailRepository {
    suspend fun getEmails(): List<Email> {
        //return RetrofitClient.apiService.getEmails()
        return listOf(
            Email(id = 1, sender = "sender1@example.com", receiver = "user1@example.com", subject = "Subject 1", content = "Content of email 1", read = false, starred = false, trashed = false, imageRes = R.drawable.ic_person1),
            Email(id = 2, sender = "sender2@example.com", receiver = "user2@example.com", subject = "Subject 2", content = "Content of email 2", read = false, starred = false, trashed = false, imageRes = R.drawable.ic_person2),
            Email(id = 3, sender = "sender3@example.com", receiver = "user3@example.com", subject = "Subject 3", content = "Content of email 3", read = false, starred = false, trashed = false, imageRes = R.drawable.ic_person4)
        )
    }
}
