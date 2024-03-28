package com.ri.riix.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ri.riix.R
import com.ri.riix.ui.theme.*
import com.ri.riix.utils.dw

@Composable
fun LoginWithOptionScreen(
    onServerNavigation: () -> Unit,
    onClientNavigation: () -> Unit,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        contentAlignment = Alignment.TopStart) {
        Image(
            modifier = Modifier
                .width(0.25.dw)
                .height(Dp((1.26 * 0.25.dw.value).toFloat())),
            painter = painterResource(id = R.drawable.ic_ellipse_top),
            contentDescription = "top"
        )
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        contentAlignment = Alignment.BottomEnd) {
        Image(
            modifier = Modifier
                .width(0.28.dw)
                .height(Dp((1.15 * 0.28.dw.value).toFloat())),
            painter = painterResource(id = R.drawable.ic_ellipse_bottom),
            contentDescription = "bottom"
        )
    }


    Card(modifier = Modifier
        .wrapContentHeight()
        .wrapContentWidth()
        .background(brush = grayBrush),
        border = BorderStroke(1.dp, grayBrush),
        shape = RoundedCornerShape(1.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_riix_violet),
                contentDescription = "aaaaa"
            )

            Text(text = stringResource(id = R.string.because_every_rep), color = colorResource(id = R.color.white))

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .padding(top = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp),
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(64.dp)
                        .background(
                            brush = Brush.linearGradient(
                                listOf(White50, Gray1A50)
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    onClick = onServerNavigation,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(text = stringResource(id = R.string.sign_up_for_free))
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(64.dp)
                        .background(
                            brush = Brush.linearGradient(listOf(ColorA76CC6, ColorCE6260)),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    onClick = onClientNavigation,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(text = stringResource(id = R.string.login))
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun LoginWithOptionScreenPreview() {
    LoginWithOptionScreen({

    }) {

    }
}