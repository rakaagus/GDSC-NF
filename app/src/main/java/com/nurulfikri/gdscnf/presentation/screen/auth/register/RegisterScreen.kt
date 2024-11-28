package com.nurulfikri.gdscnf.presentation.screen.auth.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nurulfikri.gdscnf.R
import com.nurulfikri.gdscnf.presentation.screen.auth.component.DropDownSelection
import com.nurulfikri.gdscnf.presentation.screen.auth.component.RegisterForm
import com.nurulfikri.gdscnf.presentation.screen.auth.component.RegisterPasswordForm
import com.nurulfikri.gdscnf.presentation.screen.onboarding.component.AuthForm
import com.nurulfikri.gdscnf.ui.theme.IdeBlue
import com.nurulfikri.gdscnf.ui.theme.NavigationDarkBlue
import com.nurulfikri.gdscnf.ui.theme.PinkWeb
import com.nurulfikri.gdscnf.ui.theme.blackColor
import com.nurulfikri.gdscnf.ui.theme.greyColorDark
import com.nurulfikri.gdscnf.ui.theme.lightRed
import com.nurulfikri.gdscnf.utils.ActionKeyboard
import com.nurulfikri.gdscnf.utils.TypeKeyboard

@Composable
fun RegisterScreen(
    moveToLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.signup_background),
            contentDescription = "Background",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            val annotatedString = buildAnnotatedString {
                append("Welcome Back to ")
                withStyle(style = SpanStyle(color = PinkWeb)) {
                    append("GDSC")
                }
            }
            Text(
                text = annotatedString,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = blackColor,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Join our GDSC NF Community and get the best Workshops for free",
                style = MaterialTheme.typography.labelMedium,
                color = greyColorDark,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                shape = RoundedCornerShape(18.dp),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 20.dp)
                ) {

                    var selectedOption by remember { mutableStateOf("") }
                    val options = listOf("Option 1", "Option 2", "Option 3")

                    RegisterForm(
                        label = "Full Name",
                        value = "",
                        keyboardType = TypeKeyboard.TEXT,
                        keyboardActions = ActionKeyboard.NEXT,
                        onValueChange = {}
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    RegisterForm(
                        label = "Your Email",
                        value = "",
                        keyboardType = TypeKeyboard.EMAIL,
                        keyboardActions = ActionKeyboard.NEXT,
                        onValueChange = {}
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    RegisterForm(
                        label = "NF Nim",
                        value = "",
                        keyboardType = TypeKeyboard.NUMBER,
                        keyboardActions = ActionKeyboard.NEXT,
                        onValueChange = {}
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    DropDownSelection(
                        label = "Choose Departement",
                        options = options,
                        selectionOption = selectedOption,
                        onOptionSelected = { selectedOption = it }
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    DropDownSelection(
                        label = "Choose Year of Study",
                        options = options,
                        selectionOption = selectedOption,
                        onOptionSelected = { selectedOption = it }
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    RegisterPasswordForm(label = "Password", value = "") {

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    RegisterPasswordForm(label = "Confirm Password", value = "") {

                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        TextButton(
                            colors = ButtonDefaults.buttonColors(containerColor = IdeBlue),
                            shape = RoundedCornerShape(25.dp),
                            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 5.dp),
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                                .fillMaxWidth()
                                .height(60.dp)
                                .padding(horizontal = 50.dp),
                            onClick = {

                            }
                        ) {
                            Text(
                                text = "Sign Up",
                                style = MaterialTheme.typography.labelLarge,
                                color = Color.White,
                                textAlign = TextAlign.Start,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Already having an accound?",
                            style = MaterialTheme.typography.labelLarge.copy(fontSize = 15.sp),
                            color = blackColor,
                            textAlign = TextAlign.Start,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Login Here",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontSize = 15.sp,
                                fontStyle = FontStyle.Italic,
                                textDecoration = TextDecoration.Underline
                            ),
                            color = NavigationDarkBlue,
                            textAlign = TextAlign.Start,
                            modifier = modifier.clickable {
                                moveToLogin()
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}