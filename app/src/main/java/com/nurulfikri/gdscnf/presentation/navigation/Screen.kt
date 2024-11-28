package com.nurulfikri.gdscnf.presentation.navigation

import kotlinx.serialization.Serializable

sealed class SubGraph{

    @Serializable
    data object Splash: SubGraph()

    @Serializable
    data object Onboarding: SubGraph()

    @Serializable
    data object Home: SubGraph()

    @Serializable
    data object Profile: SubGraph()

}

sealed class Dest{

    @Serializable
    data object SplashScreen: Dest()

    @Serializable
    data object OnboardingScreen: Dest()

    @Serializable
    data object RegisterScreen: Dest()

    @Serializable
    data object HomeScreen: Dest()

}