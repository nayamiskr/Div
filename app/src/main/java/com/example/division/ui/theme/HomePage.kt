package com.example.division

import android.location.GnssAntennaInfo.PhaseCenterOffset
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val ImageList = listOf(
    R.drawable.tainex,
    R.drawable.iti,
    R.drawable.eat
)

class HomePage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                homePage()
                Information()
            }
        }
    }
}

@Composable
fun ImageView(
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier) {
    Column(modifier) {
        Image(
            painterResource(id = drawable),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .width(380.dp)
                .clip(RoundedCornerShape(30.dp))

        )
    }
}

@Composable
fun homePage(modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier) {
        items(ImageList) { item ->
            ImageView(drawable = item)
        }
    }
}

@Composable
fun Detail(information: String,num: Int){
    Row {
        var color: Color = Color.Red
        var number: String = "???"
        if (num == 1){
            color = Color.Magenta
            number = "1"
        }
        else if(num == 2){
            color = Color.Red
            number = "2"
        }
        else if(num == 3){
            color = Color.Black
            number = "???"
        }
        Text(
            modifier = Modifier
                .padding(24.dp)
                .drawBehind {
                    drawCircle(color = color, radius = 22.dp.toPx())
                },
            text = "$number"+"???",
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Text(text = "$information", modifier = Modifier.align(Alignment.CenterVertically))
    }
}


@Composable
fun Information(modifier: Modifier = Modifier){
    Column{
        Text(text = "????????????"
            ,style = MaterialTheme.typography.h5
            ,modifier = Modifier
            .fillMaxWidth()
            .size(50.dp))
        Detail("???????????????2???7?????????????????????????????????????????????????????????????????????????????????????????????2??????????????????",2)
        Detail("????????????????????????????????????????????????2???7????????????????????????????????????????????????????????????",2)
        Detail("112???????????????????????????????????????????????? (112/1/11-4/7)",1)


    }
    
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Column {
        homePage()
        Information()
    }
}



