package com.nurulfikri.gdscnf.presentation.screen.home.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.nurulfikri.gdscnf.R
import kotlinx.coroutines.delay
import com.google.accompanist.pager.rememberPagerState
import com.nurulfikri.gdscnf.ui.theme.blackColor
import com.nurulfikri.gdscnf.ui.theme.greyColor
import com.nurulfikri.gdscnf.utils.carouselTransition

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePagerBanner(modifier: Modifier = Modifier) {

    val listPage = listOf(
        R.drawable.banner_1,
        R.drawable.banner_2,
        R.drawable.banner_3,
    )

    val pagerState = rememberPagerState(initialPage = 0)

    LaunchedEffect(pagerState.currentPage) {
        delay(3000)
        var newPosition = pagerState.currentPage + 1
        if (newPosition > listPage.size - 1) newPosition = 0
        pagerState.animateScrollToPage(newPosition)
    }

    Box {
        HorizontalPager(
            count = listPage.size,
            state = pagerState,
            contentPadding = PaddingValues(24.dp),
            itemSpacing = 10.dp
        ) { pager ->
            Card(
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .carouselTransition(pager, pagerState)
            ) {
                Image(
                    painter = painterResource(id = listPage[pager]),
                    contentDescription = "banner",
                    contentScale = ContentScale.FillWidth,
                )
            }
        }

        HorizontalPagerIndicator(
            modifier = Modifier.align(Alignment.BottomCenter),
            pagerState = pagerState,
            inactiveColor = greyColor,
            activeColor = blackColor,
            spacing = 5.dp,
            indicatorHeight = 10.dp,
            indicatorWidth = 10.dp
        )
    }
}