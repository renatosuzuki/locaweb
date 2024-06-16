package br.com.fiap.locaweb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.locaweb.screens.EmailScreen
import br.com.fiap.locaweb.screens.FavoriteScreen
import br.com.fiap.locaweb.screens.MainScreen
import br.com.fiap.locaweb.ui.theme.LocawebTheme

data class Email(
    val id: Long,
    val sender: String,
    val subject: String,
    val preview: String,
    val content: String,
    val hasEvent: Boolean,
    val isStarred: Boolean,
    val imageRes: Int
)

private fun sampleEmails(): List<Email> {
    return listOf(
        Email(
            1,
            "José Manuel López",
            "Confira o relatório de seus investimentos",
            "Relatório detalhado dos seus investimentos.",
            "Olá,\n" +
                    "\n" +
                    "Em anexo, você encontrará o relatório detalhado dos seus investimentos no último trimestre. Qualquer dúvida, estou à disposição.\n" +
                    "\n" +
                    "Atenciosamente,\n" +
                    "José",
            false,
            true,
            R.drawable.ic_person1
        ),
        Email(
            2,
            "Eduardo Pereira",
            "Confirmação de Reunião",
            "Por favor, confirme sua presença na reunião de amanhã.",
            "Olá,\n" +
                    "\n" +
                    "Gostaria de confirmar sua presença na reunião agendada para amanhã às 10h. Por favor, responda este e-mail confirmando sua participação.\n" +
                    "\n" +
                    "Obrigado,\n" +
                    "Eduardo",
            true,
            false,
            R.drawable.ic_person2
        ),
        Email(
            3,
            "Luan Garcia",
            "Email sem assunto",
            "Mensagem sem assunto.",
            "Olá,\n" +
                    "\n" +
                    "Espero que esteja bem. Gostaria de discutir [assunto específico] com você. Quando seria um bom momento para conversarmos?\n" +
                    "\n" +
                    "Atenciosamente,\n" +
                    "Luan",
            false,
            false,
            R.drawable.ic_person3
        ),
        Email(
            4,
            "Estevão William",
            "Novas Ofertas no Super Mercado Atacad...",
            "Confira as novas ofertas disponíveis nesta semana.",
            "Olá,\n" +
                    "\n" +
                    "Não perca as novas ofertas que acabamos de lançar! Confira em nosso site e aproveite os descontos exclusivos desta semana.\n" +
                    "\n" +
                    "Abraços,\n" +
                    "Estevão",
            false,
            false,
            R.drawable.ic_person4
        ),
        Email(
            5,
            "Murilo Cerqueira",
            "Tudo bem com você?",
            "Queria saber como você está.",
            "Oi,\n" +
                    "\n" +
                    "Faz tempo que não conversamos. Queria saber como você está e o que tem feito ultimamente. Vamos marcar um café qualquer dia desses?\n" +
                    "\n" +
                    "Abraços,\n" +
                    "Murilo",
            false,
            false,
            R.drawable.ic_person5
        ),
        Email(
            6,
            "Marcos Rocha",
            "Pagamento de Aluguel de Residencia",
            "Lembrete de pagamento do aluguel deste mês.",
            "Olá,\n" +
                    "\n" +
                    "Este é um lembrete amigável para o pagamento do aluguel deste mês. Por favor, efetue o pagamento até o dia [data limite].\n" +
                    "\n" +
                    "Obrigado,\n" +
                    "Marcos",
            false,
            false,
            R.drawable.ic_person6
        ),
        Email(
            7,
            "José Rafael",
            "Sua Assinatura do Cartão Exclusivo foi...",
            "Parabéns! Sua assinatura foi aprovada.",
            "Olá,\n" +
                    "\n" +
                    "Parabéns! Sua assinatura foi aprovada com sucesso. Você agora tem acesso completo aos nossos serviços. Qualquer dúvida, estamos à disposição.\n" +
                    "\n" +
                    "Atenciosamente,\n" +
                    "Rafael",
            false,
            false,
            R.drawable.ic_person7
        )
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocawebTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    var email by remember {
                        mutableStateOf("")
                    }

                    NavHost(
                        navController = navController,
                        startDestination = "main",
                    ) {
                        composable(route = "main") {
                            MainScreen(
                                pesquisarEmail = { email = it },
                                email = email,
                                emails = sampleEmails(),
                                navController
                            )
                        }
                        composable(route = "favorite") {
                            FavoriteScreen(
                                pesquisarEmail = { email = it },
                                email = email,
                                emails = sampleEmails(),
                                navController
                            )
                        }
                        composable(route = "email") {
                            EmailScreen(
                                pesquisarEmail = { email = it },
                                email = email,
                                navController
                            )
                        }
                    }
                }
            }
        }
    }
}

