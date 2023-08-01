package com.example.simplynavigationhomework.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.simplynavigationhomework.ui.home.HomeScreen
import com.example.simplynavigationhomework.ui.menu.MenuMainScreen
import com.example.simplynavigationhomework.ui.profile.ProfileScreen

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home")
    object ProfileScreen : Screen("profile")
    object MenuScreen : Screen("menu")
}

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        composable(Screen.HomeScreen.route) {
            HomeScreen()
        }

        composable(Screen.ProfileScreen.route) {
            ProfileScreen()
        }

        composable(Screen.MenuScreen.route) {
            MenuMainScreen(navController = navController)
        }
    }
}