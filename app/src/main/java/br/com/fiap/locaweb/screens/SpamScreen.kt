package br.com.fiap.locaweb.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.locaweb.models.Email
import br.com.fiap.locaweb.models.EmailViewModel
import br.com.fiap.locaweb.components.ClosedEmail
import br.com.fiap.locaweb.components.Footer
import br.com.fiap.locaweb.components.SearchBar

@Composable
fun SpamScreen(
    pesquisarEmail: (String) -> Unit,
    email: String,
    emailViewModel: EmailViewModel,
    navController: NavController,
    isDarkTheme: Boolean
) {
    var searchQuery by remember { mutableStateOf(email) }

    // Perform search based on the query
    if (searchQuery.isNotEmpty()) {
        emailViewModel.searchEmails(searchQuery)
    }

    Column {
        // Search bar to filter spam emails
        SearchBar(
            pesquisarEmail = { query ->
                searchQuery = query
                pesquisarEmail(query)
            },
            email = searchQuery,
            isDarkTheme = isDarkTheme
        )

        Text(text = "Spam", modifier = Modifier.padding(start = 15.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(emailViewModel.spamEmails.size) { index ->
                val email = emailViewModel.spamEmails[index]

                ClosedEmail(
                    email = email,
                    onEmailUpdated = {
                        emailViewModel.toggleFavorite(email)
                    },
                    navController = navController
                )
            }
        }

        Footer(navController, isDarkTheme)
    }
}
