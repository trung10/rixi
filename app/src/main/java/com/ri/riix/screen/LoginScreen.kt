package com.ri.riix.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ri.riix.R
import com.ri.riix.ui.theme.ColorA76CC6
import com.ri.riix.ui.theme.ColorCE6260
import com.ri.riix.ui.theme.Gray1A50
import com.ri.riix.ui.theme.White50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onServerNavigation: () -> Unit,
    onClientNavigation: () -> Unit,
) {
    Column {

        Column(
            modifier = Modifier
                .padding(22.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
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
fun GreetingPreview() {
    LoginScreen({

    }) {

    }
}

@Composable
fun aaa() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        Button(
            onClick = { }
        ) {
            Text(text = stringResource(id = R.string.start_game))
        }
        Button(
            onClick = { }
        ) {
            Text(text = stringResource(id = R.string.join_game))
        }
    }
}
