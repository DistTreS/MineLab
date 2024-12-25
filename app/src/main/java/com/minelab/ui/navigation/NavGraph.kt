package com.minelab.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.minelab.ui.screens.*
import com.minelab.ui.viewmodel.LoginViewModel

object Routes {
    const val Landing = "landing"
    const val Login = "login"
    const val Dashboard = "admin_dashboard"
    const val AddClass = "add_class"
    const val AdminAttendance = "admin_attendance"
    const val Assignment = "assignment"
    const val AssignmentDetail = "assignment_detail"
    const val AttendanceDetail = "attendance_detail"
    const val AttendanceEdit = "attendance_edit"
    const val AttendanceResponse = "attendance_response"
    const val ClassAdmin = "class_admin"
    const val Instruction = "instruction"
    const val PracticumInstruction = "practicum_instruction"
    const val Profile = "profile"
    const val ProfileDetail = "profile_detail"
    const val Task = "task"
    const val UploadMaterial = "upload_material"
    const val User = "user"
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

    }
}
