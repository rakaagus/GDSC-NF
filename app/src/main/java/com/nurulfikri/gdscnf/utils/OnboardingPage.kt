package com.nurulfikri.gdscnf.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.nurulfikri.gdscnf.R

sealed class OnboardingPage(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
){
    object First: OnboardingPage(
        image = R.drawable.ob1,
        title = R.string.title_onboard_1,
        description = R.string.desc_onboard_1
    )

    object Second: OnboardingPage(
        image = R.drawable.ob2,
        title = R.string.title_onboard_2,
        description = R.string.desc_onboard_2
    )

    object Third: OnboardingPage(
        image = R.drawable.ob3,
        title = R.string.title_onboard_3,
        description = R.string.desc_onboard_3
    )
}
