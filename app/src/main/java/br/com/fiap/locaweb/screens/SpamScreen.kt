package br.com.fiap.locaweb.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.locaweb.Email
import br.com.fiap.locaweb.EmailViewModel
import br.com.fiap.locaweb.components.ClosedEmail
import br.com.fiap.locaweb.components.Footer
import br.com.fiap.locaweb.components.SearchBar

@Composable
fun SpamScreen(
    pesquisarEmail: (String) -> Unit,
    email: String,
    emailViewModel: EmailViewModel,
    navController: NavController,
    isDarkTheme: Boolean,
) {
    Column {
        SearchBar(pesquisarEmail = pesquisarEmail, email = email, isDarkTheme)
        Text(text = "Spam", modifier = Modifier.padding(start = 15.dp))
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(emailViewModel.spamEmails.size) { index ->
                val email = emailViewModel.spamEmails[index]

                ClosedEmail(email = email, onEmailUpdated = {
                    emailViewModel.toggleSpam(email)
                }, navController = navController)
            }
        }
        Footer(navController, isDarkTheme)
    }
}
