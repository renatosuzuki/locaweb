package br.com.fiap.locaweb.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.fiap.locaweb.R
import br.com.fiap.locaweb.ui.theme.LocawebRed

@Composable
fun Footer(navController: NavController, isDarkTheme: Boolean) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    var mainColor = if (currentRoute == "main") Color.White else Color.Black
    var favoriteColor = if (currentRoute == "favorite") Color.White else Color.Black

    if (currentRoute == "main" && isDarkTheme) {
        mainColor = LocawebRed
    }

    if (currentRoute == "favorite" && isDarkTheme) {
        favoriteColor = LocawebRed
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Button(
                onClick = { navController.navigate("main") },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = "email pagina principal",
                        modifier = Modifier.size(45.dp),
                        colorFilter = ColorFilter.tint(mainColor)
                    )
                }
            }
            Divider(
                color = Color.White,
                modifier = Modifier
                    .width(2.dp)
                    .fillMaxHeight()
            )
            Button(
                onClick = { navController.navigate("favorite") },
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_star_24),
                        contentDescription = "email favoritos",
                        modifier = Modifier.size(45.dp),
                        colorFilter = ColorFilter.tint(favoriteColor)
                    )
                }
            }
        }
    }

}