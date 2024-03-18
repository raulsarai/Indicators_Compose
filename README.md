
# How to implement:

### In your build gradle dependencies set accompanist pager repository
    implementation ("com.google.accompanist:accompanist-pager:0.28.0")

# straight to the point
### Code snippet

## Circular Indicator

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

## Line Indicator

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

## Glow Indicator
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
        
## Square Indicator
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
# Demo:

https://github.com/raulsarai/Circular_Indicator_Compose/assets/81999143/f47c6822-6921-4180-a290-f37661c1131a

https://github.com/raulsarai/Indicators_Compose/assets/81999143/d2e8c341-c941-4bbc-9aa8-6760deef8c59


