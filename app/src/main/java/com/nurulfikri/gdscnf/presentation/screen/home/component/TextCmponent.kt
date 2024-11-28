package com.nurulfikri.gdscnf.presentation.screen.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nurulfikri.gdscnf.ui.theme.TextGrey
import com.nurulfikri.gdscnf.ui.theme.greyColorDark

@Composable
fun HomeTextComponent(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 24.sp),
                color = TextGrey
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "SEE ALL",
                style = MaterialTheme.typography.labelLarge.copy(fontSize = 14.sp),
                color = Color(0xFF007CE0)
            )
        }
        Text(
            text = description,
            style = MaterialTheme.typography.labelMedium.copy(fontSize = 14.sp),
            color = greyColorDark,
            modifier = Modifier.fillMaxWidth()
        )
        content()
    }
}