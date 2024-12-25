package com.minelab.data.repository

import com.minelab.data.dao.TugasDao
import com.minelab.data.entity.TugasPraktikum
import com.minelab.data.remote.ApiService

class TugasRepository (
    private val apiService: ApiService,
    private val TugasDao: TugasDao
) {

    suspend fun getAllAssignments(): List<TugasPraktikum> {
        return apiService.getAllAssignments()
    }

    suspend fun addAssignment(assignmentEntity: TugasPraktikum) {
        val response = apiService.addAssignment(assignmentEntity)
        if (response.isSuccessful) {
            TugasDao.insertTugas(response.body()!!)
        }
    }

    suspend fun updateAssignment(id: Int, assignmentEntity: TugasPraktikum) {
        val response = apiService.updateAssignment(id, assignmentEntity)
        if (response.isSuccessful) {
            TugasDao.updateTugas(response.body()!!)
        }
    }

    suspend fun deleteAssignment(id: Int) {
        val response = apiService.deleteAssignment(id)
        if (response.isSuccessful) {
            TugasDao.deleteTugasById(id)
        }
    }

}