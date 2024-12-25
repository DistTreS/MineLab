package com.minelab.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.minelab.data.dao.*
import com.minelab.data.entity.*

@Database(
    entities = [User::class, KelasPraktikum::class, TugasPraktikum::class, PertemuanPraktikum::class, Absensi::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun kelasDao(): KelasDao
    abstract fun tugasDao(): TugasDao
    abstract fun pertemuanDao(): PertemuanDao
    abstract fun absensiDao(): AbsensiDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "praktikum_database"
                )
                    .fallbackToDestructiveMigration() // Menghapus data lama jika versi berubah
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
