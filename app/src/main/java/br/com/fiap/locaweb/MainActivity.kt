package br.com.fiap.locaweb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.locaweb.models.Email
import br.com.fiap.locaweb.models.EmailViewModel
import br.com.fiap.locaweb.screens.EmailScreen
import br.com.fiap.locaweb.screens.FavoriteScreen
import br.com.fiap.locaweb.screens.MainScreen
import br.com.fiap.locaweb.ui.theme.LocawebTheme

data class Event(
    val id: Long,
    val emailIdFK: Long,
    val title: String,
    val date: String,
    val startTime: String,
    val endTime: String,
    val link: String
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val emailViewModel: EmailViewModel = viewModel()
            var isDarkTheme by remember { mutableStateOf(false) }

            LocawebTheme(
                darkTheme = isDarkTheme,
                dynamicColor = false
            ) {
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
                                pesquisarEmail = {
                                    email = it
                                    emailViewModel.searchEmails(it)
                                },
                                email = email,
                                emailViewModel = emailViewModel,
                                navController,
                                isDarkTheme,
                                onThemeChange = {
                                    isDarkTheme = !isDarkTheme
                                }
                            )
                        }
                        composable(route = "favorite") {
                            FavoriteScreen(
                                pesquisarEmail = {
                                    email = it
                                    emailViewModel.searchEmails(it)
                                },
                                email = email,
                                emailViewModel = emailViewModel,
                                navController,
                                isDarkTheme
                            )
                        }
                        composable(
                            route = "email/{emailId}",
                            arguments = listOf(navArgument("emailId") { type = NavType.LongType })
                        ) { backStackEntry ->
                            val emailId = backStackEntry.arguments?.getLong("emailId") ?: return@composable
                            EmailScreen(
                                emailId = emailId,
                                emailViewModel = emailViewModel,
                                navController = navController,
                                eventos = emptyList(),
                                isDarkTheme
                            )
                        }
                    }
                }
            }
        }
    }
}


