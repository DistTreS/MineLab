package com.minelab.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.minelab.data.entity.Absensi

@Dao
interface AbsensiDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAbsensi(absensi: Absensi)

    @Update
    suspend fun updateAbsensi(absensi: Absensi)

    @Delete
    suspend fun deleteAbsensi(absensi: Absensi)

    @Query("SELECT * FROM absensi WHERE id_pertemuan = :pertemuanId")
    suspend fun getAbsensiByPertemuan(pertemuanId: String): List<Absensi>
}
