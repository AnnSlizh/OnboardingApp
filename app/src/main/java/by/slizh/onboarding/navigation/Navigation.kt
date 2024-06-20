package by.slizh.onboarding.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.slizh.onboarding.FinishScreen
import by.slizh.onboarding.OnboardingScreen


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.OnboardingScreen.route) {
        composable(route = Screen.OnboardingScreen.route) {
            OnboardingScreen(navController = navController)
        }

        composable(route = Screen.FinishScreen.route) {
            FinishScreen()
        }
    }
}