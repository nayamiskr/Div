package com.example.division

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.division.ui.theme.ui.theme.DivisionTheme
import kotlinx.coroutines.launch

private val eventTest = (1..3).toList()

class Nav : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMainScreen()
        }
    }
}

sealed class DrawerScreens(val icon: ImageVector, val title: String, val route: String) {
    object Home : DrawerScreens(Icons.Default.Home, "首頁", "home")
    object Account : DrawerScreens(Icons.Default.Home, "展覽館介紹", "account")
    object Help : DrawerScreens(Icons.Default.Home, "售票區", "help")
}

private val screens = listOf(
    DrawerScreens.Home,
    DrawerScreens.Account,
    DrawerScreens.Help
)

@Composable
fun AppMainScreen() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        val drawerState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch {
                drawerState.drawerState.open()
            }
        }
        Scaffold(
            scaffoldState = drawerState,
            drawerContent = {
                Drawer(
                    onDestinationClicked = { route ->
                        scope.launch {
                            drawerState.drawerState.close()
                        }
                        navController.navigate(route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = DrawerScreens.Home.route
            ) {
                composable(DrawerScreens.Home.route) {
                    Home(
                        openDrawer = {
                            openDrawer()
                        }
                    )
                }
                composable(DrawerScreens.Account.route) {
                    Account(
                        openDrawer = {
                            openDrawer()
                        }
                    )
                }
                composable(DrawerScreens.Help.route) {
                    Help(
                        openDrawer = {
                            openDrawer()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 36.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.logo1_new),
            contentDescription = "App icon"
        )
        screens.forEach { screen ->
            Row {
                Icon(
                    imageVector = screen.icon,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    text = screen.title,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.clickable {
                        onDestinationClicked(screen.route)
                    }
                )
            }
        }
    }
}


@Composable
fun TopBar(title: String = "", buttonIcon: ImageVector, onButtonClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = title
            )
        },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() }) {
                Icon(buttonIcon, contentDescription = "")
            }
        },
        backgroundColor = MaterialTheme.colors.primaryVariant
    )
}

@Composable
fun Home(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "首頁",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        DivisionTheme {
            homePage()
            Information()
        }
    }
}

@Composable
fun Account(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "南港展覽館相關介紹",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        Greeting()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Help(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "售票中心",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Ticket(name = "2023 台北國際自行車展", price = 5600,"跟著白子一起騎車去未知的地方")
            Ticket(name = "打炮", price = 2500,"跟腎虧妹妹打一次 特別舒服")
            Ticket(name = "AGA成人展", price = 200,"成人展找妹妹約")

        }
    }
}

@Preview
@Composable
fun Prieview() {
    AppMainScreen()
}