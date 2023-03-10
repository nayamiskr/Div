package com.example.division

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.division.ui.theme.DivisionTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DivisionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppMainScreen()
                }
            }
        }
    }
}
/*
@Composable
fun Homepage( ) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        drawerContent = { Drawablecompose("老二") },
        drawerShape = customShape()
    ) {
        // Screen content
    }
}
*/


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DivisionTheme {
        AppMainScreen()

    }
}