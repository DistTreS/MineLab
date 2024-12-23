package com.minelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.minelab.ui.navigation.NavGraph
import com.minelab.ui.viewmodel.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.minelab.data.local.AppDatabase
import com.minelab.data.entity.User

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginViewModel = LoginViewModel(applicationContext) // Buat instance secara manual

        CoroutineScope(Dispatchers.IO).launch {
            val userDao = AppDatabase.getInstance(applicationContext).userDao()
            userDao.insertUser(
                User(
                    id_user = "1",
                    nim = "12345678",
                    name = "Admin",
                    email = "admin@example.com",
                    password = "admin123",
                    role = "admin"
                )
            )
        }

        setContent {
            val navController = rememberNavController()
            NavGraph(
                navController = navController,
                loginViewModel = loginViewModel
            )
        }
    }
}
