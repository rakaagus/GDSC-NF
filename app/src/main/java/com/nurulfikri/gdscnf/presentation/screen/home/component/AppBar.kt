package com.nurulfikri.gdscnf.presentation.screen.home.component


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeAppBar(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .padding(horizontal = 16.dp)
    ) {
        Icon(imageVector = Icons.Outlined.Menu, contentDescription = "Notification", modifier = Modifier.size(32.dp))
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "Notification", modifier = Modifier.size(32.dp))
    }
}