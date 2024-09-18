package br.com.fiap.locaweb.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.locaweb.Email
import br.com.fiap.locaweb.EmailViewModel
import br.com.fiap.locaweb.components.ClosedEmail
import br.com.fiap.locaweb.components.Footer
import br.com.fiap.locaweb.components.SearchBar

@Composable
fun MainScreen(
    pesquisarEmail: (String) -> Unit,
    email: String,
    emailViewModel: EmailViewModel,
    navController: NavController,
    isDarkTheme: Boolean,
    onThemeChange: () -> Unit
) {
    val filteredEmails = emailViewModel.emails.filter { !it.isSpam }

    Column {
        SearchBar(pesquisarEmail = pesquisarEmail, email = email, isDarkTheme)
        Button(
            onClick = onThemeChange,
            modifier = Modifier.padding(bottom = 10.dp, start = 15.dp, top = 10.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(text = if (isDarkTheme) "Trocar para tema claro" else "Trocar para tema escuro")
        }
        Text(text = "Principais", modifier = Modifier.padding(start = 15.dp))
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(filteredEmails.size) { index ->
                val email = filteredEmails[index]

                ClosedEmail(email = email, onEmailUpdated = {
                    emailViewModel.toggleFavorite(email)
                }, navController = navController)
            }
        }
        Footer(navController, isDarkTheme)
    }
}