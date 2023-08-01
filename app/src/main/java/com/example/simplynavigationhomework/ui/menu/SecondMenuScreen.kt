package com.example.simplynavigationhomework.ui.menu

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
import androidx.navigation.compose.rememberNavController
import com.example.simplynavigationhomework.R
import com.example.simplynavigationhomework.ui.theme.Blue

@Composable
fun SecondMenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.menu_second_screen),
            color = Color.Blue
        )
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Blue),
            onClick = { navController.navigate(MenuScreen.FirstMenuScreen.route) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = stringResource(id = R.string.go_back))
        }
    }
}

@Composable
@Preview
fun SecondMenuScreenPreview() {
    SecondMenuScreen(rememberNavController())
}