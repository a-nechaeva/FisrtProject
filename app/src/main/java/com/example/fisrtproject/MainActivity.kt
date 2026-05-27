package com.example.fisrtproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fisrtproject.ui.theme.FisrtProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FisrtProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    FirstScreen()
                }
            }
        }
    }
}
fun isValidPhoneNumber(phone: String): Boolean {
    val cleanPhone = phone.replace(Regex("[\\s\\-()]+"), "")
    val phoneRegex = Regex("^\\+?[0-9]{7,15}$")
    return phoneRegex.matches(cleanPhone)
}

@Composable
fun FirstScreen() {
    var text by remember { mutableStateOf("") }
    var phoneError by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                phoneError = null
            },
            label = {Text("Edit Text")},
            modifier = Modifier.fillMaxWidth(),
            isError = phoneError != null,
            supportingText = phoneError?.let{{Text(it, color = MaterialTheme.colorScheme.error)}}
        )
        Button(
            onClick = {
                if (text.isNotBlank()) {
                    val intent = Intent(context, SecondActivity::class.java).apply {
                        putExtra("EXTRA_TEXT", text)
                    }
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "Пожалуйста, введите текст", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Открыть вторую Activity")
        }
        Button(
            onClick = {
                if (text.isBlank()) {
                    phoneError = "Пожалуйста, введите номер телефона"
                    Toast.makeText(context, "Пожалуйста, введите номер телефона", Toast.LENGTH_SHORT).show()
                } else if (!isValidPhoneNumber(text)) {
                    phoneError = "Некорректный телефонный номер"
                    Toast.makeText(context, "Некорректный телефонный номер", Toast.LENGTH_SHORT).show()
                } else {
                    phoneError = null
                    val intent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:$text")
                    }
                    context.startActivity(intent)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Позвонить другу")
        }

        Button(
            onClick = {
                if (text.isNotBlank()) {
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, text)
                    }
                    context.startActivity(Intent.createChooser(intent, "Поделиться через..."))
                } else {
                    Toast.makeText(context, "Пожалуйста, введите текст", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Поделиться текстом")
        }
    }
}