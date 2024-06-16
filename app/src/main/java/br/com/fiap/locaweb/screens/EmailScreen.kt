package br.com.fiap.locaweb.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.fiap.locaweb.components.Footer
import br.com.fiap.locaweb.components.OpenedEmail
import br.com.fiap.locaweb.components.SearchBar

@Composable
fun EmailScreen(pesquisarEmail: (String) -> Unit, email: String, navController: NavController) {
    Column {
        SearchBar(pesquisarEmail = pesquisarEmail, email = email)
        OpenedEmail(modifier = Modifier
            .weight(1f)
            .verticalScroll(rememberScrollState()))
        Footer(navController)
    }
}