package com.minelab.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "pertemuan_praktikum",
    foreignKeys = [
        ForeignKey(entity = KelasPraktikum::class, parentColumns = ["id_kelas"], childColumns = ["id_kelas"]),
        ForeignKey(entity = User::class, parentColumns = ["id_user"], childColumns = ["id_user"])
    ]
)
data class PertemuanPraktikum(
    @PrimaryKey val id_pertemuan: String,
    val id_kelas: String,
    val id_user: String,
    val tanggal_pertemuan: String,
    val hari_pertemuan: String
)
