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
    val emails = emailViewModel.spamEmails

    Column {
        SearchBar(
            pesquisarEmail = pesquisarEmail,
            email = email,
            isDarkTheme = isDarkTheme
        )

        Text(text = "Spam", modifier = Modifier.padding(start = 15.dp, top = 8.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(emails.size) { index ->
                val email = emails[index]

                println("renatosuzuki")
                println(email)

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