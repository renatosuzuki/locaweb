package br.com.fiap.locaweb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.locaweb.screens.EmailScreen
import br.com.fiap.locaweb.screens.FavoriteScreen
import br.com.fiap.locaweb.screens.MainScreen
import br.com.fiap.locaweb.ui.theme.LocawebTheme

data class Email(
    val sender: String,
    val subject: String,
    val preview: String,
    val isStarred: Boolean,
    val imageRes: Int
)

private fun sampleEmails(): List<Email> {
    return listOf(
        Email(
            "José Manuel López",
            "Confira o relatório de seus investimentos",
            "Relatório detalhado dos seus investimentos.",
            true,
            R.drawable.ic_person1
        ),
        Email(
            "Eduardo Pereira",
            "Confirmação de Reunião",
            "Por favor, confirme sua presença na reunião de amanhã.",
            false,
            R.drawable.ic_person2
        ),
        Email(
            "Luan Garcia",
            "Email sem assunto",
            "Mensagem sem assunto.",
            false,
            R.drawable.ic_person3
        ),
        Email(
            "Estevão William",
            "Novas Ofertas no Super Mercado Atacad...",
            "Confira as novas ofertas disponíveis nesta semana.",
            false,
            R.drawable.ic_person4
        ),
        Email(
            "Murilo Cerqueira",
            "Tudo bem com você?",
            "Queria saber como você está.",
            false,
            R.drawable.ic_person5
        ),
        Email(
            "Marcos Rocha",
            "Pagamento de Aluguel de Residencia",
            "Lembrete de pagamento do aluguel deste mês.",
            false,
            R.drawable.ic_person6
        ),
        Email(
            "José Rafael",
            "Sua Assinatura do Cartão Exclusivo foi...",
            "Parabéns! Sua assinatura foi aprovada.",
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

