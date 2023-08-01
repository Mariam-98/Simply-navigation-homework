package com.example.simplynavigationhomework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.example.simplynavigationhomework.model.BottomNavigationItem
import com.example.simplynavigationhomework.ui.navigation.BottomNavigationBar
import com.example.simplynavigationhomework.ui.navigation.Navigation
import com.example.simplynavigationhomework.ui.navigation.Screen
import com.example.simplynavigationhomework.ui.theme.SimplyNavigationHomeworkTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimplyNavigationHomeworkTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavigationItem(route = Screen.HomeScreen.route, icon = painterResource(id = R.drawable.home_icon)),
                                BottomNavigationItem(route = Screen.ProfileScreen.route, icon = painterResource(id = R.drawable.person_icon)),
                                BottomNavigationItem(route = Screen.MenuScreen.route, icon = painterResource(id = R.drawable.menu_icon))
                            ),
                            navController = navController
                        )
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}
