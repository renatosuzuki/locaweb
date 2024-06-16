package br.com.fiap.locaweb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.locaweb.ui.theme.DetailScreenTheme

class DetailScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailScreenTheme {
                Detail()
            }
        }
    }
}

@Composable
fun Detail() {
    val lightRoseColor = Color(0.8689f, 0.6169f, 0.6139f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = "Confira o relatório de seus investimentos",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 50.dp)
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(lightRoseColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "JM",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "José Manuel López",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(10.dp))

            // Estrela amarela como imagem
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "Star",
                modifier = Modifier.size(22.dp)
            )

            Spacer(modifier = Modifier.width(6.dp))

            // Três pontos como imagem
            Image(
                painter = painterResource(id = R.drawable.dots),
                contentDescription = "Dots",
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Substitua o R.drawable.logo pelo ID do seu recurso de imagem
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Investment Report Logo",
            modifier = Modifier
                .size(160.dp)
                .align(Alignment.CenterHorizontally) // Centraliza a imagem
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Ajuste para adicionar espaço entre as linhas do texto
        Text(
            text = """
                Olá, Boa Tarde
                
                Como combinado, após um mês de 
                investimentos em nossa plataforma, iriamos te 
                mandar o relatório de seus investimentos. 
                Acesse o link a seguir e veja seus resultados: www.investimentos.com. É com grande prazer 
                poder continuar investindo juntos.
                
                José Manuel - Equipe Investimentos 
            """.trimIndent(),
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 18.dp),

            )


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DetailScreenTheme {
        DetailScreen()
    }
}