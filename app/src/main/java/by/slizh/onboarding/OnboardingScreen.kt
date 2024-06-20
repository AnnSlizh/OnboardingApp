package by.slizh.onboarding

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import by.slizh.onboarding.navigation.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(navController: NavHostController) {

    val scope = rememberCoroutineScope()

    val pages = listOf(
        OnboardingModel.FirstScreen,
        OnboardingModel.SecondScreen,
        OnboardingModel.ThirdScreen,
        OnboardingModel.FourthScreen
    )
    val state = rememberPagerState(pageCount = { pages.size })

    Column(
        Modifier
            .fillMaxSize()
            .background(pages[state.currentPage].color)
    ) {

        HorizontalPager(
            state = state, modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) { page ->
            OnboardingScreenUi(onboardingModel = pages[page])
        }

        BottomSection(
            size = pages.size,
            index = state.currentPage,
            color = pages[state.currentPage].color,
            navController = navController
        ) {
            if (state.currentPage + 1 < pages.size) scope.launch { state.scrollToPage(state.currentPage + 1) }
            else navController.navigate(Screen.FinishScreen.route)
        }
    }
}

@Composable
fun BottomSection(
    size: Int,
    index: Int,
    color: Color,
    navController: NavHostController,
    onNextClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp, 0.dp, 24.dp, 20.dp)
            .navigationBarsPadding()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Indicators(size = size, index = index)

                Text(
                    text = "Skip",
                    fontSize = 18.sp,
                    color = Color.White.copy(alpha = 0.7f),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .clickable(onClick = {
                            navController.navigate(Screen.FinishScreen.route)
                        })
                )
            }

            Box(contentAlignment = Alignment.Center) {
                Canvas(modifier = Modifier.size(72.dp)) {
                    val sweepAngle = ((index.toFloat() + 1) / size) * 360
                    drawArc(
                        color = Color.White.copy(alpha = 0.4f),
                        startAngle = 0f,
                        sweepAngle = 360f,
                        useCenter = false,
                        style = Stroke(width = 8f)
                    )
                    drawArc(
                        color = Color.White,
                        startAngle = 0f,
                        sweepAngle = sweepAngle,
                        useCenter = false,
                        style = Stroke(width = 8f)
                    )
                }

                FloatingActionButton(
                    onClick = onNextClicked,
                    shape = CircleShape,
                    containerColor = Color.White,
                    contentColor = color
                ) {
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
                }
            }
        }
    }
}
