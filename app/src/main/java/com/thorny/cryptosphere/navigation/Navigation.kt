package com.thorny.cryptosphere.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.thorny.cryptosphere.detail.presentation.DetailScreen
import com.thorny.cryptosphere.home.presentation.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onCryptoClick = { id ->
                    navController.navigate(Screen.Detail.createRoute(id))
                }
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: return@composable
            DetailScreen(
                id = id,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}