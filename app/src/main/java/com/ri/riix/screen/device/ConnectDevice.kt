package com.ri.riix.screen.device

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ri.riix.R
import com.ri.riix.ui.theme.Color00FFAB80
import com.ri.riix.ui.theme.Color6155EA
import com.ri.riix.ui.theme.Color9154DC
import com.ri.riix.ui.theme.White20
import com.ri.riix.ui.theme.White5


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectDeviceScreen(
    /*viewModel: CreatePlanViewModel,*/
    onNextNavigation: () -> Unit,
    onBack: () -> Unit
) {
    var planName by remember { mutableStateOf("Leg Day") }

    var exerciseName by remember { mutableStateOf("Squad") }

    /*var textState by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue())
    }*/

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null
            )

            Text(text = "Searching", color = colorResource(id = R.color.white))

            Spacer(modifier = Modifier.width(27.dp))
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Row(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .background(
                        brush = Brush.linearGradient(listOf(Color00FFAB80, Color00FFAB80)),
                        shape = RoundedCornerShape(8.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    painter = painterResource(id = R.drawable.ic_device_connect),
                    contentDescription = null,
                    tint = Color.White
                )

                Text(
                    modifier = Modifier
                        .padding(end = 10.dp), text = "Connected", color = Color.White
                )

            }

            Column(
                modifier = Modifier
                    .padding(start = 22.dp, end = 22.dp, top = 11.dp, bottom = 51.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        brush = Brush.linearGradient(listOf(White5, White20)),
                        shape = RoundedCornerShape(8.dp)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Image(painter = painterResource(id = R.mipmap.ic_device), contentDescription = null)

                Text(
                    modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp),
                    text = "Connect your RIIX Device, and \n" +
                            "We'll Start the Count.", color = Color.White,
                    style = TextStyle(textAlign = TextAlign.Center)
                )

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(46.dp)
                            .padding(10.dp)
                            .background(
                                brush = Brush.linearGradient(listOf(Color9154DC, Color6155EA)),
                                shape = RoundedCornerShape(8.dp)
                            ),
                        onClick = onNextNavigation,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Text(text = "Connected")
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkOutScreen(
    /*viewModel: CreatePlanViewModel,*/
    onNextNavigation: () -> Unit,
    onBack: () -> Unit
) {
    var planName by remember { mutableStateOf("Leg Day") }

    var exerciseName by remember { mutableStateOf("Squad") }

    /*var textState by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue())
    }*/

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null
            )

            Text(text = "Squat", color = colorResource(id = R.color.white))

            Spacer(modifier = Modifier.width(27.dp))
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Row(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .background(
                        brush = Brush.linearGradient(listOf(Color00FFAB80, Color00FFAB80)),
                        shape = RoundedCornerShape(8.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    painter = painterResource(id = R.drawable.ic_device_connect),
                    contentDescription = null,
                    tint = Color.White
                )

                Text(
                    modifier = Modifier
                        .padding(end = 10.dp), text = "Connected", color = Color.White
                )

            }

            Column(
                modifier = Modifier
                    .padding(start = 22.dp, end = 22.dp, top = 11.dp, bottom = 51.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        brush = Brush.linearGradient(listOf(White5, White20)),
                        shape = RoundedCornerShape(8.dp)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Image(painter = painterResource(id = R.mipmap.ic_device), contentDescription = null)

                Text(
                    modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp),
                    text = "Connect your RIIX Device, and \n" +
                            "We'll Start the Count.", color = Color.White,
                    style = TextStyle(textAlign = TextAlign.Center)
                )

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(46.dp)
                            .padding(10.dp)
                            .background(
                                brush = Brush.linearGradient(listOf(Color9154DC, Color6155EA)),
                                shape = RoundedCornerShape(8.dp)
                            ),
                        onClick = onNextNavigation,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Text(text = "Connected")
                    }
                }

                Text(
                    text = "Skip", color = Color.White,
                    style = TextStyle(textAlign = TextAlign.Center)
                )


            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreviewRestTime() {
    WorkOutScreen({}) {

    }
}

