package com.ri.riix.screen.plan

import android.widget.EditText
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ri.riix.R
import com.ri.riix.ui.theme.Color6155EA
import com.ri.riix.ui.theme.Color8D8D8D
import com.ri.riix.ui.theme.Color9154DC
import com.ri.riix.ui.theme.White20
import com.ri.riix.ui.theme.White5

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoPlanScreen(
    onNextNavigation: () -> Unit,
    onBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(120.dp),
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

            Text(text = "Plan Workout", color = colorResource(id = R.color.white))

            Spacer(modifier = Modifier.width(27.dp))
        }

        Column(
            modifier = Modifier
                .padding(22.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(listOf(White5, White20)),
                    shape = RoundedCornerShape(8.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                modifier = Modifier.padding(top = 20.dp),
                painter = painterResource(id = R.drawable.ic_riix_violet),
                contentDescription = "aaaaa"
            )

            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "No plan added yet", color = Color8D8D8D
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
                    Text(text = "Create Plan")
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePlanScreen(
    onNextNavigation: () -> Unit,
    onBack: () -> Unit,
) {
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

            Text(text = "Plan Workout", color = colorResource(id = R.color.white))

            Spacer(modifier = Modifier.width(27.dp))
        }

        Column(
            modifier = Modifier
                .padding(22.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(listOf(White5, White20)),
                    shape = RoundedCornerShape(8.dp)
                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp),
                text = "Plan Name", color = Color8D8D8D
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                textStyle = TextStyle(color = Color.White),
                value = "Leg Day",
                onValueChange = {

                })


            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "No plan added yet", color = Color8D8D8D
            )
        }

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
                Text(text = "Create Plan")
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    CreatePlanScreen({

    }) {

    }
}