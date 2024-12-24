package com.minelab.ui.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditIntructionScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Intruksi") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFFE3F2FD)) // Latar belakang biru muda
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card for Class Information
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFBBDEFB)) // Warna biru
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Kelas B\n2024",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color(0xFF0D47A1),
                        lineHeight = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            // Form Upload Material
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)) // Latar belakang hijau muda
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Judul Form
                    Text(
                        text = "Form Edit Intruksi ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0D47A1)
                    )

                    Text(
                        text = "Please upload the file that is used as an instruction",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    // Name File Input
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /* Handle name input */ },
                        label = { Text("Name File") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /* Handle name input */ },
                        label = { Text("Due date") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /* Handle name input */ },
                        label = { Text("Deskrpsi") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Button Upload (Menggantikan Ikon Upload)
                    Button(
                        onClick = { /* Handle file upload */ },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBBDEFB))
                    ) {
                        Text(
                            text = "Upload",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0D47A1)
                        )
                    }

                    // Save Button
                    Button(
                        onClick = { /* Handle save action */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1))
                    ) {
                        Text(
                            text = "Save",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEditIntructionScreen() {
    MaterialTheme {
        EditIntructionScreen()
    }
}
