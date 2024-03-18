
# How to implement:

### In your build gradle dependencies set accompanist pager repository
    implementation ("com.google.accompanist:accompanist-pager:0.28.0")

# straight to the point
### Code snippet

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
# Demo:

https://github.com/raulsarai/Circular_Indicator_Compose/assets/81999143/f47c6822-6921-4180-a290-f37661c1131a


