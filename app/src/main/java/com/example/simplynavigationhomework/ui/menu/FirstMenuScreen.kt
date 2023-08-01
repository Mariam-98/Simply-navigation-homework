package com.example.simplynavigationhomework.ui.menu

import android.app.AlertDialog
import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.simplynavigationhomework.R
import com.example.simplynavigationhomework.ui.navigation.Screen
import com.example.simplynavigationhomework.ui.theme.Blue

@Composable
fun FirstMenuScreen(
    navController: NavController,
    nestedNavController: NavController
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Blue),
            onClick = {
                navController.navigate(Screen.HomeScreen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                }
            },
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(text = stringResource(id = R.string.home_screen))
        }
        Button(
            onClick = { nestedNavController.navigate(MenuScreen.SecondMenuScreen.route) },
            colors = ButtonDefaults.buttonColors(containerColor = Blue),
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(text = stringResource(id = R.string.menu_second_screen))
        }
        Text(
            text = stringResource(id = R.string.click_here_to_exit_the_program),
            color = Color.Blue,
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    showExitDialog(context)
                })
    }
}

fun showExitDialog(context: Context) {
    AlertDialog.Builder(context)
        .setMessage(R.string.are_you_sure_you_want_to_exit)
        .setPositiveButton(R.string.yes) { _, _ ->
            (context as? ComponentActivity)?.finish()
        }
        .setNegativeButton(R.string.no, null)
        .show()
}

@Composable
@Preview
fun FirstMenuScreenPreview() {
    FirstMenuScreen(rememberNavController(), rememberNavController())
}