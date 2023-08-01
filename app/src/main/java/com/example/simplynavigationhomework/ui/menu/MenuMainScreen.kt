package com.example.simplynavigationhomework.ui.menu

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class MenuScreen(val route: String) {
    object FirstMenuScreen : MenuScreen("firstMenu")
    object SecondMenuScreen : MenuScreen("secondMenu")
}

@Composable
fun MenuMainScreen(navController: NavController) {
    val menuNavController = rememberNavController()

    NavHost(
        navController = menuNavController,
        startDestination = MenuScreen.FirstMenuScreen.route
    ) {
        composable(MenuScreen.FirstMenuScreen.route) {
            FirstMenuScreen(navController = navController, nestedNavController = menuNavController)
        }
        composable(MenuScreen.SecondMenuScreen.route) {
            SecondMenuScreen(navController = menuNavController)
        }
    }
}