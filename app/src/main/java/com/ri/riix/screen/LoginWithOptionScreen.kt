package com.ri.riix.screen

import android.view.View
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ri.riix.R
import com.ri.riix.ui.theme.*
import com.ri.riix.utils.dh
import com.ri.riix.utils.dw

@Composable
fun LoginWithOptionScreen(
    onLogin: () -> Unit,
    onLoginGoogle: () -> Unit,
    onLoginApple: () -> Unit,
    onLoginFacebook: () -> Unit) {
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

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        contentAlignment = Alignment.Center) {

        Card(modifier = Modifier
            .width(0.9.dw)
            .height(0.83.dh)
            .background(brush = grayBrush),
            border = BorderStroke(1.dp, grayBrush),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    modifier = Modifier.padding(top = 100.dp, start = DefaultPadding),
                    painter = painterResource(id = R.drawable.ic_riix_small),
                    contentDescription = "aaaaa"
                )

                Text(modifier = Modifier.padding(start = DefaultPadding),
                    text = stringResource(id = R.string.welcome_lets_customer),
                    color = colorResource(id = R.color.white))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(ButtonWidth)
                        .padding(DefaultPadding)
                        .background(
                            brush = Brush.linearGradient(listOf(ColorA76CC6, ColorCE6260)),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    onClick = onLogin,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(text = stringResource(id = R.string.login))
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .width(ButtonWidth)
                    .padding(DefaultPadding),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)) {

                    Spacer(modifier = Modifier
                        .height(2.dp)
                        .width(0.35.dw)
                        .background(color = Color5F626B))

                    Text(text = stringResource(id = R.string.or),
                        color = colorResource(id = R.color.white))

                    Spacer(modifier = Modifier
                        .height(2.dp)
                        .width(0.35.dw)
                        .background(color = Color5F626B))
                }

                Column(
                    modifier = Modifier
                        .padding(DefaultPadding)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(ButtonWidth)
                            .background(
                                brush = Brush.linearGradient(
                                    listOf(White20, White5)
                                ),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .border(width = 1.dp,
                            brush = buttonBorderBrush,
                            shape = RoundedCornerShape(8.dp)),
                        onClick = onLoginGoogle,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues(5.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "",
                            Modifier.padding(end = 5.dp))
                        Text(text = stringResource(id = R.string.continue_with_google))
                    }

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(ButtonWidth)
                            .background(
                                brush = Brush.linearGradient(
                                    listOf(Color801877F2, Color801877F2)
                                ),
                                shape = RoundedCornerShape(8.dp),
                            )
                            .border(width = 1.dp,
                                brush = buttonBorderBrush,
                                shape = RoundedCornerShape(8.dp)),
                        onClick = onLoginFacebook,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = "",
                            Modifier.padding(end = 5.dp))
                        Text(text = stringResource(id = R.string.continue_with_facebook))
                    }

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(ButtonWidth)
                            .background(
                                brush = grayBrush,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .border(width = 1.dp,
                                brush = buttonBorderBrush,
                                shape = RoundedCornerShape(8.dp)),
                        onClick = onLoginApple,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    ) {
                        Icon(painter = painterResource(id = R.drawable.ic_apple),
                            contentDescription = "",
                            Modifier.padding(end = 5.dp))
                        Text(text = stringResource(id = R.string.continue_with_apple))
                    }
                }
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun LoginWithOptionScreenPreview() {
    LoginWithOptionScreen({

    }, {}, {}) {

    }
}