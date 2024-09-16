package br.com.fiap.locaweb.api

import br.com.fiap.locaweb.models.Email
import retrofit2.http.GET

interface EmailApiService {
    @GET("/emails")
    suspend fun getEmails(): List<Email>
}
