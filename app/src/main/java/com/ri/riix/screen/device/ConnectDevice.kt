package com.ri.riix.screen.device

import android.os.Handler
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ri.riix.R
import com.ri.riix.ui.theme.Color00FFAB80
import com.ri.riix.ui.theme.Color6155EA
import com.ri.riix.ui.theme.Color747C8B
import com.ri.riix.ui.theme.Color9154DC
import com.ri.riix.ui.theme.White20
import com.ri.riix.ui.theme.White5
import com.ri.riix.utils.RoundCircleProgressIndicator
import com.ri.riix.utils.toTime


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectDeviceScreen(
    /*viewModel: CreatePlanViewModel,*/
    onNextNavigation: () -> Unit,
    onBack: () -> Unit
) {
    var planName by remember { mutableStateOf("Leg Day") }

    var exerciseName by remember { mutableStateOf("Squad") }

    var isConnected by remember { mutableStateOf(false) }

    Handler().postDelayed({
        isConnected = true
    }, 1000)

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

            this@Column.AnimatedVisibility(
                modifier = Modifier.align(Alignment.TopCenter),
                visible = isConnected) {
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
                        Text(text = "Connect")
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

                MilesToneWorkOut(current = 0, total = 4)

                Spacer(modifier = Modifier.height(80.dp))

                WorkOutProcess(0, 3, ProcessType.REP)

                Text(
                    modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp),
                    text = "Take your spot. \n" +
                            "We will do the rest.", color = Color.White,
                    style = TextStyle(textAlign = TextAlign.Center)
                )

                /*Column(
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
                        Text(text = "Let's go")
                    }
                }*/

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(46.dp)
                        .padding(top = 20.dp, start = 16.dp, end = 16.dp, bottom = 10.dp)
                        .background(
                            brush = Brush.linearGradient(listOf(Color9154DC, Color6155EA)),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    onClick = onNextNavigation,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text(text = "Let's go")
                }

                Text(
                    text = "Skip", color = Color.White,
                    style = TextStyle(textAlign = TextAlign.Center)
                )
            }
        }
    }
}

@Composable
fun MilesToneWorkOut(current: Int, total: Int) {
    var size by remember { mutableStateOf(IntSize.Zero) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .onSizeChanged {
                size = it
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        repeat(total) { index ->
            Spacer(modifier = Modifier
                .background(
                    color = if (index < current) Color00FFAB80 else Color747C8B,
                    shape = RoundedCornerShape(8.dp)
                )
                .then(
                    with(LocalDensity.current) {
                        Modifier.size(
                            width = (size.width / (total + 1)).toDp(),
                            height = 10.dp
                        )
                    }
                ))
        }
    }
}

enum class ProcessType {
    TIME, REP
}

@Composable
fun WorkOutProcess(current: Int, total: Int, type: ProcessType) {
    var size by remember { mutableStateOf(IntSize.Zero) }

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 20.dp)
        .onSizeChanged {
            size = it
        }
    ) {

        RoundCircleProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .then(
                    with(LocalDensity.current) {
                        Modifier.size(
                            width = (size.width / 2).toDp(),
                            height = (size.width / 2).toDp()
                        )
                    }
                ),
            progress = if(current/total == 0) 0.01f else current/total.toFloat(),
            color = Color00FFAB80,
            strokeWidth = 10.dp
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (type == ProcessType.REP) "$current" else current.toTime(), color = Color.White,
                style = TextStyle(textAlign = TextAlign.Center, fontSize = 50.sp)
            )

            Text(
                text = if (type == ProcessType.TIME) "Sec" else "Rep", color = Color.White,
                style = TextStyle(textAlign = TextAlign.Center, fontSize = 20.sp)
            )
        }

        /* Spacer(modifier = Modifier
             .background(
                 color = if (index < current) Color00FFAB80 else Color747C8B,
                 shape = RoundedCornerShape(8.dp)
             )
             .then(
                 with(LocalDensity.current) {
                     Modifier.size(
                         width = (size.width / (total + 1)).toDp(),
                         height = 10.dp
                     )
                 }
             ))*/
    }
}

@Preview(showBackground = false)
@Composable
fun WorkOutProcessPreview() {
    WorkOutProcess(1, 3, ProcessType.TIME)
}

@Preview(showBackground = false)
@Composable
fun MilesToneWorkOutPreview() {
    MilesToneWorkOut(1, 3)
}


@Preview(showBackground = false)
@Composable
fun GreetingPreviewRestTime() {
    WorkOutScreen({}) {

    }
}

