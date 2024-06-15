package br.com.fiap.locaweb.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(pesquisarEmail: (String) -> Unit, email: String) {
    Column(
        horizontalAlignment =Alignment.CenterHorizontally,
        modifier =Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment =Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 10.dp)
        ) {
        OutlinedTextField(value = email,
            onValueChange = pesquisarEmail,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Pesquisar email...", color = Color.Black)
            },
            shape = RoundedCornerShape(20.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine =true,
            trailingIcon = {
                Icon(imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Perfil",
                    tint = Color(0xfff0E6BA8),
                    modifier = Modifier.size(40.dp))
            },
            colors =OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedBorderColor = Color.Black
            )
        )
        }
    }
}