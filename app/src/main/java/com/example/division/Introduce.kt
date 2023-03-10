package com.example.division

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.division.ui.theme.DivisionTheme

class Introduce : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Surface{
                    Greeting()
                }
        }
    }
}

@Composable
fun Greeting() {
    Column {
        Text(
            text = "展館介紹",
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        Divider(color = Color.Blue,
                thickness = 3.dp)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    DivisionTheme {
        Greeting()
    }
}