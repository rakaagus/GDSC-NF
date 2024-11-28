package com.nurulfikri.gdscnf.presentation.screen.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nurulfikri.gdscnf.R

@Composable
fun CardJoinGDSC(modifier: Modifier = Modifier) {

    val lottieComposition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.arrow_anim))

    Card(
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(15.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.gdsc_logo),
                contentDescription = "Logo GDSC",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = "Join our GDSC Community by just",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 14.sp
                    ),
                    color = Color(0xFF244393),
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Clicking here", style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 14.sp
                        ), color = Color(0xFF244393)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    LottieAnimation(
                        composition = lottieComposition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier.size(width = 40.dp, height = 25.dp)
                    )
                }
            }
        }
    }
}