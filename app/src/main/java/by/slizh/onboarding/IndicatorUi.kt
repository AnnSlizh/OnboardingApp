package by.slizh.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IndicatorUi(
    pageSize: Int,
    currentPage: Int
) {

    Row(
        modifier = Modifier.background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(pageSize) {

            Spacer(modifier = Modifier.size(3.dp))

            Box(
                modifier = Modifier
                    .height(8.dp)
                    .width(width = if (it == currentPage) 24.dp else 8.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = if (it == currentPage) Color.White else Color.White.copy(alpha = 0.4f))
            )
            Spacer(modifier = Modifier.size(3.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndicatorFirstPagePreview() {
    IndicatorUi(pageSize = 4, currentPage = 0)
}

@Preview(showBackground = true)
@Composable
fun IndicatorSecondPagePreview() {
    IndicatorUi(pageSize = 4, currentPage = 1)
}

@Preview(showBackground = true)
@Composable
fun IndicatorThirdPagePreview() {
    IndicatorUi(pageSize = 4, currentPage = 2)
}

@Preview(showBackground = true)
@Composable
fun IndicatorFourthPagePreview() {
    IndicatorUi(pageSize = 4, currentPage = 3)
}