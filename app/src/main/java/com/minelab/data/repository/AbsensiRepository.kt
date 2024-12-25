package com.minelab.data.repository

import com.minelab.data.dao.AbsensiDao
import com.minelab.data.entity.Absensi
import com.minelab.data.remote.ApiService

class AbsensiRepository (
    private val apiService: ApiService,
    private val AbsensiDao: AbsensiDao
) {

    suspend fun getAllAttendance(): List<Absensi> {
        return apiService.getAllAttendance()
    }

    suspend fun addAttendance(attendanceEntity: Absensi) {
        val response = apiService.addAttendance(attendanceEntity)
        if (response.isSuccessful) {
            AbsensiDao.insertAbsensi(response.body()!!)
        }
    }

    suspend fun updateAttendance(id: Int, attendanceEntity: Absensi) {
        val response = apiService.updateAttendance(id, attendanceEntity)
        if (response.isSuccessful) {
            AbsensiDao.updateAbsensi(response.body()!!)
        }
    }

    suspend fun deleteAttendance(id: Int) {
        val response = apiService.deleteAttendance(id)
        if (response.isSuccessful) {
            AbsensiDao.deleteAbsensiById(id)
        }
    }


}
