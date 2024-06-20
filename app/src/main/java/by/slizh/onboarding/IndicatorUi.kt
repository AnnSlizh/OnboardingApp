package by.slizh.onboarding

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun IndicatorUi(isSelected: Boolean) {

    val width = animateDpAsState(
        targetValue = if (isSelected) 24.dp else 8.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy), label = ""
    )

    Box(
        modifier = Modifier
            .height(8.dp)
            .width(width.value)
            .clip(RoundedCornerShape(20.dp))
            .background(if (isSelected) Color.White else Color.White.copy(alpha = 0.4f))
    )
}

@Composable
fun Indicators(size: Int, index: Int) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        repeat(size) {
            IndicatorUi(isSelected = it == index)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndicatorUiPreview() {
    IndicatorUi(true)
}

@Preview(showBackground = true)
@Composable
fun IndicatorsPreview() {
    Indicators(size = 4, index = 1)
}