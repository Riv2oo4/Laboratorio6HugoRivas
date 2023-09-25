package com.example.laboratorio6hugorivas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.laboratorio6hugorivas.uii.concerts.ConciertosScreen
import com.example.laboratorio6hugorivas.uii.details.DetailsScreen
import com.example.laboratorio6hugorivas.uii.favorites.FavoritesScreen
import com.example.laboratorio6hugorivas.uii.profile.ProfileScreen

sealed class Screen(val route: String) {
    object ConciertosScreen : Screen("conciertosScreen")
    object DetailsScreen : Screen("detailsScreen/{eventName}")
    object FavoritesScreen : Screen("favoritesScreen")
    object ProfileScreen : Screen("profileScreen")
}

object AppNavigation {
    @Composable
    fun NavigationComponent() {
        val navController = rememberNavController()

        NavHost(navController, startDestination = Screen.ConciertosScreen.route) {
            composable(Screen.ConciertosScreen.route) {
                ConciertosScreen(navController)
            }

            composable(
                "${Screen.DetailsScreen.route}/{eventName}",
                arguments = listOf(
                    navArgument("eventName") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val eventName = backStackEntry.arguments?.getString("eventName") ?: ""
                DetailsScreen(eventName)
            }

            composable(Screen.FavoritesScreen.route) {
                FavoritesScreen()
            }

            composable(Screen.ProfileScreen.route) {
                ProfileScreen()
            }
        }
    }
}
