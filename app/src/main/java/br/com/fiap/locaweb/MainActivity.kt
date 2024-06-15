package br.com.fiap.locaweb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.locaweb.components.ClosedEmail
import br.com.fiap.locaweb.ui.theme.LocawebTheme

data class Email(
    val sender: String,
    val subject: String,
    val preview: String,
    val isStarred: Boolean,
    val imageRes: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocawebTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EmailList(emails = sampleEmails())
                }
            }
        }
    }

    private fun sampleEmails(): List<Email> {
        return listOf(
            Email("José Manuel López", "Confira o relatório de seus investimentos", "Relatório detalhado dos seus investimentos.", true, R.drawable.ic_person1),
            Email("Eduardo Pereira", "Confirmação de Reunião", "Por favor, confirme sua presença na reunião de amanhã.", false, R.drawable.ic_person2),
            Email("Luan Garcia", "Email sem assunto", "Mensagem sem assunto.", false, R.drawable.ic_person3),
            Email("Estevão William", "Novas Ofertas no Super Mercado Atacad...", "Confira as novas ofertas disponíveis nesta semana.", false, R.drawable.ic_person4),
            Email("Murilo Cerqueira", "Tudo bem com você?", "Queria saber como você está.", false, R.drawable.ic_person5),
            Email("Marcos Rocha", "Pagamento de Aluguel de Residencia", "Lembrete de pagamento do aluguel deste mês.", false, R.drawable.ic_person6),
            Email("José Rafael", "Sua Assinatura do Cartão Exclusivo foi...", "Parabéns! Sua assinatura foi aprovada.", false, R.drawable.ic_person7)
        )
    }
}

@Composable
fun EmailList(emails: List<Email>) {
    LazyColumn {
        items(emails.size) { index ->
            ClosedEmail(email = emails[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LocawebTheme {
        EmailList(
            emails = listOf(
                Email("José Manuel López", "Confira o relatório de seus investimentos", "Relatório detalhado dos seus investimentos.", true, R.drawable.ic_person1),
                Email("Eduardo Pereira", "Confirmação de Reunião", "Por favor, confirme sua presença na reunião de amanhã.", false, R.drawable.ic_person2),
                Email("Luan Garcia", "Email sem assunto", "Mensagem sem assunto.", false, R.drawable.ic_person3),
                Email("Estevão William", "Novas Ofertas no Super Mercado...", "Confira as novas ofertas disponíveis nesta semana.", false, R.drawable.ic_person4),
                Email("Murilo Cerqueira", "Tudo bem com você?", "Queria saber como você está.", false, R.drawable.ic_person5),
                Email("Marcos Rocha", "Pagamento de Aluguel de Residencia", "Lembrete de pagamento do aluguel deste mês.", false, R.drawable.ic_person6),
                Email("José Rafael", "Sua Assinatura do Cartão Exclusivo foi...", "Parabéns! Sua assinatura foi aprovada.", false, R.drawable.ic_person7)
            )
        )
    }
}
