package com.minelab.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.minelab.data.entity.TugasPraktikum

@Dao
interface TugasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTugas(tugas: TugasPraktikum)

    @Update
    suspend fun updateTugas(tugas: TugasPraktikum)

    @Delete
    suspend fun deleteTugas(tugas: TugasPraktikum)

    @Query("DELETE FROM tugas_praktikum WHERE 'id' = :id")
    suspend fun deleteTugasById(id: Int)

    @Query("SELECT * FROM tugas_praktikum WHERE id_kelas = :kelasId")
    suspend fun getTugasByKelas(kelasId: String): List<TugasPraktikum>
}
