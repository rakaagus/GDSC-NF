package com.nurulfikri.gdscnf.presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.nurulfikri.gdscnf.R
import com.nurulfikri.gdscnf.presentation.screen.home.component.CardJoinGDSC
import com.nurulfikri.gdscnf.presentation.screen.home.component.HomeAppBar
import com.nurulfikri.gdscnf.presentation.screen.home.component.HomePagerBanner
import com.nurulfikri.gdscnf.ui.theme.PinkWeb
import com.nurulfikri.gdscnf.ui.theme.purple

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val userName = "Raka Agus Maulana"

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            HomeContent(userName = userName)
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    userName: String,
) {
    val annotatedTextBuilder = buildAnnotatedString {
        append(stringResource(id = R.string.home_welcome))
        withStyle(style = SpanStyle(color = purple)) {
            append(userName)
        }
    }

    HomeAppBar()
    Spacer(modifier = Modifier.height(15.dp))
    Text(
        text = annotatedTextBuilder,
        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
    HomePagerBanner()
    CardJoinGDSC()
}