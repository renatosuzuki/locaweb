package br.com.fiap.locaweb.api

import br.com.fiap.locaweb.models.Email
import retrofit2.Response
import retrofit2.http.GET

interface EmailApiService {
    @GET("/emails/all")
    suspend fun getEmails(): Response<List<Email>>
}
