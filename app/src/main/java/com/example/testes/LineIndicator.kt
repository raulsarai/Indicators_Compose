package com.example.testes

import android.annotation.SuppressLint
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import com.example.testes.ui.theme.LinkedinTestesTheme


class LineIndicator : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val numPages = 5
            val pagerStateHorizontal = rememberPagerState { numPages }
            LinkedinTestesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        PagerHorizontal2(pagerStateHorizontal, numPages)
                    }
                }
            }
        }
    }
}

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun PagerHorizontal2(pagerState: PagerState, numPages: Int) {

        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 15.dp),
                verticalArrangement = Arrangement.Center,
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

            LineIndicator(state = pagerState, numPages = numPages)

            Spacer(modifier = Modifier.padding(vertical = 5.dp))

            GlowIndicator(state = pagerState, numPages = numPages)

            Spacer(modifier = Modifier.padding(vertical = 5.dp))

            SquareIndicator(state = pagerState, numPages = numPages)

            Spacer(modifier = Modifier.padding(vertical = 5.dp))

        }
    }

    @SuppressLint("NotConstructor")
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun LineIndicator(
        modifier: Modifier = Modifier,
        state: PagerState,
        numPages: Int = 0,
    ) {

        Row(
            modifier = modifier
                .width(32.dp * numPages)
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            for (i in 0 until numPages) {
                val offset = state.indicatorOffsetForPage(i)
                Box(
                    modifier = Modifier
                        .padding(horizontal = 2.dp)
                        .weight(.5f + (offset * 3f))
                        .height(8.dp)
                        .background(
                            color = Color.Blue,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {

                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun GlowIndicator(
        modifier: Modifier = Modifier,
        state: PagerState,
        numPages: Int = 0,
    ) {
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
                    modifier = Modifier
                        .size(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        Modifier
                            .size(
                                lerp(8.dp, 32.dp, offset)
                            )
                            .blur(
                                radius = lerp(0.dp, 16.dp, offset),
                                edgeTreatment = BlurredEdgeTreatment.Unbounded,
                            )
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Red,
                                        Color.Green,
                                    )
                                ),
                                shape = CircleShape
                            )
                    )
                    Box(
                        Modifier
                            .size(
                                lerp(14.dp, 22.dp, offset)
                            )
                            .background(
                                color = Color.Blue,
                                shape = CircleShape,
                            )
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun SquareIndicator(
        modifier: Modifier = Modifier,
        state: PagerState,
        numPages: Int = 0,
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            for (i in 0 until numPages) {
                Box(
                    modifier = Modifier.size(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val offset = state.indicatorOffsetForPage(i)
                    Box(
                        Modifier
                            .rotate(135f * offset)
                            .size(
                                lerp(8.dp, 22.dp, offset)
                            )
                            .border(
                                width = 2.dp,
                                color = Color.Blue,
                                shape = RectangleShape,
                            )
                    )
                }
            }
        }
    }






