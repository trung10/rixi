package com.ri.riix.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ri.riix.R
import com.ri.riix.model.Category
import com.ri.riix.ui.theme.Color6155EA
import com.ri.riix.ui.theme.Color6655E95C
import com.ri.riix.ui.theme.Color9154DC
import com.ri.riix.ui.theme.Gray1A50
import com.ri.riix.ui.theme.White20
import com.ri.riix.ui.theme.White36
import com.ri.riix.ui.theme.White5
import com.ri.riix.ui.theme.White50

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onServerNavigation: () -> Unit
) {
    Column {
        /*NordicAppBar(
            text = stringResource(id = R.string.welcome_message)
        )*/

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProfileView {

                }

                Image(
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = null
                )
            }

            Spacer(Modifier.height(16.dp))

            val list = listOf(
                Category(R.drawable.ic_weight, "Plan\nWorkout"),
                Category(R.drawable.ic_scale, "Connect\nScale"),
                Category(R.drawable.ic_document_normal, "Food\nDairy"),
                Category(R.drawable.ic_chart_square, "Overall\nProgress")
            )

            CategoryList(list) {

            }

            Spacer(Modifier.height(16.dp))

            StartBodybuilding {

            }

            /*Text(
                text = stringResource(id = R.string.start_game_description)
            )*/

            /*Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = stringResource(
                id = R.string.app_name
            )
            )
            Text(text = stringResource(id = R.string.welcome_message))

            Button(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth(),
                onClick = onServerNavigation
            ) {
                Text(text = stringResource(id = R.string.start_game))
            }

            Button(
                onClick = {}
            ) {
                Text(text = stringResource(id = R.string.join_game))
            }*/
        }
    }
}


@Preview(showBackground = false)
@Composable
fun HomePreview() {
    HomeScreen({})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileView(
    onProfileNavigation: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_avatar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(43.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.good_morning),
                style = MaterialTheme.typography.bodySmall,
                color = Color.White,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "Mukaram",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ProfilePreview() {
    ProfileView() {}
}

@Composable
fun CategoryView(
    category: Category,
    navigateToCategory: (Category) -> Unit
) {

    Column(
        modifier = Modifier
            .clickable { navigateToCategory.invoke(category) }
            .size(85.dp, 120.dp)
            .border(2.dp, White36, shape = RoundedCornerShape(8.dp))
            .background(
                brush = Brush.linearGradient(
                    listOf(White20, White5)
                ),
                shape = RoundedCornerShape(8.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = category.id),
            contentDescription = null,
        )

        Text(
            text = category.name,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 2,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CategoryList(
    list: List<Category>,
    navigateToCategory: (Category) -> Unit
) {
    val listState = rememberLazyListState()

    LazyRow(state = listState,
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(list) { category ->
            CategoryView(
                category,
                navigateToCategory
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CategoryPreview() {
    CategoryView(category = Category(R.drawable.ic_launcher_background, "aaaa")) {

    }
}

@Composable
fun StartBodybuilding(
    navigateToCategory: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(2.dp, White36),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    listOf(White20, White5)
                )
            ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center) {
            Text(
                text = "Let the \n" +
                        "Bodybuilding Begin",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp),
                color = Color.White
            )

            Text(
                text = "Push Start to Begin",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 8.dp),
                color = Color.White
            )

            Button(
                onClick = { navigateToCategory.invoke() },
                modifier = Modifier
                    .fillMaxWidth()
                    .width(64.dp)
                    .padding(20.dp)
                    .background(
                        brush = Brush.linearGradient(
                            listOf(Color9154DC, Color6155EA)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(text = "Start")
            }
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartBodybuildingPreview() {
    StartBodybuilding {

    }
}