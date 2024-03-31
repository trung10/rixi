package com.ri.riix.screen.setGoal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ri.riix.R
import com.ri.riix.ui.theme.*

@Composable
fun SetBodyType(
    /*viewModel: CreatePlanViewModel,*/
    list: List<String>,
    onNext: (d: String) -> Unit,
    onBack: () -> Unit
) {
    var indexSelected by remember { mutableStateOf(-1) }

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
                modifier = Modifier.padding(),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null
            )

            Text(text = "Set Body Type", color = colorResource(id = R.color.white),
                fontSize = 16.sp)

            Spacer(modifier = Modifier.width(27.dp))
        }

        Column(
            modifier = Modifier
                .padding(DefaultPadding)
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(listOf(White5, White20)),
                    shape = RoundedCornerShape(8.dp)
                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Milestone(1, 7)

            Text(
                modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp),
                text = "What is your goal?", color = Color.White,
                fontSize = 30.sp
            )

            Text(
                modifier = Modifier.padding(top = 8.dp, start = 20.dp, end = 20.dp),
                text = "Choose Your body type", color = White60
            )

            Row(
                modifier = Modifier
                    .padding(DefaultPadding)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(3) {
                    Column(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .background(
                                brush = if (it == indexSelected) {
                                    pinkBrush
                                } else {
                                    grayBrush
                                },
                                shape = RoundedCornerShape(8.dp)
                            )
                            .border(
                                width = 1.dp,
                                brush = buttonBorderBrush,
                                shape = RoundedCornerShape(8.dp)
                            ).clickable {
                                indexSelected = it
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier.padding(6.dp),
                            painter = when (it) {
                                0 -> {
                                    painterResource(id = R.drawable.ic_thin)
                                }
                                1 -> {
                                    painterResource(id = R.drawable.ic_medium)
                                }
                                else -> {
                                    painterResource(id = R.drawable.ic_fat)
                                }
                            },
                            contentDescription = null)
                        Text(modifier = Modifier.padding(6.dp), text = list[it],
                            color = colorResource(id = R.color.white))}
                    }
                }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(DefaultPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = nextBrush,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    onClick = {
                        if (indexSelected > 0) onNext(list[indexSelected])
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                ) {
                    Text(text = "Next")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingAaPreview() {
    SetBodyType(stringArrayResource(id = R.array.body_type).toList(),
        {

        }) {}
}