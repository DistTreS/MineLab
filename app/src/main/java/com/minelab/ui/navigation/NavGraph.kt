package com.minelab.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.minelab.ui.screens.LandingScreen
import com.minelab.ui.screens.LoginScreen
import com.minelab.ui.viewmodel.LoginViewModel

object Routes {
    const val Landing = "landing"
    const val Login = "login"
    const val Dashboard = "admin_dashboard"
}

@Composable
fun NavGraph(
    navController: NavHostController,
    loginViewModel: LoginViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Landing
    ) {
        composable(Routes.Landing) {
            LandingScreen {
                navController.navigate(Routes.Login)
            }
        }
        composable(Routes.Login) {
            LoginScreen(
                viewModel = loginViewModel,
                onNavigateToHome = {
                    navController.navigate(Routes.Dashboard) {
                        popUpTo(Routes.Login) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.Dashboard) {
            AdminDashboardScreen()
        }
    }
}

@Composable
fun AdminDashboardScreen() {
    TODO("Not yet implemented")
}
