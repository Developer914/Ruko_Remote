package com.example.roku.screens.onboarding


import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.roku.R
import com.example.roku.resources.descriptions
import com.example.roku.ui.theme.BackgroundColor
import com.example.roku.ui.theme.DotColor
import com.example.roku.ui.theme.MainColor
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.WormIndicatorType
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen() {
    val pageCount by remember { mutableIntStateOf(5) }
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pageCount })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.65f),
            state = pagerState,
            userScrollEnabled = false
        ) { page ->
            val imageRes = when (page) {
                0 -> R.drawable.ob1
                1 -> R.drawable.ob2
                2 -> R.drawable.ob3
                3 -> R.drawable.ob4
                4 -> R.drawable.ob5
                else -> R.drawable.ob1
            }
            BackgroundImage(imageRes, "OB-$page")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.35f)
                .offset(y = (-20).dp)
                .zIndex(1f)
        ) {
            ContentLayout(pageCount,pagerState)
        }
    }
}

@Composable
fun ContentLayout(pageCount: Int, pagerState: PagerState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Descriptions(
            descriptions[pagerState.currentPage].heading,
            descriptions[pagerState.currentPage].details
        )

        ContinueButton(pagerState,pageCount, descriptions[pagerState.currentPage].btnTxt)
        WormDotIndicators(pageCount, pagerState)
    }
}

@Composable
fun BackgroundImage(
    drawable: Int, description: String
) {
    Image(
        painterResource(
            drawable
        ),
        contentDescription = description,
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun Descriptions(heading : String, details : String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(129.dp)
            .padding(
                horizontal = 30.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = heading,
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight(600),
            textAlign = TextAlign.Center,
            lineHeight = 32.sp,
            modifier = Modifier
                .padding(
                    horizontal = 24.dp
                )
        )

        Text(
            text = details,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = 9.dp
                )
        )
    }
}

@Composable
fun ContinueButton(pagerState: PagerState, pageCount: Int, btnTxt: String) {
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .clickable {
                scope.launch {
                    val current = pagerState.currentPage
                    if (current < pageCount - 1) {
                        pagerState.animateScrollToPage(
                            page = pagerState.currentPage + 1,
                            animationSpec = tween(durationMillis = 400) // slower animation
                        )
                    }
                }
            }
            .fillMaxWidth()
            .padding(top = 15.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(R.drawable.ob_button_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        )

        Text(
            text = btnTxt,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight(500),
            letterSpacing = 2.sp
        )
    }
}

@Composable
private fun WormDotIndicators(pageCount: Int, pagerState: PagerState) {
    Column(
        modifier = Modifier
            .padding(
                top = 42.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DotsIndicator(
            dotCount = pageCount,
            type = WormIndicatorType(
                dotsGraphic = DotGraphic(
                    7.dp,
                    color = DotColor,
                ),
                wormDotGraphic = DotGraphic(
                    7.dp,
                    color = MainColor,
                )
            ),
            pagerState = pagerState
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    OnboardingScreen()
}