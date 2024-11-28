package com.nurulfikri.gdscnf.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.nurulfikri.gdscnf.presentation.screen.auth.register.RegisterScreen
import com.nurulfikri.gdscnf.presentation.screen.home.HomeScreen
import com.nurulfikri.gdscnf.presentation.screen.onboarding.OnboardingScreen
import com.nurulfikri.gdscnf.presentation.screen.splashscreen.SplashScreen

@Composable
fun NavigationBuilder(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = SubGraph.Home
    ) {
        // navigation for splash screen
        navigation<SubGraph.Splash>(startDestination = Dest.SplashScreen){
            composable<Dest.SplashScreen>{
                SplashScreen(
                    moveToOnboarding = {
                        navController.navigate(Dest.OnboardingScreen) {
                            popUpTo(Dest.SplashScreen) {
                                inclusive = true
                            }
                        }
                    },
                    moveToHome = {
                        navController.navigate(Dest.HomeScreen) {
                            popUpTo(Dest.SplashScreen) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }

        // navigation for onboarding & register
        navigation<SubGraph.Onboarding>(startDestination = Dest.OnboardingScreen){
            composable<Dest.OnboardingScreen> {
                OnboardingScreen(
                    moveToRegister = {
                        navController.navigate(Dest.RegisterScreen)
                    }
                )
            }
            composable<Dest.RegisterScreen> {
                RegisterScreen(
                    moveToLogin = {
                        navController.navigate(Dest.OnboardingScreen)
                    }
                )
            }
        }

        // navigation for home route
        navigation<SubGraph.Home>(startDestination = Dest.HomeScreen){
            composable<Dest.HomeScreen> {
                HomeScreen()
            }
        }
    }
}


