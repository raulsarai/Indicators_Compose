package com.example.testes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import com.example.testes.ui.theme.LinkedinTestesTheme
import kotlin.math.absoluteValue


class CircleIndicator : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val numPages = 5
            val pagerStateHorizontal = rememberPagerState { numPages }
            val pagerStateVertical = rememberPagerState { numPages }
            LinkedinTestesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        PagerHorizontal(pagerStateHorizontal, numPages)
                        PagerVertical(pagerStateVertical, numPages)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerHorizontal(pagerState: PagerState, numPages: Int) {

    Column(
        modifier = Modifier.padding(vertical = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier.padding(horizontal = 10.dp),
            pageSpacing = 10.dp,
            state = pagerState,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(145.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = Color.Blue)
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        CircleIndicator(state = pagerState, numPages = numPages, dotColor = Color.Blue)

        Spacer(modifier = Modifier.padding(vertical = 50.dp))

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerVertical(pagerState: PagerState, numPages: Int) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {

        CircleIndicator(
            state = pagerState,
            numPages = numPages,
            dotColor = Color.Red,
            orientation = "vertical"
        )

        Spacer(modifier = Modifier.padding(horizontal = 10.dp))

        VerticalPager(
            modifier = Modifier.padding(horizontal = 10.dp),
            pageSpacing = 10.dp,
            state = pagerState,
        ) {
            Box(
                modifier = Modifier
                    .width(250.dp)
                    .height(250.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = Color.Red)
            )
        }


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CircleIndicator(
    modifier: Modifier = Modifier,
    state: PagerState,
    dotColor: Color,
    numPages: Int = 0,
    orientation: String = "horizontal"
) {

    if (orientation == "horizontal") {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            for (i in 0 until numPages) {
                val offset = state.indicatorOffsetForPage(i)
                Box(
                    modifier = Modifier.size(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        Modifier
                            .size(
                                lerp(6.dp, 32.dp, offset)
                            )
                            .border(
                                width = 3.dp,
                                color = Color.Black,
                                shape = CircleShape,
                            )
                            .background(color = dotColor, shape = CircleShape)

                    )
                }
            }
        }
    } else {
        Column(
            modifier = modifier
                .wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            for (i in 0 until numPages) {
                val offset = state.indicatorOffsetForPage(i)
                Box(
                    modifier = Modifier.size(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        Modifier
                            .size(
                                lerp(6.dp, 32.dp, offset)
                            )
                            .border(
                                width = 3.dp,
                                color = Color.Black,
                                shape = CircleShape,
                            )
                            .background(color = dotColor, shape = CircleShape)

                    )
                }
            }
        }
    }
}


