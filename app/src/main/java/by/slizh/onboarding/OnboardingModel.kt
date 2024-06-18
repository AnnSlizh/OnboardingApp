package by.slizh.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import by.slizh.onboarding.ui.theme.Beige
import by.slizh.onboarding.ui.theme.Blue
import by.slizh.onboarding.ui.theme.Purple
import by.slizh.onboarding.ui.theme.Yellow


sealed class OnboardingModel(
    @DrawableRes val image: Int,
    val color: Color,
    val title: String,
    val description: String,
) {

    data object FirstScreen : OnboardingModel(
        image = R.drawable.first_car_img,
        color = Yellow,
        title = "Your first car without a driver's license",
        description = "Goes to meet people who just got their license"
    )

    data object SecondScreen : OnboardingModel(
        image = R.drawable.second_car_img,
        color = Purple,
        title = "Always there: more than 1000 cars in Tbilisi",
        description = "Our company is a leader by the number of cars in the fleet"
    )

    data object ThirdScreen : OnboardingModel(
        image = R.drawable.third_car_img,
        color = Beige,
        title = "Do not pay for parking, maintenance and gasoline",
        description = "We will pay for you, all expenses related to the car"
    )

    data object FourthScreen : OnboardingModel(
        image = R.drawable.fourth_car_img,
        color = Blue,
        title = "29 car models: from Skoda Octavia to Porsche 911",
        description = "Choose between regular car models or exclusive ones"
    )
}