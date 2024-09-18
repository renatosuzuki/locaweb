package br.com.fiap.locaweb.api

import br.com.fiap.locaweb.models.Email
import br.com.fiap.locaweb.models.UserPreference
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EmailApiService {
    @GET("/emails/all")
    suspend fun getEmails(): Response<List<Email>>

//    @POST("/preferences")
//    suspend fun postPreferences(@Body preference: UserPreference): Response<Unit>
//
//    @GET("/preferences/{id}")
//    suspend fun getPreferences(@Path("id") id: Long): Response<UserPreference>
}
