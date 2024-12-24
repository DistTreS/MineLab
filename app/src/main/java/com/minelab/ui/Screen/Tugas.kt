package com.minelab.ui.Screen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minelab.R


@Composable
fun TugasScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Practicum Class - B 2024",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Tuesday, 11.00 - 12.00 A.M\nSI Seminar Room",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Description
        Text(
            text = "is a data mining practicum class to learn the application of the theory learned in class and will be taught by a labor assistant.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Class Material
        Text(
            text = "Class Material",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(2) {
                ClassMaterialItem(name = "Material Name $it", modified = "22 Oktober 2024")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Add material */ }) {
            Icon(Icons.Default.Add, contentDescription = "Add Material")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Add")
        }
        Spacer(modifier = Modifier.height(24.dp))

        // Member of Class
        Text(
            text = "Member of Class",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(5) {
                MemberItem(name = "Budi", nim = "2411522010")
            }
        }
    }
}

@Composable
fun ClassMaterialItem(name: String, modified: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_folder), // Ikon PNG folder
            contentDescription = "Folder Icon",
            tint = Color.Blue,
            modifier = Modifier.size(24.dp) // Atur ukuran ikon
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = name, style = MaterialTheme.typography.bodyLarge)
            Text(
                text = "Modified: $modified",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
        IconButton(onClick = { /* TODO: Delete material */ }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}

@Composable
fun MemberItem(name: String, nim: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$name - $nim",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = { /* TODO: Remove member */ }) {
            Icon(
                Icons.Default.Delete,
                contentDescription = "Remove Member",
                tint = Color.Red
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTugasScreen() {
    MaterialTheme {
        TugasScreen()
    }
}

