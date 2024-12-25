package com.minelab.data.repository

import androidx.lifecycle.LiveData
import com.minelab.data.dao.KelasDao
import com.minelab.data.entity.KelasPraktikum
import com.minelab.data.remote.ApiService

class KelasRepository (
    private val apiService: ApiService,
    private val KelasDao: KelasDao
) {

    // Mendapatkan semua kelas dari API
    suspend fun getAllClasses(): List<KelasPraktikum> {
        return apiService.getAllClasses()
    }

    // Menambahkan kelas baru ke API
    suspend fun addClass(classEntity: KelasPraktikum) {
        val response = apiService.addClass(classEntity)
        if (response.isSuccessful) {
            // Simpan ke database lokal jika dibutuhkan
            KelasDao.insertKelas(response.body()!!)
        }
    }

    // Memperbarui kelas di API
    suspend fun updateClass(id: Int, classEntity: KelasPraktikum) {
        val response = apiService.updateClass(id, classEntity)
        if (response.isSuccessful) {
            // Update database lokal jika dibutuhkan
            KelasDao.updateKelas(response.body()!!)
        }
    }




}