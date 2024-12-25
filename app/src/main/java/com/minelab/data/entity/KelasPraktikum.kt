package com.minelab.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kelas_praktikum")
data class KelasPraktikum(
    @PrimaryKey val id_kelas: String,
    val nama_kelas: String,
    val deskripsi: String
)