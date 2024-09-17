package br.com.fiap.locaweb.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.locaweb.repository.EmailRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class EmailViewModel : ViewModel() {
    private val emailRepository = EmailRepository()

    var emails by mutableStateOf(listOf<Email>())
        private set

    val favoriteEmails: List<Email>
        get() = emails.filter { it.starred }

    init {
        loadEmails()
    }

    private fun loadEmails() {
        viewModelScope.launch {
            try {
                val fetchedEmails = emailRepository.getEmails()
                emails = fetchedEmails
            } catch (e: Exception) {
                // adicionar um alert
            }
        }
    }

    fun toggleFavorite(email: Email) {
        emails = emails.map { if (it.id == email.id) email.copy(starred = !email.starred) else it }
    }

    fun searchEmails(query: String) {
        // Filtrar por nome ou assunto de acordo com a query
        emails = if (query.isEmpty()) {
            emails // Aqui seria mais correto ter uma cópia dos e-mails originais para restaurar.
        } else {
            emails.filter {
                it.subject.contains(query, ignoreCase = true) || it.sender.contains(query, ignoreCase = true)
            }
        }
    }
}
