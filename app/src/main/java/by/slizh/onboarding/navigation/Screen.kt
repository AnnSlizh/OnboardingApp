package by.slizh.onboarding.navigation

sealed class Screen(val route: String) {
    object OnboardingScreen: Screen(route = "onboarding_screen")
    object FinishScreen: Screen(route = "finish_screen")
}