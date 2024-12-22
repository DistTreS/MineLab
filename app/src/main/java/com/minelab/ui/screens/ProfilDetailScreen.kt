package com.minelab.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minelab.R

@Composable
fun ProfileDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF87CEFA))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Image and Name
        Image(
            painter = painterResource(id = R.drawable.fajrin),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Fajrin Putra Pratama",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Profile Information Card
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFFE0E0E0)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                ProfileInfoItem(label = "Email", value = "221152222_Fawais.Student@gmail.com")
                Spacer(modifier = Modifier.height(16.dp))
                ProfileInfoItem(label = "Jurusan", value = "Sistem Informasi")
                Spacer(modifier = Modifier.height(16.dp))
                ProfileInfoItem(label = "No Hp", value = "")
                Spacer(modifier = Modifier.height(16.dp))
                ProfileInfoItem(label = "Alamat", value = "Jakarta")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Edit Button
        Button(
            onClick = { /* Handle edit click */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF004D40)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "EDIT",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Navigation
        BottomNavigation()
    }
}

@Composable
fun ProfileInfoItem(label: String, value: String) {
    Column {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value.ifEmpty { "_____________________" },
            fontSize = 16.sp,
            color = if (value.isEmpty()) Color.Gray else Color.Black,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(4.dp))
        Divider(color = Color.Gray, thickness = 1.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileDetailScreenPreview() {
    ProfileDetailScreen()
}