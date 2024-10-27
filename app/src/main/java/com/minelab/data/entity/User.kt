package com.minelab.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey val id_user: String,
    val nim: String,
    val name: String,
    val email: String,
    val password: String,
    val role: String
)