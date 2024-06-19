package by.slizh.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.slizh.onboarding.ui.theme.Blue


@Composable
fun FinishScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "You are a clever person!",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 24.dp, end = 24.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun FinishScreenPreview() {
    FinishScreen()
}