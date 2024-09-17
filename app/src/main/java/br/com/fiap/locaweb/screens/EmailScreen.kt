package br.com.fiap.locaweb.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.fiap.locaweb.models.EmailViewModel
import br.com.fiap.locaweb.Event
import br.com.fiap.locaweb.components.Footer
import br.com.fiap.locaweb.components.OpenedEmail
import br.com.fiap.locaweb.components.SearchBar

@Composable
fun EmailScreen(
    emailId: Long,
    emailViewModel: EmailViewModel,
    navController: NavController,
    eventos: List<Event>,
    isDarkTheme: Boolean,
    ) {
    val email = emailViewModel.emails.find { it.id == emailId }

    email?.let {
        Column {
            OpenedEmail(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                email = it,
                navController = navController,
                emailViewModel = emailViewModel,
                eventos = eventos
            )
            Footer(navController, isDarkTheme)
        }
    }
}