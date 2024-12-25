package com.minelab.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minelab.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceResponseScreen(
    onNavigateBack: () -> Unit,
    onEditResponse: (String) -> Unit,
    onDeleteResponse: (String) -> Unit,
    responses: List<StudentResponse> = emptyList()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // Top Bar
        TopAppBar(
            title = { },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFE0E0E0)
            )
        )

        // Header
        ClassHeader()

        // Content
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                MeetingInfo()
            }

            item {
                Text(
                    text = "Response:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(responses.ifEmpty { emptyList() }) { response ->
                ResponseItem(
                    response = response,
                    onEditClick = { onEditResponse(response.email) },
                    onDeleteClick = { onDeleteResponse(response.email) }
                )
            }
        }
    }
}

@Composable
private fun ClassHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE0E0E0))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.prak_datmin_1),
            contentDescription = "Class Icon",
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = "Practicum Class - B 2024",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Tuesday, 11.00 - 12.00 A.M",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
private fun MeetingInfo() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Pertemuan 1",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Silahkan melakukan absensi dengan mengaktifkan location dan mengisi form absensi.",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Due Date",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "22 Oktober 2024, 11.59 A.M",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(
                    text = "1. RPS",
                    fontSize = 14.sp
                )
                Text(
                    text = "2. CPMK",
                    fontSize = 14.sp
                )
                Text(
                    text = "3. Kontrak Perkuliahan",
                    fontSize = 14.sp
                )
                Text(
                    text = "4. Konsep",
                    fontSize = 14.sp
                )
            }
        }
    }
}

data class StudentResponse(
    val email: String
)

@Composable
private fun ResponseItem(
    response: StudentResponse,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.prak_datmin_1),
                    contentDescription = "File",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = response.email,
                    fontSize = 14.sp
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(onClick = onEditClick) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = Color(0xFF4CAF50)
                    )
                }

                IconButton(onClick = onDeleteClick) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color.Red
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AttendanceResponseScreenPreview() {
    // Example responses for preview
    val previewResponses = listOf(
        StudentResponse("2010_fadli@student.unand.ac.id"),
        StudentResponse("3004_fajrin@student.unand.ac.id"),
        StudentResponse("2030_lara@student.unand.ac.id")
    )

    AttendanceResponseScreen(
        onNavigateBack = {},
        onEditResponse = {},
        onDeleteResponse = {},
        responses = previewResponses
    )
}