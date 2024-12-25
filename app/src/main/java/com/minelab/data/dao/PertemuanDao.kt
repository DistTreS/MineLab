package com.minelab.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.minelab.data.entity.PertemuanPraktikum

@Dao
interface PertemuanDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPertemuan(pertemuan: PertemuanPraktikum)

    @Update
    suspend fun updatePertemuan(pertemuan: PertemuanPraktikum)

    @Delete
    suspend fun deletePertemuan(pertemuan: PertemuanPraktikum)

    @Query("SELECT * FROM pertemuan_praktikum WHERE id_kelas = :kelasId")
    suspend fun getPertemuanByKelas(kelasId: String): List<PertemuanPraktikum>
}
