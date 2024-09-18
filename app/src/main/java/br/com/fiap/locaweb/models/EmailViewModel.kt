package br.com.fiap.locaweb.models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.locaweb.repository.EmailRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class EmailViewModel : ViewModel() {
    private val emailRepository = EmailRepository()

    var emails by mutableStateOf(listOf<Email>())
        private set

    private var originalEmails = listOf<Email>()

    val favoriteEmails: List<Email>
        get() = emails.filter { it.starred }

    init {
        this.loadEmails()
    }

    private fun loadEmails() {
        viewModelScope.launch {
            try {
                val response = emailRepository.getEmails()

                if (response.isSuccessful) {
                    response.body()?.let { fetchedEmails ->
                        emails = fetchedEmails
                        originalEmails = fetchedEmails
                    }
                } else {
                    println("Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun toggleFavorite(email: Email) {
        emails = emails.map { if (it.id == email.id) email.copy(starred = !email.starred) else it }
    }

    fun searchEmails(query: String) {
        emails = if (query.isEmpty()) {
            originalEmails
        } else {
            originalEmails.filter {
                it.subject.contains(query, ignoreCase = true) ||
                        it.sender.contains(query, ignoreCase = true)
            }
        }
    }
}