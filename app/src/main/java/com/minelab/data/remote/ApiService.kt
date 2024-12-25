package com.minelab.data.remote


import com.minelab.data.entity.Absensi
import com.minelab.data.entity.KelasPraktikum
import com.minelab.data.entity.TugasPraktikum
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val userId: String, val name: String, val token: String)

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("classes")
    suspend fun getAllClasses(): List<KelasPraktikum>

    @POST("classes")
    suspend fun addClass(@Body classEntity: KelasPraktikum): Response<KelasPraktikum>

    @PUT("classes/{id}")
    suspend fun updateClass(@Path("id") id: Int, @Body classEntity: KelasPraktikum): Response<KelasPraktikum>

    @DELETE("classes/{id}")
    suspend fun deleteClass(@Path("id") id: Int): Response<Unit>

    // CRUD Tugas Praktikum Instruksi
    @GET("assignments")
    suspend fun getAllAssignments(): List<TugasPraktikum>

    @POST("assignments")
    suspend fun addAssignment(@Body assignmentEntity: TugasPraktikum): Response<TugasPraktikum>

    @PUT("assignments/{id}")
    suspend fun updateAssignment(@Path("id") id: Int, @Body assignmentEntity: TugasPraktikum): Response<TugasPraktikum>

    @DELETE("assignments/{id}")
    suspend fun deleteAssignment(@Path("id") id: Int): Response<Unit>

    // CRUD Absensi
    @GET("attendance")
    suspend fun getAllAttendance(): List<Absensi>

    @POST("attendance")
    suspend fun addAttendance(@Body attendanceEntity: Absensi): Response<Absensi>

    @PUT("attendance/{id}")
    suspend fun updateAttendance(@Path("id") id: Int, @Body attendanceEntity: Absensi): Response<Absensi>

    @DELETE("attendance/{id}")
    suspend fun deleteAttendance(@Path("id") id: Int): Response<Unit>
}
