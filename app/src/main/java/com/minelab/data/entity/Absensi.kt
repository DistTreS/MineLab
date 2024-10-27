package com.minelab.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "absensi",
    foreignKeys = [
        ForeignKey(entity = PertemuanPraktikum::class, parentColumns = ["id_pertemuan"], childColumns = ["id_pertemuan"])
    ]
)
data class Absensi(
    @PrimaryKey val id_absensi: String,
    val id_pertemuan: String,
    val id_mahasiswa: String?,
    val status_absensi: String
)
