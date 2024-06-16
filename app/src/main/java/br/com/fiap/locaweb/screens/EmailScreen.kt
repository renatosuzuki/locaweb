package br.com.fiap.locaweb.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.fiap.locaweb.EmailViewModel
import br.com.fiap.locaweb.components.Footer
import br.com.fiap.locaweb.components.OpenedEmail
import br.com.fiap.locaweb.components.SearchBar

@Composable
fun EmailScreen(emailId: Long, emailViewModel: EmailViewModel, navController: NavController) {
    val email = emailViewModel.emails.find { it.id == emailId }

    email?.let {
        Column {
            OpenedEmail(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                email = it,
                navController = navController
            )
            Footer(navController)
        }
    }
}