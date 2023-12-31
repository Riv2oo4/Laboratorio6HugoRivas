package com.example.laboratorio6hugorivas.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
sealed class AppScreens(val route: String) {
    object conciertosScreen : AppScreens("firstScreen")
    object detailsScreen : AppScreens("secondScreen")
    object favoritesScreen : AppScreens("thirdScreen")
    object profileScreen : AppScreens("fourthScreen")

}

