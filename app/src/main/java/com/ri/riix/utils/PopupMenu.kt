package com.ri.riix.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.ri.riix.ui.theme.White20
import com.ri.riix.ui.theme.White5


enum class PopupType {
    WEIGHT, SET, REP, SEC
}

@Composable
fun SelectPopup(list: List<Int>, type: PopupType,
                onSelected: (Int) -> Unit) {
    Popup(
        alignment = Alignment.TopCenter,
        offset = IntOffset(0, 90),
        properties = PopupProperties(
            focusable = true,
            dismissOnClickOutside = true,
            securePolicy = SecureFlagPolicy.SecureOff,
            dismissOnBackPress = true,
            excludeFromSystemGesture = false
        )
    ) {
        val listState = rememberLazyListState()

        Row(
            modifier = Modifier
                .padding(10.dp)
                .background(
                    brush = Brush.linearGradient(
                        listOf(White20, White5)
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            LazyColumn(
                state = listState,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    items(list) {
                        MenuItems(it, type, onSelected)
                    }
                })
        }
    }
}

@Composable
fun MenuItems(value: Int, type: PopupType, onSelected: (Int) -> Unit) {
    /*PostHeaderImage(post)
    Spacer(androidx.compose.ui.Modifier.height(defaultSpacerSize))
    Text(post.title, style = MaterialTheme.typography.headlineLarge)
    Spacer(Modifier.height(8.dp))
    if (post.subtitle != null) {
        Text(post.subtitle, style = MaterialTheme.typography.bodyMedium)
        Spacer(androidx.compose.ui.Modifier.height(defaultSpacerSize))
    }*/
    val type = when (type) {
        PopupType.REP -> "Reps"
        PopupType.WEIGHT -> "kg"
        PopupType.SET -> "Sets"
        PopupType.SEC -> "Secs"

    }
    Text(
        modifier = Modifier.clickable { onSelected.invoke(value) },
        text = "$value $type", color = Color.White
    )
    /*item { PostMetadata(post.metadata, Modifier.padding(bottom = 24.dp)) }
    items(post.paragraphs) { Paragraph(paragraph = it) }*/
}

@Preview(showBackground = false)
@Composable
fun review() {
    SelectPopup(listOf(1, 2, 3, 4, 5), PopupType.SET) {

    }
}