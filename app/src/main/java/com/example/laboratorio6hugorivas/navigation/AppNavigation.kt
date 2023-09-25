package com.example.laboratorio6hugorivas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio6hugorivas.uii.concerts.FirstScreen
import com.example.laboratorio6hugorivas.uii.details.SecondScreen
import com.example.laboratorio6hugorivas.uii.favorites.ThirdScreen
import com.example.laboratorio6hugorivas.uii.profile.FourthScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController =navController,startDestination =AppScreens.conciertosScreen.route){
        composable(route = AppScreens.conciertosScreen.route){
            FirstScreen(navController)
        }
        composable(route = AppScreens.detailsScreen.route){
            SecondScreen(navController)
        }
        composable(route = AppScreens.favoritesScreen.route){
            ThirdScreen(navController)
        }
        composable(route = AppScreens.profileScreen.route){
            FourthScreen(navController)
        }

    }
}

