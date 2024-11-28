package com.nurulfikri.gdscnf.presentation.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.TextField
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.nurulfikri.gdscnf.R
import com.nurulfikri.gdscnf.presentation.screen.onboarding.component.AuthForm
import com.nurulfikri.gdscnf.presentation.screen.onboarding.component.PasswordForm
import com.nurulfikri.gdscnf.ui.theme.NavigationDarkBlue
import com.nurulfikri.gdscnf.ui.theme.blackColor
import com.nurulfikri.gdscnf.ui.theme.darkBlue
import com.nurulfikri.gdscnf.ui.theme.greyColorDark
import com.nurulfikri.gdscnf.ui.theme.lightBlue
import com.nurulfikri.gdscnf.ui.theme.lightRed
import com.nurulfikri.gdscnf.ui.theme.lightYellow
import com.nurulfikri.gdscnf.utils.ActionKeyboard
import com.nurulfikri.gdscnf.utils.OnboardingPage
import com.nurulfikri.gdscnf.utils.TypeKeyboard
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(
    moveToRegister: () -> Unit,
    modifier: Modifier = Modifier
) {
    val page = listOf(
        OnboardingPage.First,
        OnboardingPage.Second,
        OnboardingPage.Third
    )

    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()

    LaunchedEffect(pagerState.currentPage) {
        delay(3500)
        var newPosition = pagerState.currentPage + 1
        if (newPosition > page.size - 1) newPosition = 0
        pagerState.animateScrollToPage(newPosition)
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContainerColor = Color.White,
        sheetTonalElevation = 50.dp,
        sheetShadowElevation = 50.dp,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val text = stringResource(id = R.string.bs_title)
                val annotatedString = buildAnnotatedString {
                    append(text)
                    withStyle(style = SpanStyle(color = lightRed)) {
                        append(" GDSC")
                    }
                }
                Text(
                    text = annotatedString,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = blackColor,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Text(
                    text = stringResource(id = R.string.bs_desc),
                    style = MaterialTheme.typography.labelMedium,
                    color = greyColorDark,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                AuthForm(
                    label = "Your email",
                    value = "",
                    keyboardType = TypeKeyboard.EMAIL,
                    keyboardActions = ActionKeyboard.NEXT,
                    modifier = Modifier.padding(horizontal = 20.dp),
                    onValueChange = {}
                )
                Spacer(modifier = Modifier.height(20.dp))
                PasswordForm(
                    label = "Password",
                    value = "",
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                        colors = ButtonDefaults.buttonColors(containerColor = blackColor),
                        shape = RoundedCornerShape(25.dp),
                        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 5.dp),
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(horizontal = 20.dp),
                        onClick = {

                        }
                    ) {
                        Text(
                            text = "Login",
                            style = MaterialTheme.typography.labelLarge,
                            color = Color.White,
                            textAlign = TextAlign.Start,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Don't, Have An account?",
                        style = MaterialTheme.typography.labelLarge,
                        color = blackColor,
                        textAlign = TextAlign.Start,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Signup Here",
                        style = MaterialTheme.typography.labelLarge.copy(
                            textDecoration = TextDecoration.Underline,
                            fontStyle = FontStyle.Italic
                        ),
                        color = NavigationDarkBlue,
                        textAlign = TextAlign.Start,
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        },
        sheetPeekHeight = 0.dp
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                count = 3,
                state = pagerState,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.weight(10f)
            ) { position ->
                PagerScreen(onBoardingPage = page[position])
            }
            PagerIndicator(pagerState = pagerState)
            TextButton(
                colors = ButtonDefaults.buttonColors(containerColor = blackColor),
                shape = RoundedCornerShape(14.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 5.dp),
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 25.dp, end = 35.dp),
                onClick = {
                    scope.launch {
                        scaffoldState.bottomSheetState.expand()
                    }
                }
            ) {
                Text(
                    text = "Continue",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.White,
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}

@Composable
fun PagerScreen(
    onBoardingPage: OnboardingPage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        val title = stringResource(id = onBoardingPage.title)
        val annotatedString = when (onBoardingPage.title) {
            R.string.title_onboard_1 -> {
                buildAnnotatedString {
                    append("Find ")
                    withStyle(style = SpanStyle(color = lightBlue)) {
                        append("New ")
                    }
                    append("Experience")
                }
            }

            R.string.title_onboard_2 -> {
                buildAnnotatedString {
                    append("Improve Your ")
                    withStyle(style = SpanStyle(color = lightRed)) {
                        append("Skills")
                    }
                }
            }

            R.string.title_onboard_3 -> {
                buildAnnotatedString {
                    append("Join Our ")
                    withStyle(style = SpanStyle(color = lightYellow)) {
                        append("Community")
                    }
                }
            }

            else -> {
                buildAnnotatedString {
                    append(title)
                }
            }
        }
        Image(
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Image Onboarding",
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(start = 15.dp, end = 17.dp)
        )
        Spacer(modifier = Modifier.height(45.dp))
        Text(
            text = annotatedString,
            style = MaterialTheme.typography.headlineLarge,
            color = blackColor,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 25.dp, end = 35.dp)
        )
        Text(
            text = stringResource(id = onBoardingPage.description),
            style = MaterialTheme.typography.labelLarge,
            color = greyColorDark,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 25.dp, end = 35.dp)
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerIndicator(pagerState: PagerState) {
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        val activeIndex = pagerState.currentPage
        repeat(pagerState.pageCount) { index ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (index == activeIndex) Color(0xFF1E1E1E) else Color(0xFF9A9A9A))
                    .size(width = if (index == activeIndex) 20.dp else 10.dp, height = 10.dp)
            )
        }
    }
}
