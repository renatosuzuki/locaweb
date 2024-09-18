package br.com.fiap.locaweb.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.locaweb.models.Email
import br.com.fiap.locaweb.R
import br.com.fiap.locaweb.ui.theme.LocawebRed

@Composable
fun ClosedEmail(email: Email, onEmailUpdated: (Email) -> Unit, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate("email/${email.id}") },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_person_pin_24),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Text(email.sender, style = MaterialTheme.typography.bodyMedium)
            Text(email.subject, style = MaterialTheme.typography.titleMedium)
            Text(
                text = email.content.take(40),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Button(
            onClick = {
                onEmailUpdated(email.copy(starred = !email.starred))
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            )
        ) {
            Icon(
                painter = painterResource(id = if (email.starred) R.drawable.star else R.drawable.ic_star_outline),
                contentDescription = null,
                tint = LocawebRed,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
