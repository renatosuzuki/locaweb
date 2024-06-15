package br.com.fiap.locaweb.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.locaweb.Email
import br.com.fiap.locaweb.R

@Composable
fun ClosedEmail(email: Email) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = email.imageRes),
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
            Text(email.preview, style = MaterialTheme.typography.bodySmall)
        }
        Icon(
            painter = painterResource(id = if (email.isStarred) R.drawable.ic_star_filled else R.drawable.ic_star_outline),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
    }
}
