package com.example.division

import android.content.pm.ModuleInfo
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.division.ui.theme.DivisionTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextOverflow

@ExperimentalMaterialApi
@Composable
fun Ticket(name: String, price: Int, funtion: String) {
    var expandedState by remember { mutableStateOf(false) }
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(3.dp, color = Color.Blue),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                expandedState = !expandedState
            }
            .animateContentSize(
                animationSpec = (tween(100, easing = FastOutSlowInEasing))
            ),
        backgroundColor = Color(3, 169, 244, 255),
    ) {
        Column {
            Row() {
                Text(
                    "$name",
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(6f),
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = "$" + "$price",
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(2f),
                    style = MaterialTheme.typography.h6,
                    color = Color.Red,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            if (expandedState) {
                var value = remember {
                    mutableStateOf("")
                }
                Column {
                    Text(text = "$funtion",
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.h6)
                    TextField(value = "", onValueChange = {},
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterHorizontally),
                        label = { Text("你媽的名字")}

                    )
                }

            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    DivisionTheme {
        Ticket("票種一",123,"非常牛逼")
    }
}