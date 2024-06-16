package br.com.fiap.locaweb.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.locaweb.R

@Composable
fun OpenedEmail(modifier: Modifier = Modifier) {
    val lightRoseColor = Color(0.8689f, 0.6169f, 0.6139f)

    Column(
        modifier = modifier
            .padding(10.dp)
    ) {
        Text(
            text = "Confira o relatório de seus investimentos",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 10.dp)
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

            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "Star",
                modifier = Modifier.size(22.dp)
            )

            Spacer(modifier = Modifier.width(6.dp))

            Image(
                painter = painterResource(id = R.drawable.dots),
                contentDescription = "Dots",
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Investment Report Logo",
            modifier = Modifier
                .size(160.dp)
                .align(Alignment.CenterHorizontally) // Centraliza a imagem
        )

        Spacer(modifier = Modifier.height(20.dp))

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