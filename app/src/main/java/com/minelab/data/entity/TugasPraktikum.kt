package com.minelab.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "tugas_praktikum",
    foreignKeys = [
        ForeignKey(entity = KelasPraktikum::class, parentColumns = ["id_kelas"], childColumns = ["id_kelas"]),
        ForeignKey(entity = User::class, parentColumns = ["id_user"], childColumns = ["id_user"])
    ]
)
data class TugasPraktikum(
    @PrimaryKey val id_tugas: String,
    val id_kelas: String,
    val id_user: String,
    val instruksi: String,
    val deadline: String
)
