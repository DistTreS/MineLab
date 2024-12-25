package com.minelab.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.minelab.R

@Composable
fun AdminDashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE9F4FF))
            .padding(16.dp)
    ) {
        // Greeting Section
        GreetingSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Grid Menu
        GridMenu()
    }
}

@Composable
fun GreetingSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFB3E5FC), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Hello, Fajrin",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        SearchBar()
    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon",
            tint = Color.Gray,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Search",
            color = Color.Gray,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "All",
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}

@Composable
fun GridMenu() {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(64.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            MenuItem(icon = painterResource(id = R.drawable.ic_class), label = "Class")
            MenuItem(icon = painterResource(id = R.drawable.ic_attendance), label = "Attendance")
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(64.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            MenuItem(icon = painterResource(id = R.drawable.ic_assignment), label = "Assignment")
            MenuItem(icon = painterResource(id = R.drawable.ic_user), label = "User")
        }
    }
}

@Composable
fun MenuItem(icon: Painter, label: String) {
    Column(
        modifier = Modifier
            .width(150.dp) // Mengatur lebar tetap 200.dp (atau gunakan fillMaxWidth untuk lebar penuh)
            .height(200.dp) // Mengatur tinggi tetap 200.dp
            .background(Color.White, RoundedCornerShape(16.dp)) // Latar belakang putih dengan sudut melengkung
            .padding(8.dp) ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = icon,
            contentDescription = label,
            modifier = Modifier
                .size(150.dp)
                .height(200.dp)
                .width(200.dp)
        )
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF0277BD)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AdminDashboardPreview() {
    AdminDashboard()
}

@Preview
@Composable
fun MenuItemPreview(){
    MenuItem(icon = painterResource(id = R.drawable.ic_class), label = "Class")
}
