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
import br.com.fiap.locaweb.components.ClosedEmail
import br.com.fiap.locaweb.components.Footer
import br.com.fiap.locaweb.components.SearchBar

@Composable
fun FavoriteScreen(pesquisarEmail: (String) -> Unit, email: String, emails: List<Email>, navController: NavController) {
    Column {
        SearchBar(pesquisarEmail = pesquisarEmail, email = email)
        Text(text = "Favoritados", modifier = Modifier.padding(start = 15.dp))
        LazyColumn (
            modifier = Modifier.weight(1f)
        ){
            items(emails.size) {
                    index -> ClosedEmail(email = emails[index])
            }
        }
        Footer(navController)
    }
}