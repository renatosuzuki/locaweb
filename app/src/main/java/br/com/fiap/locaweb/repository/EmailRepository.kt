package br.com.fiap.locaweb.repository

import br.com.fiap.locaweb.R
import br.com.fiap.locaweb.api.RetrofitClient
import br.com.fiap.locaweb.models.Email
import br.com.fiap.locaweb.models.UserPreference
import retrofit2.Response
import java.sql.Time
import java.time.LocalDate
import java.time.LocalTime
import java.util.Date
import java.util.prefs.Preferences

class EmailRepository {
    suspend fun getEmails() = RetrofitClient.apiService.getEmails()
}
