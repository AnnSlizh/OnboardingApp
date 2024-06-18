package by.slizh.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.slizh.onboarding.ui.theme.Typography

@Composable
fun OnboardingScreenUi(onboardingModel: OnboardingModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(onboardingModel.color)
    ) {

        Text(
            text = onboardingModel.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp, 35.dp, 24.dp, 12.dp),
            fontSize = 28.sp,
            textAlign = TextAlign.Start,
            color = Color.White
        )

        Text(
            text = onboardingModel.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp, 0.dp, 24.dp, 38.dp),
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            color = Color.White.copy(alpha = 0.9f)
        )

        Image(
            painter = painterResource(id = onboardingModel.image), contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(60.dp)
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun FirstScreenPreview() {
    OnboardingScreenUi(onboardingModel = OnboardingModel.FirstScreen)
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    OnboardingScreenUi(onboardingModel = OnboardingModel.SecondScreen)
}

@Preview(showBackground = true)
@Composable
fun ThirdScreenPreview() {
    OnboardingScreenUi(onboardingModel = OnboardingModel.ThirdScreen)
}

@Preview(showBackground = true)
@Composable
fun FourthScreenPreview() {
    OnboardingScreenUi(onboardingModel = OnboardingModel.FourthScreen)
}