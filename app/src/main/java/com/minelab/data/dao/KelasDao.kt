package com.minelab.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.minelab.data.entity.KelasPraktikum

@Dao
interface KelasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKelas(kelas: KelasPraktikum)

    @Update
    suspend fun updateKelas(kelas: KelasPraktikum)

    @Delete
    suspend fun deleteKelas(kelas: KelasPraktikum)

    @Query("SELECT * FROM kelas_praktikum WHERE id_kelas = :kelasId")
    suspend fun getKelasById(kelasId: String): KelasPraktikum

    @Query("SELECT * FROM kelas_praktikum")
    suspend fun getAllKelas(): List<KelasPraktikum>
}
