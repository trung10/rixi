package com.ri.riix.screen.plan

import android.widget.EditText
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.ri.riix.R
import com.ri.riix.ui.theme.Color6155EA
import com.ri.riix.ui.theme.Color8D8D8D
import com.ri.riix.ui.theme.Color9154DC
import com.ri.riix.ui.theme.ColorA76CC6
import com.ri.riix.ui.theme.ColorCE6260
import com.ri.riix.ui.theme.White20
import com.ri.riix.ui.theme.White5
import com.ri.riix.utils.PopupType
import com.ri.riix.utils.SelectPopup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoPlanScreen(
    onNextNavigation: () -> Unit,
    onBack: () -> Unit
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
                contentDescription = null,
                modifier = Modifier.clickable {
                    onBack.invoke()
                }
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

            Text(text = "Plan Workout", color = colorResource(id = R.color.white))

            Spacer(modifier = Modifier.width(27.dp))
        }

        Column(
            modifier = Modifier
                .padding(start = 22.dp, end = 22.dp, top = 22.dp)
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
                value = planName,
                onValueChange = {
                    planName = it
                })


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .width(80.dp)
                        .padding(2.dp),
                    value = exerciseName,
                    textStyle = TextStyle(color = Color.White),
                    onValueChange = {
                        exerciseName = it
                    })

                var showPopUp by remember { mutableStateOf(false)}

                DownButton("Weight") {
                    showPopUp = !showPopUp
                }

                DownButton("Sets") {

                }

                DownButton("Reps") {

                }
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .width(46.dp)
                .padding(start = 22.dp, end = 22.dp)
                .background(
                    brush = Brush.linearGradient(listOf(ColorA76CC6, ColorCE6260)),
                    shape = RoundedCornerShape(8.dp)
                ),
            onClick = onNextNavigation,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        ) {
            Text(text = "+Add More", modifier = Modifier.padding(start = 5.dp))
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

@Composable
fun DownButton(
    name: String,
    onClick: () -> Unit
) {
    var showPopUp by remember { mutableStateOf(false)}

    Row(
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                showPopUp = !showPopUp
                onClick.invoke() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(text = name, color = Color.White)

        Image(painter = painterResource(id = R.drawable.ic_down), contentDescription = null)

        if (showPopUp)
            SelectPopup(list = listOf(1,2,3,4,5), type = PopupType.SET) {
                showPopUp = false
            }
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    CreatePlanScreen({

    }) {

    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreviewItem() {
    DownButton("aaaaa") {

    }
}